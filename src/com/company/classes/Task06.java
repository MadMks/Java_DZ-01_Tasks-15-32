package com.company.classes;

// 6.	Дана строка.
// Заменить все ссылки и email на *****
// (количество звездочек равно длине заменяемого фрагмента).
// Примеры ссылок: www.site.com, http://site.com и т.п.
// Решить двумя способами:
// - с использованием регулярных выражений
// - и без.
// - Сравнить скорости работы.

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task06 {

    private String text = "";
    private String regexStr = "";
    private long elapsedTime;

    public Task06(){
        text = "Ссылка 1: site.com" +
                ", ссылка 2: www.site2.com" +
                ", ссылка 3: http://site3.com" +
                ", ссылка 4: https://site4.com" +
                ", email: mail@site.com";
        regexStr = "(" +
                "([a-qA-Q0-9]*@)" +
                "|([a-qA-Q0-9]*)" +
                "|((http|ftp|https):\\/\\/)" +
                ")" +
                "([\\w_-]+(?:(?:\\.[\\w_-]+)+))" +
                "([\\w.,@?^=%&:\\/~+#-]*[\\w@?^=%&\\/~+#-])?";
    }
    public void Start() {
        System.out.println("= Дана строка:");
        System.out.println(text);

        System.out.println("\n--- Метод с помощью регулярных выражений.");
        System.out.println("= Строка после замены ссылок и email на *****:");
        System.out.println(ReplaceLinksEmailWithRegex(text));
        System.out.print("= Время выполнения метода: " + elapsedTime + "мс.");


        System.out.println("\n\n--- Метод без регулярных выражений.");
        System.out.println("= Строка после замены ссылок и email на *****:");
        System.out.println(ReplaceLinksEmail(text));
        System.out.print("= Время выполнения метода: " + elapsedTime + "мс.");
    }

    private String ReplaceLinksEmailWithRegex(String str) {

        long startTime = System.currentTimeMillis();


        Pattern pattern = Pattern.compile(regexStr);
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()){
            String newStr =
                new String(
                    new char[matcher.group().length()])
                    .replace('\0', '*');

            str = str.replaceFirst(regexStr, newStr);
        }

        
        long stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;

        return str;
    }

    private String ReplaceLinksEmail(String str) {

        long startTime = System.currentTimeMillis();



        long stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;

        return "TODO: строку передать";
    }
}
