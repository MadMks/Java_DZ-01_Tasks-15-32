package com.company.classes;

// 5.	Дано предложение.
// Заменить группы пробелов одиночными,
// крайние пробелы удалить.
// Все слова перевести в нижний регистр,
// первые буквы сделать заглавными.

public class Task05 {

    private String text = "  lOREM   IPSum  dOLOr ";

    public void Start() {
        System.out.println("Дано предложение:");
        System.out.println(text);

        text = ConvertString(text);

        System.out.println("\nПредложение после обработки:");
        System.out.println(text);
    }

    private String ConvertString(String text) {
        String tempText = "";
        tempText = text
                .trim()
                .replaceAll(" +", " ")
                .toLowerCase();
        return AllFirstLetterUpperCase(tempText);
    }

    private String AllFirstLetterUpperCase(String text){

        StringBuilder builder = new StringBuilder(text.length());
        boolean inWord = false;

        for (char c : text.toCharArray()){
            if (Character.isWhitespace(c)){
                inWord = false;
            }
            else if (!inWord){
                c = Character.toUpperCase(c);
                inWord = true;
            }
            builder.append(c);
        }

        return builder.toString();
    }
}
