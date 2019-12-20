package com.pansoft.manager;


import java.util.List;


import com.pansoft.db.SaveByCSV;
import com.pansoft.download.NetUtil;
import com.pansoft.download.WebPageDownLoad;
import com.pansoft.neo4j.Import;
import com.pansoft.parser.DateFromatUtil;
import com.pansoft.parser.WebPageParser;
import com.pansoft.pojo.MovieEntity;
import com.pansoft.ui.UIManager;

/**
 * 接受前面传过来的url，交给后面的down层
 * @author admin
 *
 */
public class ScheduleManager {
    public static void produceUrlTaskByseed() {
        int start = 0 ;
        String url = UIManager.getURL() + start ;
        int i = 0;
        while(i++ <100) {
            String htmlSource = WebPageDownLoad.getHtmlSourceBySocket(url);
            List<MovieEntity> movieList = WebPageParser.getResult(htmlSource);
            SaveByCSV.save(movieList);
            Import.importData();
            start += 20;
            //日志打印
            System.out.println(DateFromatUtil.getCurrentDate()+"\t" 
                    + NetUtil.getresponseSize(url) + "\t第" + start +"条数据已入库");
            
            int lastIndexOf = url.lastIndexOf("=");
            int index = url.length() - lastIndexOf ;
            url = url.substring(0 , url.length() - index + 1) + start;
        }
    }
    public static void main(String[] args) {
        produceUrlTaskByseed();
    }
}
