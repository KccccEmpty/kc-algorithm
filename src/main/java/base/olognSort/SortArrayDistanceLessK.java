package base.olognSort;

import java.util.PriorityQueue;

public class SortArrayDistanceLessK {

    /**
     * 堆排序扩展题目
     * 已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元
     * 素移动的距离可以不超过k，并且k相对于数组来说比较小。请选择一个合适的
     * 排序算法针对这个数据进行排序。
     */
    public static void sortArrayDistanceLessK(int[] arr, int k) {
        // Java 自带的小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for (; index < Math.min(arr.length, k); index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }
}
