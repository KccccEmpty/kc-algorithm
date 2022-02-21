package base.bucketSort;

public class RadixSort {
    /**
     * 基数排序
     */
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxBits(arr));
    }

    public static void radixSort(int[] arr, int l, int r, int digit) {
        final int radix = 10;
        int i = 0, j = 0;
        // 有多少数准备多少辅助空间
        int[] bucket = new int[l - r + 1];
        // 有多少位就进出多少次
        for (int d = 1; d <= digit; d++) {
            // 10个空间
            // count[0]当前位(d位)是0的数字有多少个
            // count[1]当前位(d位)是(0和1)的数字有多少个
            // count[2]当前位(d位)是(0、1和2)的数字有多少个
            // count[i]当前位(d位)是(0~i)的数字有多少个
            int[] count = new int[radix];
            // 求出每个数在 第 d 位的 值，并在count中计数
            for (i = l; i < r; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            // 计算前缀和
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
            // 入桶 从右往左，最后进桶，最后出桶在一片中的最后一个位置
            for (i = r; i > l; i-- ) {
                j = getDigit(arr[i], d);
                // 放在当前位为 j 的一片中最后一个位置
                bucket[count[j] - 1] = arr[i];
                // 入桶一个后，计数减 1
                count[j]--;
            }
            // 出桶，存入原数组
            for (i = l, j = 0; i <= r; i++, j++) {
                arr[i] = bucket[j];
            }

        }
    }

    public static int maxBits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int cur : arr) {
            max = Math.max(cur, max);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    // 获得数字 x 在 第 d 位的值
    public static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }
}
