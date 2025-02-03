package 数组;

import java.util.HashSet;
import java.util.Set;

class Solution2586 {
    static Set<Character> set = new HashSet<>();
    static {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
    }

    public int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            String word = words[i];
            if (set.contains(word.charAt(0)) && set.contains(word.charAt(word.length() - 1))) {
                count++;
            }
        }
        return count;
    }
}