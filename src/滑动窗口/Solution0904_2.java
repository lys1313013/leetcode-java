package 滑动窗口;

import java.util.LinkedList;

/**
 * 904. 水果成篮
 */
class Solution0904_2 {
    public int totalFruit(int[] fruits) {
        int max = 0;
        int sum = 0;
        // 记录i - 1数字连续出现的频率
        int pre = 0;
        LinkedList<Integer> window = new LinkedList<>();
        for (int i = 0; i < fruits.length; i++) {
            if (i >= 2) {
                if (fruits[i - 2] == fruits[i - 1]) {
                    pre++;
                } else {
                    pre = 1;
                }
            }
            if (window.contains(fruits[i])) {
                sum++;
            } else {
                if (window.size() < 2) {
                    window.add(fruits[i]);
                    sum++;
                } else {
                    // 这里先进的不一定先出，所以直接清空
                    window.clear();
                    window.add(fruits[i - 1]);
                    window.add(fruits[i]);
                    sum = pre + 1;
                }
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution0904_2 solution = new Solution0904_2();
        int[] fruits = {1,0,1,4,1,4,1,2,3};
        System.out.println(solution.totalFruit(fruits));
    }
}