package com.wolfogre.service;

import com.wolfogre.dao.PasteRepository;
import com.wolfogre.domain.PasteEntity;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.lang.annotation.Annotation;
import java.sql.Date;
import java.util.List;

/**
 * Created by wolfogre on 10/5/16.
 */
@Service
public class PasteService {
    @Autowired
    PasteRepository pasteRepository;

    public int getMaxId() {
        Integer maxId = pasteRepository.getMaxId();
        return maxId == null ? 0 : maxId;
    }

    public int savePaste(String name, Date time, String language, String content, String ip, String location) {
        //TODO:应该检查输入参数，有误抛异常
        //content = StringEscapeUtils.escapeHtml4(content);
        synchronized(this) {
            int id = getMaxId() + 1;
            // TODO:time参数待处理
            PasteEntity pasteEntity = new PasteEntity(id, name, time, language, content, ip, location);
            pasteRepository.save(pasteEntity);
            return id;
        }
    }

    public PasteEntity getPaste(int id) {
        return pasteRepository.getOne(id);
    }
}
