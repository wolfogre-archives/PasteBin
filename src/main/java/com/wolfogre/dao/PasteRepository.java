package com.wolfogre.dao;

import com.wolfogre.domain.PasteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

/**
 * Created by wolfogre on 10/5/16.
 */
public interface PasteRepository extends JpaRepository<PasteEntity, Integer>{
    List<PasteEntity> findByName(String name);

    @Query("SELECT MAX(p.id) FROM PasteEntity p")
    Integer getMaxId();

    @Query("SELECT COUNT(p) FROM PasteEntity p WHERE p.ip = ?1 AND p.time BETWEEN ?2 and ?3")
    Integer getCountInTimePeriod(String ip, Date start, Date end);
}
