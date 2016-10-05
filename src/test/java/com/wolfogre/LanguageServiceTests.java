package com.wolfogre;

import com.wolfogre.service.LanguageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * Created by wolfogre on 10/5/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LanguageServiceTests {

    @Autowired
    LanguageService languageService;

    @Test
    public void testGetLanguageList() {
        List<Map.Entry<String, String>> languageList = languageService.getLanguageList();
        for(Map.Entry<String, String> it: languageList) {
            System.out.println(it.getKey() + "-----" + it.getValue());
        }
    }
}
