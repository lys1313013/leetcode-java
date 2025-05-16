package 栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 739. 每日温度
 */
class Solution0739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer[]> deque = new LinkedList<>();
        int[] answer = new int[temperatures.length];
        int n = temperatures.length;
        for (int i = 0; i < n; i++) {
            // if
            if (deque.isEmpty()) {
                deque.push(new Integer[] { temperatures[i], i });
            } else {
                while (!deque.isEmpty() && deque.peek()[0] < temperatures[i]) {
                    Integer[] pop = deque.pop();
                    answer[pop[1]] = i - pop[1];
                }
                deque.push(new Integer[] { temperatures[i], i });

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution0739 solution = new Solution0739();
        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] answer = solution.dailyTemperatures(temperatures);
    }
}