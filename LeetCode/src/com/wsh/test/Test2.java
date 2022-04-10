package com.wsh.test;

/**
 * @author wsh
 * @date 2022/4/3 7:03 下午
 */
public class Test2 {
    public static void main(String[] args) {

    }

    /**
     * 新进来的数与其父节点去对比，如果比父节点的数大就进行交换保证父节点最大（从下往上换）时间复杂度o(logN)
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
     * 反悔堆中的最大值，并移除完最大值，之后保证这是一个大根堆（从上往下换）时间复杂度o(logN)
     * @param arr 堆数组
     * @param index 从哪个位置开始往下走
     * @param heapSize 最大的长度 保证左右孩子下标不越界
     */
    public static void heapify(int[] arr, int index, int heapSize) {
        //左孩子的下标
        int left = (index * 2) + 1;
        while (left < heapSize) {
            //两个孩子中谁的值大就把谁的下标给largest
            int largest = (left + 1 < heapSize) && (arr[left + 1] > arr[left]) ? left + 1 : left;
            //父亲和最大的孩子比较谁的大就把下标赋值给谁
            largest = arr[index] > arr[largest] ? index : largest;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }


    /**
     * 堆排序
     * @param arr
     */
    public static void heapsort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            //将堆变成大顶堆
            heapInsert(arr, i);
        }

        int heapSize = arr.length;
        swap(arr,0,heapSize-1);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr,0,--heapSize);


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
