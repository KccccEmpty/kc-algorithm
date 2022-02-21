package base.olognSort;

public class MergeSort {
    /**
     * 归并排序
     * 时间复杂度：O（N*logN） 空间复杂度：O（N）
     * 具有稳定性
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //在 L-R 范围上排序
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        //左边、右边 分别排序
        mergeSort(arr, L, mid);
        mergeSort(arr, mid + 1, R);
        //两边排序完成后，进行merge，通过一个辅助空间进行归并。
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int mid, int R) {
        //申请辅助空间
        int[] help = new int[L - R + 1];
        int i = 0;
        //采用双指针 分别指向两边的初始位置
        int p1 = L;
        int p2 = mid + 1;
        //哪边小先把哪边放到辅助函数中
        while (p1 <= mid && p2 <= R) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //下面两个循环相同，将剩余的数放进去
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        //将辅助空间中排好的值赋给原数组
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }
}
