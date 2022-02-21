package base.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    /**
     * 宽度优先遍历 + 寻找最大宽度 LeetCode 662
     */
    public static int treeMaxWidth(TreeNode head) {
        if (head == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        HashMap<TreeNode, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        int curLevel = 1;
        int curLevelNodes = 0;
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int curNodeLevel = levelMap.get(node);
            if (curLevel == curNodeLevel) {
                curLevelNodes++;
            } else {
                max = Math.max(curLevelNodes, max);
                curLevel++;
                curLevelNodes = 1;
            }
            if (node.left != null) {
                levelMap.put(node.left, curNodeLevel+1);
                queue.add(node.left);
            }
            if (node.right != null) {
                levelMap.put(node.right, curNodeLevel+1);
                queue.add(node.right);
            }
        }
        max = Math.max(max, curLevelNodes);
        return max;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
    }
}
