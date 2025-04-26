package 数组;

/**
 * 88. 合并两个有序数组
 * https://leetcode.cn/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
 *
 */
class Solution0088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 从后往前合并
        int j = m - 1;
        int k = n - 1;
        for (int i = nums1.length - 1; i >= 0; i--) {
            System.out.println("j ==" + j + " k == " + k);
            if (j == -1) {
                nums1[i] = nums2[k--];
            } else if (k == -1) {
                return;
            } else if (nums1[j] < nums2[k]) {
                nums1[i] = nums2[k--];
            } else {
                nums1[i] = nums1[j--];
            }
        }
    }
}