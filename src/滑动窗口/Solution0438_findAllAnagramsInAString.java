package 滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/?envType=study-plan-v2&envId=top-100-liked
 */
class Solution0438_findAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] cntP = new int[26]; // 统计p的每种字母出现的次数
        int[] cntS = new int[26]; // 统计s的长 p.length() 的子串 s' 的每种字母出现次数
        for (char c : p.toCharArray()) {
            cntP[c - 'a']++;
        }
        if (s.length() < p.length()) {
            return new ArrayList();
        }

        for (int i = 0; i < p.length(); i++) {
            cntS[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(cntP, cntS)) {
            ans.add(0);
        }

        for (int i = p.length(); i < s.length(); i++) {
            cntS[s.charAt(i) - 'a']++;
            cntS[s.charAt(i - p.length()) - 'a']--;
            if (Arrays.equals(cntP, cntS)) {
                // 被移出去的是窗口外的，窗口内的开始节点要+1
                ans.add(i - p.length() + 1);
            }
        }
        return ans;
    }
}