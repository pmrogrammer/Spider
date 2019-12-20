package com.pansoft.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.pansoft.pojo.MovieEntity;


/**
 * F:\neo4j\neo4j-community-3.5.5\import   要导入的目标文件夹
 * @author admin
 *
 */
public class SaveByCSV {
    
    public static OutputStreamWriter openFile(String fileName) {
        String path = "F:\\neo4j\\neo4j-community-3.5.5\\import\\" + fileName;
        File file = new File(path);
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println("创建文件夹失败");
            }
        }
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        try {
            fos = new FileOutputStream(path, false);
            osw = new OutputStreamWriter(fos, "utf-8");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return osw;
    }
    public static boolean save(List<MovieEntity> movieList) {
         return saveMovie("movie.csv",movieList) && savePerson("person.csv", movieList);
     }
     public static boolean saveMovie(String fileName , List<MovieEntity> movieList) {
         OutputStreamWriter osw = openFile(fileName);
         try {
            osw.write("title,rate"+"\n");
            for (MovieEntity movie : movieList) {
                osw.write(movie.getTitle()+","+movie.getRate()+"\n");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } finally {
            try {
                osw.flush();
                osw.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
         return true;
     }
     public static boolean savePerson(String fileName , List<MovieEntity> movieList) {
         OutputStreamWriter osw = openFile(fileName);
         try {
            osw.write("name,role,movie"+"\n");
            for (MovieEntity movie : movieList) {
                for (String director : movie.getDirectors()) {
                    osw.write(director+","+"Director,"+movie.getTitle()+"\n");
                }
                for (String casts : movie.getCasts()) {
                    osw.write(casts+","+"Play,"+movie.getTitle()+"\n");
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } finally {
            try {
                osw.flush();
                osw.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
         return true;
     }
}