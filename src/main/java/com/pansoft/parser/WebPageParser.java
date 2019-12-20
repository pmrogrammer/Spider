package com.pansoft.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import com.pansoft.pojo.MovieEntity;

public class WebPageParser {

    public static List<MovieEntity> getResult(String webPageSource) {
        List<MovieEntity> movieList = new ArrayList<MovieEntity>();
        String regexMovie = "\\{([\\s\\S]*?)\\}";
        Matcher matherMovie = PatternUtil.mather(webPageSource, regexMovie);
        while (matherMovie.find()) {
            MovieEntity movie = new MovieEntity();
            String MovieSource = matherMovie.group(1);
            // 解析导演
            String regexDirectors = "\"directors\":\\[([\\s\\S]*?)\\],";
            Matcher matcherDirectors = PatternUtil.mather(MovieSource,regexDirectors);
            if (matcherDirectors.find()) {
                String directors = matcherDirectors.group(1);
                // 分割多个导演
                String regexCharacter = "\"([\\s\\S]*?)\"";
                Matcher matcherCharacter = PatternUtil.mather(directors,regexCharacter);
                List<String> directorList = new ArrayList<String>();
                while (matcherCharacter.find()) {
                    String director = matcherCharacter.group(1);
                    directorList.add(director);
                }
                movie.setDirectors(directorList);
            }
            // 解析标题
            String regexTitle = "\"title\":\"([\\s\\S]*?)\",";
            Matcher matcherTitle = PatternUtil.mather(MovieSource, regexTitle);
            if (matcherTitle.find()) {
                movie.setTitle(matcherTitle.group(1));
            }
            //解析评分
            String regexRate = "\"rate\":\"([\\s\\S]*?)\",";
            Matcher matcherRate = PatternUtil.mather(MovieSource, regexRate);
            if(matcherRate.find()) {
                movie.setRate(matcherRate.group(1));;
            }
            //解析演员
            String regexCasts = "\"casts\":\\[([\\s\\S]*?)\\],";
            Matcher matcherCasts = PatternUtil.mather(MovieSource,regexCasts);
            if (matcherCasts.find()) {
                String castses = matcherCasts.group(1);
                // 分割多个演员
                String regexCharacter = "\"([\\s\\S]*?)\"";
                Matcher matcherCharacter = PatternUtil.mather(castses,regexCharacter);
                List<String> castsList = new ArrayList<String>();
                while (matcherCharacter.find()) {
                    String casts = matcherCharacter.group(1);
                    castsList.add(casts);
                }
                movie.setCasts(castsList);
            }
            movieList.add(movie);
        }

        return movieList;
    }
}
