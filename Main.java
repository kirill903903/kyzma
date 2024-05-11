package com.company;

import java.util.Random;
import java.util.Scanner;

interface Sorter{
    boolean sort(int n);
}

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array = inputArr(10);
        Sorter ascSort = x -> x == 1;
        Sorter descSort = x -> x == 0;
        print(array);
        System.out.println("Выберите способ сортировки: 1 - по возрастанию, 0 - по убыванию");
        int choice = input.nextInt();
        if (choice == 1) {
            print(combSort(array, ascSort));
        }
        if (choice == 0) {
            print(combSort(array, descSort));
        }
    }

    public static int[] inputArr(int n) {
        Random random = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(10);
        }
        return array;
    }

    static void print(int[] array){
        for(int i : array)
            System.out.print(i + " ");

        System.out.println();
    }
    public static int[] combSort(int[] array, Sorter sorter) {
        int gap = array.length;
        while (gap != 1) {
            if (gap > 1) {
                gap /= 1.25;
            } else {
                gap = 1;
            }
            if (sorter.sort(1)) {
                for (int i = gap; i < array.length; i++) {
                    if (array[i - gap] > array[i]) {
                        int tmp = array[i];
                        array[i] = array[i - gap];
                        array[i - gap] = tmp;
                    }
                }
            }
            if (sorter.sort(0)) {
                for (int i = gap; i < array.length; i++) {
                    if (array[i - gap] < array[i]) {
                        int tmp = array[i];
                        array[i] = array[i - gap];
                        array[i - gap] = tmp;
                    }
                }
            }
        }
        return array;
    }
}