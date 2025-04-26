package 双指针;

/**
 * 11. 盛最多水的容器
 * https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-100-liked
 */
class Solution0011 {
    public int maxArea(int[] height) {
    
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left <= right) {
            int min = Math.min(height[left], height[right]);
            max = Math.max((min * (right - left)), max);
            // 那边小移动哪边
            // 相等的时候 随便移动，因为就算right和left的中间里面有1个比较大的数据，它跟当前的任意一个边的组合一定不会大于现在的组合，因为受限于矮的那边
            // 移动是为了找到right和left中间两个数的组合比当前两个数的组合大的数
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}