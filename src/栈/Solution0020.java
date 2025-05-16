package 栈;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 20. 有效的括号
 */
class Solution0020 {
    public boolean isValid(String s) {
        int n = s.length();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (deque.isEmpty()) {
                    return false;
                }
                if (deque.peek() == map.get(ch)) {
                    deque.pop();
                } else {
                    deque.push(ch);
                }
            } else {
                deque.push(ch);
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        Solution0020 solution0020 = new Solution0020();
        System.out.println(solution0020.isValid("(])"));
    }
}