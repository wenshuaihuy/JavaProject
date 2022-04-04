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
        int[] ints = generateRandomArray(7, 100);
        for (int anInt : ints) {
            System.out.println("\t" + anInt);
        }
        System.out.println("maxNum===" + process(ints, 0, 6));

        process2(ints, 0, 6);
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
        int random =(int) Math.random();
//        int[] ints = new int[(int) ((maxSize + 1) * random)];
        int[] ints = new int[maxSize];
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

    /**
     * 归并排序
     * 先把数组分两部分，每个部分分别排序，然后讲这两部在排序，最后将排序好的数据拷贝到目标数组
     * @param arr
     * @param left
     * @param right
     */

    public static void process2(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        //>>右运算，num除以2
        int mid = left + ((right - left) >> 1);
        int leftMaxNum = process(arr, left, mid);
        int rightMaxNum = process(arr, mid + 1, right);
        merge(arr, left, right, mid);
    }

    /**
     * 归并排序
     * @param arr
     * @param left
     * @param right
     * @param mid
     * @return
     */
    public static int[] merge(int[] arr, int left, int right, int mid) {
        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= right) {
            help[i++] = (arr[p1] <= arr[p2]) ? arr[p1++] : arr[p2++];
        }
        while (p1<=mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        for (int i1 = 0; i1 < help.length; i1++) {
            arr[left + i1] = help[i1];
        }
        return arr;


    }


}
