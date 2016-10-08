package com.wolfogre;

import com.wolfogre.dao.PasteRepository;
import com.wolfogre.service.QrCodeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Date;

/**
 * Created by wolfogre on 10/9/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class QrCodeServiceTests {
    @Autowired
    QrCodeService qrCodeService;

    @Test
    public void testGetQrCode() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("target/testout.png");
            qrCodeService.getQrCode("http://blog.wolfogre.com/音乐", 300, fileOutputStream);
            fileOutputStream.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
