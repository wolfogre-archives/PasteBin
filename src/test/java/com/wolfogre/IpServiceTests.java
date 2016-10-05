package com.wolfogre;

import com.wolfogre.service.IpService;
import com.wolfogre.service.LanguageService;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wolfogre on 10/5/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IpServiceTests {
    @Autowired
    IpService ipService;

    @Test
    public void testIsIp() {
        ArrayList<String> tests = new ArrayList<>();
        tests.add(null);
        tests.add("");
        tests.add("0.0.0.0");
        tests.add("255.255.255.255");
        tests.add("256.1.1.1");
        tests.add("255.1.1.1");
        tests.add("a255.1.1.1");
        tests.add("255.1.1.1 ");
        for(String it : tests)
            System.out.println(it + "   " + ipService.isIp(it));
    }

//    Need public unescapeUnicode()
//    @Test
//    public void testUnescapeUnicode() {
//        System.out.println(ipService.unescapeUnicode("{\"code\":0,\"data\":{\"country\":\"\\u7f8e\\u56fd\",\"country_id\":\"US\",\"area\":\"\",\"area_id\":\"\",\"region\":\"\",\"region_id\":\"\",\"city\":\"\",\"city_id\":\"\",\"county\":\"\",\"county_id\":\"\",\"isp\":\"\",\"isp_id\":\"\",\"ip\":\"8.8.8.8\"}}"));
//
//    }

    @Test
    public void testGetIpLocation() {
        try {
            System.out.println(ipService.getIpLocation("223.5.5.5"));
            System.out.println(ipService.getIpLocation("101.94.216.45"));
            System.out.println(ipService.getIpLocation("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
