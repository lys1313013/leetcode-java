package 双指针;

import java.util.TreeSet;

/**
 * 838. 推多米诺
 * https://leetcode.cn/problems/push-dominoes/description/
 * 计算出离他最近的L和R的距离
 */
class Solution0883_pushDominoes {
    public String pushDominoes(String dominoes) {
        char[] chars = dominoes.toCharArray();
        // 每一个都受他最近的L或R影响
        int n = dominoes.length();

        TreeSet<Integer> lSet = new TreeSet<>();
        TreeSet<Integer> rSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (chars[i] == 'L') {
                lSet.add(i);
            } else if (chars[i] == 'R') {
                rSet.add(i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (chars[i] == 'L') {
                continue;
            } else if (chars[i] == 'R') {
                continue;
            }

            int left = -1; // 向左找R, null为没找到
            int right = n; // 向右找L, n就当没找到

            int leftR = rSet.lower(i) == null ? -1 : rSet.lower(i);
            int leftL = lSet.lower(i) == null ? -1 : lSet.lower(i);
            if (leftR >  leftL ) {
                left = leftR;
            }

            int rightR = rSet.higher(i) == null? n : rSet.higher(i);
            int rightL = lSet.higher(i) == null? n : lSet.higher(i);
            if (rightL < rightR ) {
                right = rightL;
            }

            if (left == -1 && right == n) {
                // "LL.RR"的场景
                continue;
            } else if (left == -1) {
                chars[i] = 'L';
            } else if (right == n) {
                chars[i] = 'R';
            } else if (Math.abs(i - left) == Math.abs(i - right)) {
                // "R.L"的场景
                continue;
            } else if (Math.abs(i - left) < Math.abs(i - right)) {
                // "R..L" 第一个.的场景
                chars[i] = 'R';
            } else {
                chars[i] = 'L';
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        Solution0883_pushDominoes solution = new Solution0883_pushDominoes();
        System.out.println(solution.pushDominoes(".L.R...LR..L.."));
    }
}