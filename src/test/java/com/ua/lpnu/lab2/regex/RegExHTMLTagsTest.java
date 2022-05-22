package com.ua.lpnu.lab2.regex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;


class RegExHTMLTagsTest {

    final String originalString = "<span>The regular expression test</span>" +
            "<strong>Something like text</strong><table>Just test</table>" +
            "<table>a b c d e f g</table>";
    final List<String> expectedFoundedWords = Arrays.asList("a", "b", "c",
            "d", "e", "expression", "f", "g", "Just", "like", "regular", "Something", "test", "test", "text", "The");


    @Test
    void findWordsInTagsTest() {

        RegExHTMLTags finder = new RegExHTMLTags();
        List<String> actList;
        actList = finder.findTextInTags(originalString);
        for (int i = 0; i < expectedFoundedWords.size(); i++) {
            Assertions.assertEquals(expectedFoundedWords.get(i), actList.get(i));
        }

    }

}