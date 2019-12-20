package com.pansoft.download;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

public class WebPageDownLoad {
    public static String getHtmlSourceBySocket(String url) {
        StringBuilder stringBuilder = new StringBuilder();
        InputStream inputStream = NetUtil.getInputStream(url);
        BufferedReader reader = NetUtil.getBufferedReader(inputStream);
        String temp = null;
        int lineCounter = 0;
        try {
            while ((temp = reader.readLine()) != null) {
                if (lineCounter > 0) {
                    stringBuilder.append("\n");
                }
                lineCounter++;
                stringBuilder.append(temp);
            }
            reader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

}
