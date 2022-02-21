package base.bucketSort;

public class CountSort {
    /**
     * 计数排序
     */
    public static void countSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int max = Integer.MIN_VALUE;
        // 求出数组中最大数
        for (int cur : arr) {
            max = Math.max(max, cur);
        }
        // 申请一个“桶” ，范围在 0 - max + 1；
        int[] bucket = new int[max + 1];
        for (int cur : arr) {
            // 对范围中出现的每个数进行计数，出现一次就 +1
            bucket[cur]++;
        }
        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            // 依次将每个数赋给原数组
            if (bucket[j]-- > 0 ) {
                arr[i++] = j;
            }
        }
    }
}
