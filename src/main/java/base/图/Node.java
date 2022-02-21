package base.图;

import java.util.ArrayList;

public class Node {
    public int value;
    public int in; // 入度数量
    public int out; // 出度数量，无向图中入度等于出度
    public ArrayList<Node> nexts; // 在有向图中该节点指向的节点
    public ArrayList<Edge> edges; // 在有向图中该节点指出的边

    public Node(int value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

}
