package 哈希表;

/**
 * 3335. 字符串转换后的长度 I
 */
class Solution3335 {
    private static int MOD = 1_0000_0000_7;

    public int lengthAfterTransformations(String s, int t) {
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t; i++) {
            // 暂存'z'的数量
            int temp = chars[25];
            // 前一个字母覆盖后一个字母
            for (int j = 25; j >= 1; j--) {
                chars[j] = chars[j - 1];
            }
            chars[0] = temp;
            // b = a + z 的数量
            chars[1] = (chars[0] + chars[1]) % MOD;

        }

        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum = (sum + chars[i]) % MOD;
        }
        return sum;
    }
}