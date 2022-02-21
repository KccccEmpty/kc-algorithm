package base.binarysearch;

public class BS_Exist {
    /**
     * 二分法的详解与扩展
     * 1）通过二分法在一个有序数组中，找某个数是否存在
     */
    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int mid;
        int L = 0;
        int R = sortedArr.length - 1;
        // L < R // 循环直至区间左右端点相同
        while (L < R) {
            //防止计算时溢出
            mid = L + ((R - L) >> 1);
            if (sortedArr[mid] == num) {
                return true;
            } else if (num < sortedArr[mid]) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return sortedArr[L] == num;
    }
}
