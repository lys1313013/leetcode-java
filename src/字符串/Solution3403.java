package 字符串;

/**
 * 3403. 从盒子中找出字典序最大的字符串 I
 */
class Solution3403 {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        int width = word.length() - numFriends + 1;
        String ans = "";

        for (int i = 0; i < word.length(); i++) {
            int sub = Math.min(width, word.length() - i);
            String temp = word.substring(i, i + sub);
            if (ans.compareTo(temp) < 0) {
                ans = temp;
            }
        }
        return ans;
    }
}