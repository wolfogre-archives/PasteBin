package com.wolfogre.web;

import com.wolfogre.service.IpService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by wolfogre on 10/6/16.
 */
@RestController
public class IpLocationController {
    @Autowired
    IpService ipService;

    @RequestMapping("/location")
    public String location(String ip) {
        try {
            return ipService.getIpLocation(ip, 1000);
        } catch (IOException | JSONException e) {
            return "未知";
        }
    }
}
