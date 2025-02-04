package 数组;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 350. 两个数组的交集 II
 */
class Solution0350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        // nums1和nums2转集合
        List<Integer> list1 = Arrays.stream(nums1)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> list2 = Arrays.stream(nums2)
                .boxed() // 将 int 装箱为 Integer
                .collect(Collectors.toList());

        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        int[] nums = list.stream().mapToInt(Integer::intValue).toArray();

        return nums;
    }
}