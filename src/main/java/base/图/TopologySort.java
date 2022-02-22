package base.图;

import java.util.*;

public class TopologySort {
    // 拓扑排序
    public static List<Node> topologySort(Graph graph) {
        // 入度为0的点才能进入这个队列
        Queue<Node> noInsertQueue = new LinkedList<>();
        // 该map的key存储该节点，value存储节点的实际入度值
        Map<Node, Integer> inMap = new HashMap<>();
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                noInsertQueue.add(node);
            }
        }
        List<Node> result = new LinkedList<>();
        while (!noInsertQueue.isEmpty()) {
            Node cur = noInsertQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                // 此处注意需要用map里面的入度值
                if (inMap.get(next) == 0) {
                    noInsertQueue.add(next);
                }
            }
        }
        return result;
    }
}
