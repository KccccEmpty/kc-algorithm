package base.图;

public class GraphGenerator {
    /**
     * 此处 matrix数组为邻接矩阵
     * 该方法意为将类型：（第一位为权重，第二位为起始点，第三位为结束点）
     * [
     *  [5, 1, 2],
     *  [2, 2, 3],
     *  [3, 3, 4],
     * ]
     * 此接口函数仅供参考，具体的数据结构需要根据实际进行调整
     */
    public static Graph createGraph(Integer[][] matrix) {
        Graph graph = new Graph();
        for (Integer[] integers : matrix) {
            Integer weight = integers[0];
            Integer from = integers[1];
            Integer to = integers[2];
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        return graph;
    }

}
