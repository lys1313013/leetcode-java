package 双指针;

/**
 * 42. 接雨水
 * https://leetcode.cn/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-100-liked
 * 双指针为什么能对，因为能不能接到雨水关系到两边的最大值，
 * 对于左边的柱子来说，左边的最大值是确定的
 */
class Solution0042_trappingRainWater {
    public int trap(int[] height) {
        // 双指针
        int left = 0;
        int right = height.length - 1;
        int sum = 0;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            System.out.println("left: " + left + ", right: " + right);
            // 如果当前左边的柱子高度小于右边的柱子高度
            if (height[left] < height[right]) {
                // 如果当前左边的柱子高度大于左边最高的高度，那么接不到雨水，修改最大值 
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    sum +=(leftMax - height[left]);
                }
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    sum += (rightMax - height[right]);
                }
                right--;
            }
        }
        return sum;
    }
}