package 回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution0017 {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };

        List<String> ans = new ArrayList<>();
        String t = "";
        backtrack(phoneMap, digits, 0, ans, new StringBuilder());
        return ans;
    }

    public void backtrack(Map<Character, String> phoneMap, String digits, int cur, List<String> ans, StringBuilder t) {
        if (cur == digits.length()) {
            ans.add(t.toString());
            return;
        }
        String str = phoneMap.get(digits.charAt(cur));
        for (int i = 0; i < str.length(); i++) {
            t.append(str.charAt(i));
            backtrack(phoneMap, digits, cur + 1, ans, t);
            t.deleteCharAt(cur);
        }
    }
}