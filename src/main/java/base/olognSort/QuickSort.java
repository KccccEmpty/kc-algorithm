package base.olognSort;

public class QuickSort {
    /**
     * 快速排序
     * 时间复杂度：O(N * logN） 空间复杂度：O（logN）
     * 无稳定性，如果一定要稳定性，非常难，论文级别
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            // 随机选一个数放在最后一位
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            // 根据最后一个数做partition
            int[] p = partition(arr, l, r);
            // 左右两边分别做同样步骤递归
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[0] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                // arr[l]小于 num 时将 arr[l] 和 < num 区域的下一个数字交换，区域扩大，即 ++less
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                // arr[l]大于 num 时将 arr[l] 和 > num 区域的上一个数字交换，区域扩大，即 --more
                // 为什么 l 没有加1呢，因为此时交换过来的值，还没看，所以 l不能动，需要看这个交换过来的值
                swap(arr, --more, l);
            } else {
                // 等于时 直接跳下一个
                l++;
            }
        }
        // 将最后一个值与 > 区域的第一个值进行交换，即放在等于区域的最后一个位置
        swap(arr, more, r);
        // 返回等于 num 区域的端点值
        return new int[] {less + 1, more};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
