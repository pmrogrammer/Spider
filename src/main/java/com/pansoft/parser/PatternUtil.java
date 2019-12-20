package com.pansoft.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternUtil {
    public static Matcher mather(String source ,String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        return matcher;
    }
}
