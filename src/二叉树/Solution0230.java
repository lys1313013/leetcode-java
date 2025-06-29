package 二叉树;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 230. 二叉搜索树中第 K 小的元素
 */
class Solution0230 {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (root != null || ! stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }
}