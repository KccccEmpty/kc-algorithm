package base.olognSort;

public class NetherlandsFlog {
    /**
     * 荷兰国旗问题：
     * 给定一个数组arr，和一个数num，请把小于num的数放在数组的 左边，等于num的数放
     * 在数组的中间，大于num的数放在数组的 右边。要求额外
     * 空间复杂度 O(1)，时间复杂度 O(N)
     */
    public static int[] partition(int[] arr, int l, int r, int num) {
        // < num 的区域指针 ，
        int less = l - 1;
        // > num 的区域指针
        int more = r + 1;
        while (l < more) {
            if (arr[l] < num) {
                // arr[l]小于 num 时将 arr[l] 和 < num 区域的下一个数字交换，区域扩大，即 ++less
                swap(arr, ++less, l++);
            } else if (arr[l] > num) {
                // arr[l]大于 num 时将 arr[l] 和 > num 区域的上一个数字交换，区域扩大，即 --more
                // 为什么 l 没有加1呢，因为此时交换过来的值，还没看，所以 l不能动，需要看这个交换过来的值
                swap(arr, --more, l);
            } else {
                // 等于时 直接跳下一个
                l++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
