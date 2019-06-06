package com.company.classes;

// 3.	Дан массив.
// Перемешать его элементы случайным образом так,
// чтобы каждый элемент оказался на новом месте.

import java.util.ArrayList;

public class Task03 {

    private int[] array = new int[] {1, 2, 3, 4, 5};
    private ArrayList arrIndexes = new ArrayList();


    public void Start() {
        System.out.print("\nМассив: ");
        ShowArray();

        MixItems();

        System.out.print("Перемешанный массив: ");
        ShowArray();
    }

    private void MixItems() {
        int[] tempArr = new int[array.length];
        int rand;
        int index;
        boolean isReMix;

        do{
            isReMix = false;
            FillArrayWithIndexes();

            for (int i = 0; i < array.length; i++){
                rand = GetRandomIndex();
                index = (int)arrIndexes.get(rand);

                // Если остался один элемент который стоял на этом же месте,
                // перераспределим элементы по новой.
                if (arrIndexes.size() == 1 && index == i){
                    isReMix = true;
                    break;
                }

                if (i == index){
                    i--;
                    continue;
                }
                else if (i != index){
                    tempArr[index] = array[i];
                    arrIndexes.remove(rand);
                }
            }

        } while (isReMix);

        array = tempArr;
    }

    private void FillArrayWithIndexes() {
        arrIndexes.clear();
        for (int i = 0; i < array.length; i++){
            arrIndexes.add(i);
        }
    }

    private void ShowArray() {
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]);
        }
        System.out.println();
    }

    private int GetRandomIndex() {

        return (int) (Math.random() * arrIndexes.size());
    }
}
