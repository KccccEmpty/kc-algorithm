package base.binarysearch;

public class BSNearLeft {
    /**
     * 二分法的详解与扩展
     * 2）在一个有序数组中，找 >= 某个数最左侧的位置
     */
    public static int nearestIndex(int[] arr, int value) {
        int L = 0;
        int R = arr.length - 1;
        int index = -1;
        int mid;
        while (L < R) {
            mid = L + ((R - L) >> 1);
            if (arr[mid] > value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }
}
