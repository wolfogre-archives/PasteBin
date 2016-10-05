package com.wolfogre.service;

import com.wolfogre.dao.PasteRepository;
import com.wolfogre.domain.PasteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.lang.annotation.Annotation;
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
}
