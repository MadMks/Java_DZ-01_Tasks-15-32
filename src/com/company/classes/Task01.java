package com.company.classes;

import java.util.Scanner;

// 1.	Компьютер загадывает число от 1 до n.
// У пользователя k попыток отгадать.
// После каждой неудачной попытки
// компьютер сообщает меньше или больше загаданное число.
// В конце игры текст с результатом
// (или “Вы угадали”, или “Попытки закончились”).

public class Task01 {

    private int hiddenNumber = 0;
    private int userNumber = 0;
    private int maxRange = 5;
    private int numberOfAttempts = maxRange - 1;

    public void Start() {
        hiddenNumber = GetRandomNumber();

        System.out.println(" Отгадайте загаданное число.");

        boolean isPlaying = true;
        int i = 0;

        while (isPlaying){

            userNumber = GetUserNumber();

            if (userNumber == hiddenNumber){
                isPlaying = false;
                System.out.println(" - Вы угадали.");
            }
            else if (i < numberOfAttempts){
                ShowHint();
                i++;
            }

            if (i == numberOfAttempts){
                isPlaying = false;
                System.out.println(" - Попытки закончились.");
            }
        }

        System.out.println("Загаданное число: " + hiddenNumber);
    }

    private void ShowHint() {
        if (userNumber < hiddenNumber) {
            System.out.println(" - Загаданное число больше.");
        }
        else {
            System.out.println(" - Загаданное число меньше.");
        }
    }

    private int GetUserNumber() {
        System.out.println(" Введите число: ");
        Scanner inputNumber = new Scanner(System.in);
        return inputNumber.nextInt();
    }

    private int GetRandomNumber() {
        System.out.println(" [] Компьютер загадывает число от  1 до " + maxRange);
        return 1 + (int) (Math.random() * maxRange);
    }
}
