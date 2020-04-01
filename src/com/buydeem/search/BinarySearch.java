package com.buydeem.search;

/**
 * @author zengchao
 * @version 1.0.0
 * @ClassName BinarySearch.java
 * @Description 二分查找法
 * @createTime 2020年04月01日 22:14:00
 */
public class BinarySearch {
    public static void main(String[] args) {
        int total = 100;
        int[] array = new int[total];
        for (int i = 0; i < total; i++) {
            array[i] = i;
        }
        int index = search(array, 2);
        if (index != -1) {
            System.out.println("find data index = " + index);
        } else {
            System.out.println("not find");
        }
    }

    public static int search(int[] array, int data) {
        int low = 0;
        int high = array.length - 1;
        int middle;
        int count = 1;
        while (low <= high) {
            // middle = (low + high) / 2; 使用该方式算middle可能会导致索引越位
            middle = (high - low) / 2 + low;
            System.out.println(String.format("count = %d ; low[%d] = %d ; middle[%d] = %d ; high[%d] = %d ; find = %d", count, low, array[low], middle, array[middle], high, array[high], data));
            if (data < array[middle]) {
                high = middle - 1;
            } else if (data > array[middle]) {
                low = middle + 1;
            } else {
                return middle;
            }
            count++;
        }
        return -1;
    }
}
