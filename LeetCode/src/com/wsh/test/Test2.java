package com.wsh.test;

/**
 * @author wsh
 * @date 2022/4/3 7:03 下午
 */
public class Test2 {
    public static void main(String[] args) {

    }

    /**
     * 新进来的数与其父节点去对比，如果比父节点的数大就进行交换保证父节点最大
     * @param arr
     * @param index
     */
    public static void heapInsert(int[] arr,int index) {
        //找到父节点
        int fatherPort = (index - 1) / 2;
        //当前节点的数比父节点大的时候进行交换
        while (arr[index] > arr[fatherPort]) {
            swap(arr,arr[index],fatherPort);
            index = fatherPort;
        }
    }

    /**
     * 交换方法
     * @param arr
     * @param l
     * @param r
     */
    public static void swap(int[] arr, int l, int r) {
        int a = 0;
        a = arr[l];
        arr[l] = arr[r];
        arr[r] = a;
    }
}
