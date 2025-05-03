package 滑动窗口;

import java.util.HashSet;
import java.util.Set;

/**
 * 1456. 定长子串中元音的最大数目
 * https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
 */
class Solution1456_maximumNumberOfVowelsInASubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int sum = 0;

        char[] cs = s.toCharArray();

        for (int i = 0; i < k; i++) {
            if (set.contains(cs[i])) {
                sum++;
            }
        }
        int max = sum;
        int n = s.length();

        for (int i = k; i < n; i++) {
            if (set.contains(cs[i])) {
                sum++;
            }
            if (set.contains(cs[i - k])) {
                sum--;
            }
            max = Math.max(max,sum);
        }
        return max;
    }
}