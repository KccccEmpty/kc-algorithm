package base.图;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class DFS {
    // 图的深度优先遍历
    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Deque<Node> stack = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        stack.push(node);
        set.add(node);
        System.out.println(node.value);
        while(!stack.isEmpty()) {
            Node cur = stack.poll();
            for (Node next : node.nexts) {
                if (!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}
