package com.pansoft.ui;

public class UIManager {
    
    /**
     * 读取文件得到url列表
     * @return list
     * @throws Exception
     */
    public static String getURL() {
        try {
            String filePath = "url.txt";
            String charset = "UTF-8";
            return ReadURLFromFile.getFileLine(filePath, charset);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    
}
