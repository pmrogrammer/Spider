package com.pansoft.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadURLFromFile {
    
    public static String getFileLine(String path , String charset) {
        BufferedReader br = null ;
        InputStreamReader isr = null ; 
        FileInputStream fis = null ;
        try {
            File file = new File(path);
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            return br.readLine();
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
