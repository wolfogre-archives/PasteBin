package com.wolfogre.service;

import jdk.nashorn.api.scripting.JSObject;
import org.apache.commons.lang3.StringEscapeUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wolfogre on 10/5/16.
 */
@Service
public class IpService {
    // 参考 https://my.oschina.net/u/553266/blog/374625
    private Pattern patternIp = Pattern.compile("((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))");

    private Pattern patternUnicode = Pattern.compile("\\\\u([0-9a-zA-Z]{4})");

    public boolean isIp(String input) {
        return input != null && patternIp.matcher(input).matches();
    }

    public String getIpLocation(String input, int timeout) throws IOException, JSONException {
        if(!isIp(input))
            return "error";
        URL url = new URL("http://ip.taobao.com/service/getIpInfo.php?ip=" + input);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(timeout);
        connection.setReadTimeout(timeout);
        connection.connect();
        Scanner scanner = new Scanner(connection.getInputStream());
        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNext()) {
            stringBuilder.append(scanner.nextLine());
        }
        scanner.close();
        JSONObject jsonObject = null;
        jsonObject = new JSONObject(unescapeUnicode(stringBuilder.toString()));

        if(jsonObject.getInt("code") != 0)
            return "error";
        //TODO:最好输出一下日志

        jsonObject = jsonObject.getJSONObject("data");

        StringBuilder result = new StringBuilder();
        String[] keys = {"country", "area", "region", "city", "county", "isp"};
        for(String it : keys) {
            if(!jsonObject.getString(it).isEmpty()) {
                if(result.length() != 0)
                    result.append(":");
                result.append(jsonObject.getString(it));
            }
        }

        return result.toString();
    }

    public String getIpFromForwardedFor(String input) {
        input = input.replace(" ", "");
        if(input == null)
            return null;
        // TODO: X-FORWARDED-FOR 可能拥有多个IP，因为可能有多层代理
        // TODO: 如果服务器不存在 Nginx 代理，客户端可能伪装 X-FORWARDED-FOR，这时得不到真的IP
        if(!input.contains(","))
            return input;
        String[] splits = input.split(",");
        return splits[splits.length - 1];
    }

    private String unescapeUnicode(String input) {
        Matcher matcher = patternUnicode.matcher(input);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, Character.toString((char)Integer.parseInt(matcher.group(1), 16)));
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
