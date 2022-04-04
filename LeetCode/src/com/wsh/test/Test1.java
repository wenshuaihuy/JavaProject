package com.wsh.test;

import java.util.Arrays;

/**
 * @author wsh
 */
public class Test1 {
    public static void main(String[] args) {
        int[] ints1 = {1, 1, 2, 2, 3, 3, 6};
        int[] ints2 = {1, 1, 1, 2, 2, 3, 3, 4};
        printOddTimesNum1(ints1);
        printOddTimesNum2(ints2);
        int[] ints = generateRandomArray(10, 100);
        for (int anInt : ints) {
            System.out.println("\t"+anInt);
        }
        System.out.println("maxNum==="+process(ints, 0, 4));
    }


    /**
     * 找出一个有序数组中出现奇数次数的一个数
     */
    public static void printOddTimesNum1(int[] arr) {
        int ero = 0;
        for (int i = 0; i < arr.length; i++) {
            ero ^= arr[i];
        }
        System.out.println(ero);

    }


    /**
     * 找出一个有序数组中出现奇数次数的两个数
     */
    public static void printOddTimesNum2(int[] arr) {
        int ero = 0;
        for (int i = 0; i < arr.length; i++) {
            ero ^= arr[i];
        }
        //ero = a ^ b
        //ero != 0
        //提取出最右侧的1
        int rightOne = ero & (~ero + 1);
        //ero`
        int onlyOne = 0;
        for (int i1 : arr) {
            if ((rightOne & i1) == 0) {
                onlyOne ^= i1;
            }
        }
        System.out.println(onlyOne + "   " + (onlyOne ^ ero));
    }


    /**
     * Sort from system
     */
    public static void systemSort(int[] arr) {
        Arrays.sort(arr);

    }

    /**
     * create random array
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] ints = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < ints.length; i++) {
            //范围是+maxValue到-maxValue
            ints[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue) * Math.random());
        }
        return ints;
    }

    /**
     * recursively find the maximum
     */
    public static int process(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
        //>>右运算，num除以2
        int mid = left + ((right - left) >> 1);
        int leftMaxNum = process(arr, left, mid);
        int rightMaxNum = process(arr, mid + 1, right);
        return Math.max(leftMaxNum, rightMaxNum);
    }


}
