package base.easysort;

public class BubbleSort {
    /**
     * 冒泡排序
     * 从最后一个数开始，每次以当前数作为终点，将前面最大的值放到最后一位，即大数慢慢浮上来
     * 时间复杂度：O(n^2) 空间复杂度：O(1)
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i , i + 1);
                }
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
