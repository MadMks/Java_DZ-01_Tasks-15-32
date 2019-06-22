package com.company.classes;

// 7.	Пользователь вводит формулу
// вида max(a,b)
// или min(a,b),
// где a,b - целые числа
// или аналогичные выражения min(), max().
// Найти значение выражения.
// Примеры:
// max(1,5) = 5,
// max(4,min(3,6)) = 4,
// min(max(1,max(5,3)),min(9,0)) = 0.

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task07 {

    private String regexStr = "";

    public Task07(){
        regexStr = "max\\(.+\\)|min\\(.+\\)";
    }

    public void Start() {

        // Просим ввести формулу.
        System.out.println(" Введите формулу: ");
        Scanner formula = new Scanner(System.in);

        String text = formula.nextLine();
        int answer = 0;

        if (text.matches(regexStr)){

            answer = ComputeFormula(text);
        }
        else{
            System.out.println(" [error] - ошибка в формуле");
        }

        System.out.println("Ответ: " + answer);
    }

    private int ComputeFormula(String str) {

        if (str.matches("min\\(.+\\)")){
            return ComputeFormulaMin(str);
        }
        else if (str.matches("max\\(.+\\)")){
//            ComputeFormulaMax(str);
        }

        return 0;
    }

    private int ComputeFormulaMin(String str) {
        int a;
        int b;

        a = GetA(str);
        b = GetB(str);

        return Math.min(a,b);
    }

    private int GetB(String str) {

        Pattern pattern = Pattern.compile(",[0-9]+\\)");
        Matcher matcher = pattern.matcher(str);

        if (matcher.find()){
            String bStr = matcher.group().replaceAll("\\D+", "");
            return Integer.parseInt(bStr);
        }
        else{
            return ComputeFormula(str);
        }
    }

    private int GetA(String str) {

        Pattern pattern = Pattern.compile("\\([0-9]+,");
        Matcher matcher = pattern.matcher(str);

        if (matcher.find()){
            String aStr = matcher.group().replaceAll("\\D+", "");
            return Integer.parseInt(aStr);
        }
        else{
            return ComputeFormula(str);
        }
    }
}
