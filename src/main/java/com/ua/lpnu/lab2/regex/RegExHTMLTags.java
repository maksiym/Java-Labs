package com.ua.lpnu.lab2.regex;

import org.apache.commons.lang.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegExHTMLTags {

    public List<String> findTextInTags(final String originalString) {

        final String htmlStringRegex = "(<span>(.+?)</span>)+|(<strong>(.+?)</strong>)+|(<table>(.+?)</table>)+";
        final String htmlTagsRemover = "(<span>|</span>|<strong>|</strong>|<table>|</table>)+";
        List<String> foundedWords = new ArrayList<>();
        String[] fW1;

        Pattern pattern = Pattern.compile(htmlStringRegex);
        Matcher matcher = pattern.matcher(originalString);

        while (matcher.find()) {
            fW1 = StringUtils.split(matcher.group().replaceAll(htmlTagsRemover, " "));
            Collections.addAll(foundedWords, fW1);
        }

        foundedWords.sort(ALPHABETICAL_ORDER);
        foundedWords.forEach(System.out::println);

        return foundedWords;
    }

    public static final Comparator<String> ALPHABETICAL_ORDER = (String str1, String str2) -> {
        int resString = String.CASE_INSENSITIVE_ORDER.compare(str1, str2);
        if (resString == 0) {
            resString = str1.compareTo(str2);
        }
        return resString;
    };

}
