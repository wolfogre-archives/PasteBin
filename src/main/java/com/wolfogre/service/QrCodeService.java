package com.wolfogre.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;

/**
 * Created by wolfogre on 10/8/16.
 */
@Service
public class QrCodeService {
    public boolean getQrCode(String content, OutputStream outputStream) {
        Hashtable<EncodeHintType, String> hints = new Hashtable<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF8");
        BitMatrix matrix;
        try {
            matrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, 300, 300, hints);
            MatrixToImageWriter.writeToStream(matrix, "png", outputStream);
        } catch (IOException e) {
            return false;
            // TODO:最好输出到日志
        } catch (WriterException e) {
            return false;
            // TODO:最好输出到日志
        }
        return true;
    }
}
