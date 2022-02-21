package base.olognSort;

public class HeapSort {
    /**
     * 堆排序
     * 1，堆结构就是用数组实现的完全二叉树结构
     * 2，完全二叉树中如果每棵子树的最大值都在顶部就是大根堆
     * 3，完全二叉树中如果每棵子树的最小值都在顶部就是小根堆
     * 4，堆结构的 heapInsert 与 heapify 操作
     * 5，堆结构的增大和减少
     * 6，优先级队列结构，就是堆结构
     *
     * 时间复杂度：O（N * log N） 空间复杂度：O（1）
     * 没有稳定性
     */
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //每次传入的数做heapInsert，最终成为一个大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        //将第一个数和最后位置的数 做交换，然后 heapSize - 1 ，即最大值放在数组最后一位，已经排好序了
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }

    }

    /**
     * 第一次将数组转换成大根堆
     */
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 从第一个数向下构造大根堆
     */
    public static void heapify(int[] arr, int index, int heapSize) {
        // 左孩子
        int left = index * 2 + 1;
        // 如果下面还有孩子，就继续做循环，（没有左孩子，即也没有右孩子）
        while (left < heapSize) {
            // 两个孩子取最大值，谁大，就把 largest 给谁
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            // 父节点和孩子 取最大值
            largest = arr[index] > arr[largest] ? index : largest;
            // 若该父节点就是最大值，直接返回，因为原本就是大根堆结构，不用再往下面找
            if (largest == index) {
                break;
            }
            // 若最大值是孩子，则还需要继续往下走
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
