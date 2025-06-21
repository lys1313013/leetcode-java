package 遍历;

import java.util.Arrays;

/**
 * 3085. 成为 K 特殊字符串需要删除的最少字符数
 */
class Solution3085 {
    public int minimumDeletions(String word, int k) {
        int[] cnt = new int[26];
        for (char c : word.toCharArray()) {
            cnt[c - 'a']++;
        }
        Arrays.sort(cnt);

        int maxSave = 0;
        for (int i = 0; i < 26; i++) {
            int sum = 0;
            // 排序后，小于当前的全部丢弃
            for (int j = i; j < 26; j++) {
                // 大于cnt[i] + k 的 可以保留cnt[i] + k个
                sum += Math.min(cnt[j], cnt[i] + k);
            }
            maxSave = Math.max(maxSave, sum);
        }
        return word.length() - maxSave;
    }
}