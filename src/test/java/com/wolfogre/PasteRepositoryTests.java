package com.wolfogre;

import com.wolfogre.dao.PasteRepository;
import com.wolfogre.service.PasteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

/**
 * Created by wolfogre on 10/6/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PasteRepositoryTests {

    @Autowired
    PasteRepository pasteRepository;

    @Test
    public void testGetCountInTimePeriod() {
        System.out.println(pasteRepository.getCountInTimePeriod("127.0.0.1",
                new Date(new java.util.Date(2016 - 1900, 10 - 1, 6, 17, 0, 0).getTime()),
                new Date(new java.util.Date(2016 - 1900, 10 - 1, 6, 18, 0, 0).getTime())));

    }
}
