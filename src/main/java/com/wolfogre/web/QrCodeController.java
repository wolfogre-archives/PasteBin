package com.wolfogre.web;

import com.wolfogre.service.QrCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by wolfogre on 10/9/16.
 */
@Controller
public class QrCodeController {
    @Autowired
    QrCodeService qrCodeService;

    private byte[] errorImage;

    public QrCodeController() throws IOException {
        InputStream fileInputStream = new ClassPathResource("static/img/qr-error.png").getInputStream();
        errorImage = new byte[fileInputStream.available()];
        fileInputStream.read(errorImage);
        fileInputStream.close();
    }

    // TODO:参考http://www.baeldung.com/spring-mvc-image-media-data，但是好像不是很优雅
    @RequestMapping("/qr.png")
    @ResponseBody
    public byte[] qr(String content) {
        if(content == null || content.isEmpty())
            return errorImage;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if(qrCodeService.getQrCode(content, 300, byteArrayOutputStream)) {
            return byteArrayOutputStream.toByteArray();
        }
        return errorImage;
    }
}
