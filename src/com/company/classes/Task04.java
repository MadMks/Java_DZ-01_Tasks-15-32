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


        // TODO: заполнить (рандомно)
        FillCubes();

        // TODO: запустить проверку на просветы
        CheckCubeClearance();
        // TODO: вывести координаты каждого просвета
    }

    private void CheckCubeClearance() {
        // Проверка по z
        for (int x = 0; x < cube.length; x++){
            for (int y = 0; y < cube.length; y++){
//                if (cube[x][y][0] == 0
//                    && cube[x][y][0] == cube[x][y][1]
//                    && cube[x][y][1] == cube[x][y][2]){
//                    System.out.println(" Просвет по Z плоскости");
//                    System.out.println(" По координатам: " + "x = " + x + ", y = " + y);
//                }

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
