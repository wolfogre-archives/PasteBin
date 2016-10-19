package com.wolfogre.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wolfogre on 10/5/16.
 */
@Entity
@Table(name = "paste", indexes = {
    @Index(columnList = "ip", name = "ip_index"),
    @Index(columnList = "time", name = "time_index")
})
public class PasteEntity {
    @Id
    private Integer id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false)
    private Date time;

    @Column(nullable = false, length = 30)
    private String language;

    @Column(nullable = false, columnDefinition="MEDIUMTEXT")
    private String content;

    @Column(nullable = false, length = 15)
    private String ip;

    @Column(nullable = false, length = 50)
    private String location;

    public PasteEntity(){

    }

    public PasteEntity(Integer id, String name, Date time, String language, String content, String ip, String location) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.language = language;
        this.content = content;
        this.ip = ip;
        this.location = location;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
