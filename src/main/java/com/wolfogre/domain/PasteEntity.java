package com.wolfogre.domain;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;

/**
 * Created by wolfogre on 10/5/16.
 */
@Entity
@Table(name = "paste")
public class PasteEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "time", nullable = false)
    private Date time;

    @Column(name = "ip", nullable = false, length = 15)
    private String ip;

    @Column(name = "code", nullable = false)
    private Blob code;

    public PasteEntity(){

    }

    public PasteEntity(Integer id, String name, Date time, String ip, Blob code) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.ip = ip;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Blob getCode() {
        return code;
    }

    public void setCode(Blob code) {
        this.code = code;
    }
}
