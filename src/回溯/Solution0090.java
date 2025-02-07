package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 90. 子集 II
 */
class Solution0090 {



    // 对于1,2,2的场景中 4和2重复 （100和010都是取数“2”），5和3重复（101和011取数都是"21"）
    //
    // 如果nums[i] == nums[i -1] 的场景下，
    // 如果只取高位，但是不取低位，那么就会重复，同时，重复的场景在较小的遍历时已经取到，本次循环放弃

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int mask = 0; mask < (1 << nums.length); mask++) {
            List<Integer> temp = new ArrayList<>();
            boolean flag =  true;
            for (int i = 0; i < nums.length; i++) {
                if ((mask & (1 << i)) != 0) {
                    // 去重
                    if (i > 0 && nums[i] == nums[i-1] && (mask & (1 << (i - 1))) == 0) {
                        flag = false;
                        break;
                    }
                    temp.add(nums[i]);
                }
            }
            if (flag) {
                ans.add(temp);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2};
        System.out.println(new Solution0090().subsetsWithDup(nums));
    }
}