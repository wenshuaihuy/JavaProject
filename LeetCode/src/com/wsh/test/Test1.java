package com.wsh.test;

/**
 * @author wsh
 */
public class Test1 {
    public static void main(String[] args) {
//        System.out.println("hello!!");
        int[] ints = {1,1,1,2,2,3,3,4};
        printOddTimesNum(ints);
    }

    /**
     * 找出一个有序数组中出现奇数次数的两个数
     */
    public static void printOddTimesNum(int[] arr){
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
            if ((rightOne & i1) == 0){
                onlyOne ^= i1;
            }
        }
        System.out.println(onlyOne +"   " + (onlyOne^ero));



    }



}
