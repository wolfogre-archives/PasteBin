package com.wolfogre.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Blob;
import java.util.Date;

/**
 * Created by wolfogre on 10/5/16.
 */
@Entity
@Table(name = "paste")
public class PasteEntity {
    @Id
    private Integer id;

    private String name;

    private Date time;

    private String ip;

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
