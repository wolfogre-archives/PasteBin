package com.wolfogre.web;

import com.wolfogre.service.QrCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by wolfogre on 10/9/16.
 */
@Controller
public class QrCodeController {
    @Autowired
    QrCodeService qrCodeService;

    private byte[] errorImage;

    public QrCodeController() throws IOException {
        // TODO：Big Bug! 部署时文件路径一定有问题
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/static/img/qr-error.png");
        errorImage = new byte[fileInputStream.available()];
        fileInputStream.read(errorImage);
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
