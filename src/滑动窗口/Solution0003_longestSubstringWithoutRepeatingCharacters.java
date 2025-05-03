package 滑动窗口;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-100-liked
 */
class Solution0003_longestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet<>();
		int max = 0;
		int i = 0;
		int j = 0;
		int n = s.length();
		while (i < n && j < n) {
			if (set.contains(s.charAt(j))) {
				// 遇到重复的，就开始删除，直到没有s.charAt(j)能插入位置
				set.remove(s.charAt(i++));
			} else {
				set.add(s.charAt(j++));
				max = Math.max(max,set.size());
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Solution0003_longestSubstringWithoutRepeatingCharacters solution = new Solution0003_longestSubstringWithoutRepeatingCharacters();
		System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
	}
}