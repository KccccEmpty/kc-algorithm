package base.tree;

public class MirrorTree {
    /**
     * 求一颗二叉树的镜像二叉树 LeetCode 226
     *
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
