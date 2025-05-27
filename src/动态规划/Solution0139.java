package 动态规划;

import java.util.List;

/**
 * 139. 单词拆分
 */
class Solution0139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] wordFlag = new boolean[s.length() + 1];
        wordFlag[0] = true;
        for (int i = 0; i < s.length(); i++) {
            if (wordFlag[i]) {
                String temp = s.substring(i);
                for (String word : wordDict) {
                    if (temp.startsWith(word)) {
                        wordFlag[i + word.length()] = true;
                    }
                }
            }
        }
        return wordFlag[wordFlag.length - 1];
    }
}