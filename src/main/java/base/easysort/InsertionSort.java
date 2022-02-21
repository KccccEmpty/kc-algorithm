package base.easysort;

public class InsertionSort {
    /**
     * 插入排序
     * 直接插入排序是无序序列插入到有序序列中，通常假定a[0]为已经排好序的子序列，
     * 然后将剩下无序序列一个一个插入到有序的子序列中。适用于基本有序和数据量不大的情况。
     * 时间复杂度：O(n^2) 空间复杂度：O(1)
     */
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    /**
     * 异或的方式进行两值互换
     */
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
