package com.pansoft.download;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class NetUtil {
    
    /**
     * 获取网页编码
     * @param url
     * @return String
     * @throws Exception
     */
    public static String getCharset(String url) throws Exception {
        String charset = null ;
        InputStream inputStream = getInputStream(url);
        BufferedReader br = getBufferedReader(inputStream);
        String temp = null;
        String regex = "charset=\"?(.+?)\"?\\s?/?>";
        while((temp = br.readLine()) != null ) {
            temp = temp.toLowerCase();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(temp);
            
            if(matcher.find()) {
                charset = matcher.group(1);
                break;
            }
            if(temp.contains("</head>")) {
                break; 
            }
        }
        return charset;
    }
    
   
    public static BufferedReader getBufferedReader(InputStream inputStream) {
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(inputStream , "utf-8");
            br = new BufferedReader(isr);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return br;
    }
    
    /**
     * 得到输入流
     */
    public static InputStream getInputStream (String url) {
        InputStream openStream = null;
        try {
            URL urlObj = new URL(url);
            openStream = urlObj.openStream();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return openStream;
    }
    
    public static int getresponseSize(String url) {
        InputStream inputStream = getInputStream(url);
        BufferedReader br = getBufferedReader(inputStream);
        String temp = null;
        try {
            temp = br.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return temp.length();
    }
    
    public static int getResponseCode(String url) {
        try {
            URL urlObj = new URL(url);
            URLConnection openConnection = urlObj.openConnection();
            HttpURLConnection connection = (HttpURLConnection)openConnection;
            return connection.getResponseCode();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 404;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 404;
        }
    }
//    public static void main(String[] args) throws Exception {
//        System.out.println(getCharset("http://finance.youth.cn/finance_stock/"));
////        System.out.println(getCharset("https://www.baidu.com/"));
//    }
}
