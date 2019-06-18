package com.company.classes;

// 4.	Куб состоит из n^3 прозрачных и непрозрачных элементарных кубиков.
// Имеется ли хотя бы один просвет по каждому из трех измерений?
// Если это так, вывести координаты каждого просвета.
// Куб задается трехмерной матрицей из 0 и 1.

import java.util.Arrays;
import java.util.LinkedList;

public class Task04 {
    private int[][][] cube;
    private LinkedList<Integer> arrTest;

    public Task04(){
        cube = new int[3][3][3];
    }

    public void Start() {

        CreatingTestData();

        FillCubes();

        CheckCubeClearance();
    }

    private void CheckCubeClearance() {
        CheckOnZ();
        CheckOnY();
        CheckOnX();
    }

    private void CheckOnZ() {
        for (int x = 0; x < cube.length; x++){
            for (int y = 0; y < cube.length; y++){

                if (cube[x][y][0] == 0){
                    for (int z = 0; z < cube.length - 1; z++){
                        if (cube[x][y][z] == cube[x][y][z + 1]){
                            // Если не предпоследний
                            if ((z + 1) != cube.length - 1){
                                // Проверим следующие кубики в массиве.
                                continue;
                            }
                            else {
                                // Проверили все кубики в массиве.
                                // Выводим результат.
                                System.out.println(" Просвет по Z плоскости");
                                System.out.println(" По координатам: " + "x = " + x + ", y = " + y);
                            }
                        }
                        else {
                            break;
                        }
                    }
                }
            }
        }
    }
    private void CheckOnY() {
        for (int x = 0; x < cube.length; x++){
            for (int z = 0; z < cube.length; z++){

                if (cube[x][0][z] == 0){
                    for (int y = 0; y < cube.length - 1; y++){
                        if (cube[x][y][z] == cube[x][y + 1][z]){
                            // Если не предпоследний
                            if ((y + 1) != cube.length - 1){
                                // Проверим следующие кубики в массиве.
                                continue;
                            }
                            else {
                                // Проверили все кубики в массиве.
                                // Выводим результат.
                                System.out.println(" Просвет по Y плоскости");
                                System.out.println(" По координатам: " + "x = " + x + ", z = " + z);
                            }
                        }
                        else {
                            break;
                        }
                    }
                }
            }
        }
    }
    private void CheckOnX() {
        for (int y = 0; y < cube.length; y++){
            for (int z = 0; z < cube.length; z++){

                if (cube[0][y][z] == 0){
                    for (int x = 0; x < cube.length - 1; x++){
                        if (cube[x][y][z] == cube[x + 1][y][z]){
                            // Если не предпоследний
                            if ((x + 1) != cube.length - 1){
                                // Проверим следующие кубики в массиве.
                                continue;
                            }
                            else {
                                // Проверили все кубики в массиве.
                                // Выводим результат.
                                System.out.println(" Просвет по X плоскости");
                                System.out.println(" По координатам: " + "y = " + y + ", z = " + z);
                            }
                        }
                        else {
                            break;
                        }
                    }
                }
            }
        }
    }


    private void CreatingTestData() {
        arrTest = new LinkedList();
        arrTest.addAll(Arrays.asList(
                0,0,1,
                0,1,1,
                1,0,1,
                1,1,0,
                0,0,0,
                1,1,1,
                1,0,0,
                0,1,0,
                1,0,0
        ));
    }

    private void FillCubes() {
        for (int x = 0; x < cube.length; x++){
            for (int y = 0; y < cube.length; y++){
                for (int z = 0; z < cube.length; z++){
                    cube[x][y][z] = arrTest.removeFirst();
                }
            }
        }
    }
}
