package com.wolfogre.web;

import com.wolfogre.service.IpService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

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
