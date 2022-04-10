package com.wsh.test;

import java.util.Arrays;

/**
 * @author wsh
 */
public class Test1 {
    public static void main(String[] args) {
        int[] ints1 = {1, 1, 2, 2, 3, 3, 6};
        int[] ints2 = {1, 1, 1, 2, 2, 3, 3, 4};
        //找出有序数组中出现一次奇数次的数字
        printOddTimesNum1(ints1);
        //找出有序数组中出现两次奇数次的数
        printOddTimesNum2(ints2);
        //生成随机数组
        int[] ints = generateRandomArray(7, 100);
        for (int anInt : ints) {
            System.out.println("\t" + anInt);
        }
        //找出最大值 用递归
        System.out.println("maxNum===" + process(ints, 0, 6));

        //归并排序
        int[] ints3 = process2(ints, 0, 6);
        for (int i : ints3) {
            System.out.println("i3==="+i);
        }

        //小和问题
        int[] ints4 = {1,3,4,2,5};
        System.out.println("小和问题"+ process3(ints4, 0, 4));


        //快速排序
        int[] ints5 = {11,31,78,34,4,2,5};
        quickSore(ints5,0,6);
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
        int max = Math.max(leftMaxNum, rightMaxNum);
        return max;
    }

    /**
     * 归并排序
     * 先把数组分两部分，每个部分分别排序，然后讲这两部在排序，最后将排序好的数据拷贝到目标数组
     * @param arr
     * @param left
     * @param right
     */
    public static int[] process2(int[] arr, int left, int right) {
        if (left == right) {
            return null;
        }
        //>>右运算，num除以2
        int mid = left + ((right - left) >> 1);
        //左侧排序
        process2(arr, left, mid);
        //右侧排序
        process2(arr, mid + 1, right);
        //最后合并排序
        int[] merge = merge(arr, left, right, mid);
        return merge;
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

    /**
     * 小和问题
     * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和
     */
    public static int process3(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        //左侧小和
        int L = process3(arr, left, mid);
        //右侧小和
        int R = process3(arr, mid + 1, right);
        //合并以后的小和
        int M = merge2(arr, left, right, mid);
        System.out.println("L=="+L+",R=="+R+",==M=="+M);
        return L+R+M;

    }
    public static int merge2(int[] arr, int left, int right, int mid) {
        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int i = 0;
        int count = 0;
        while (p1 <= mid && p2 <= right) {
            count += arr[p1] < arr[p2] ? (right - p2 + 1) * arr[p1] : 0;
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
        return count;
    }

    /**
     * 快速排序
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSore(int[] arr, int left, int right) {
        if (left < right) {
            int l = left + (int) (Math.random() * right - left + 1);
            swap(arr, l, right);
            int[] partition =partition(arr, left, right);
            quickSore(arr, left,partition[0]-1);
            quickSore(arr, partition[1] + 1, right);

            for (int i = 0; i < arr.length; i++) {
                System.out.println("qsort===" + arr[i]);
            }
        }
    }

    private static int[] partition(int[] arr, int left, int right) {
        int less = left - 1;
        int more = right;
        while (left < more) {
            if (arr[left] < arr[right]) {
                swap(arr, ++less, left++);
            } else if (arr[left] > arr[right]) {
                swap(arr, --more, left);
            } else {
                left++;
            }
        }
        swap(arr, more, right);
        return new int[]{less + 1, more};
    }

    private static void swap(int[] arr, int left, int right) {
        int a = 0;
        a = arr[left];
        arr[left] = arr[right];
        arr[right] = a;
    }


}
