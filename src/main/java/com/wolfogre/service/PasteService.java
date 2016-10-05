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
        return pasteRepository.getMaxId();
    }

    public int savePaste(String name, Date time, String language, String ip, String content) {
        //TODO:应该检查输入参数，有误抛异常
        content = StringEscapeUtils.escapeHtml4(content);
        synchronized(this) {
            int id = pasteRepository.getMaxId() + 1;
            // TODO:time参数待处理
            PasteEntity pasteEntity = new PasteEntity(id, name, time, language, ip, content);
            pasteRepository.save(pasteEntity);
            return id;
        }
    }
}
