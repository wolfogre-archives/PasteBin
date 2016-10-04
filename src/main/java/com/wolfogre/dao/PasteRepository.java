package com.wolfogre.dao;

import com.wolfogre.domain.PasteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by wolfogre on 10/5/16.
 */
public interface PasteRepository extends JpaRepository<PasteEntity, Integer>{
    List<PasteEntity> findByName(String name);
}
