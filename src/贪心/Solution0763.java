package 贪心;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. 划分字母区间
 */
class Solution0763 {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        // 更新每个字母的最大索引
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length();) {
            int max = last[s.charAt(i) - 'a'];
            if (max == i) {
                ans.add(1);
                i++;
                continue;
            }
            int j = i + 1;
            while (j < max) {
                if (last[s.charAt(j) - 'a'] > max) {
                    max = last[s.charAt(j) - 'a'];
                }
                j++;
            }
            ans.add(j - i + 1);
            i = j + 1;
        }
        return ans;
    }
}