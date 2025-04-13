package 进制转换;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2595. 奇偶位数
 * https://leetcode.cn/problems/number-of-even-and-odd-bits/description/
 */
class Solution2595 {
    public int[] evenOddBit(int n) {
        // 二进制转换
        List<Integer> list = new ArrayList<>();

        while (n > 0) {
            list.add(n % 2);
            n /= 2;
        }
        int odd = 0;
        int even = 0;
        for (int i = 0; i < list.size(); i++) {

            if (list.get(i) == 0) {
                continue;
            }

            if (i % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return new int[] {even, odd};
    }

    public static void main(String[] args) {
        Solution2595 solution = new Solution2595();
        int[] ints = solution.evenOddBit(50);
        System.out.println(Arrays.toString(ints));

    }
}