package 栈;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 3561. 移除相邻字符
 */
class Solution3561 {
    public String resultingString(String s) {
        Deque<Character> deque = new LinkedList<>();
        char[] cs = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = cs[i];
            if (deque.isEmpty()) {
                deque.push(ch);
            } else {
                if ((ch == 'a' && deque.peek() == 'z') || (ch == 'z' && deque.peek() == 'a')
                        || Math.abs(deque.peek() - ch) == 1) {
                    deque.pop();
                } else {
                    deque.push(ch);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character ch : deque) {
            sb.append(ch);
        }

        return sb.reverse().toString();
    }
}