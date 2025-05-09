package 二叉树;

public class TreeNode {
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


    /**
     * 根据数组生成二叉树的方法
     */
    public static TreeNode buildTree(Integer[] nums) {
        if (nums == null || nums.length == 0) return null;
        return buildTreeHelper(nums, 0);
    }

    private static TreeNode buildTreeHelper(Integer[] nums, int index) {
        if (index >= nums.length || nums[index] == null) return null;

        TreeNode node = new TreeNode(nums[index]);
        node.left = buildTreeHelper(nums, 2 * index + 1);
        node.right = buildTreeHelper(nums, 2 * index + 2);
        return node;
    }
}