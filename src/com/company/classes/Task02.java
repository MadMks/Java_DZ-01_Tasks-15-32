package com.company.classes;

import java.util.ArrayList;

// 2.	Найти количество различных элементов массива.
// Пример: для 1 4 5 1 1 3 ответ 4.

public class Task02 {

    private int[] array = new int[]{5, 2, 1, 2, 1, 0, 0};

    public void Start() {

        ShowArray();

        CountDifferentElements();

        System.out.println(
                "Кол-во различных элементов массива: " + CountDifferentElements());
    }

    private int CountDifferentElements() {
        ArrayList arrVarious = new ArrayList();

        for (int i = 0; i < array.length; i++){
            if (!arrVarious.contains(array[i])){
                arrVarious.add(array[i]);
            }
        }

        return arrVarious.size();
    }

    private void ShowArray() {
        System.out.print("\nМассив: ");
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
