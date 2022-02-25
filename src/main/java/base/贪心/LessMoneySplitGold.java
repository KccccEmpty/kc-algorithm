package base.贪心;

import java.util.PriorityQueue;

public class LessMoneySplitGold {

    //哈夫曼编码，得到最少代价
    public static int lessMoney(int[] arr) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int j : arr) {
            pQ.add(j);
        }
        int cur = 0;
        int sum = 0;
        while (pQ.size() > 1) {
            cur = pQ.poll() + pQ.poll();
            sum += cur;
            pQ.add(cur);
        }
        return sum;
    }
}
