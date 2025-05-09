package 二叉树;

/**
 * 104. 二叉树的最大深度
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) {
        // 输入：root = [3,9,20,null,null,15,7]
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        Solution solution = new Solution();
        System.out.println(solution.maxDepth(treeNode));
    }


}