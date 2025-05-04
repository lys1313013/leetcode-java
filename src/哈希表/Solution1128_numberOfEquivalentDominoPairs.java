package 哈希表;

/**
 * 1128. 等价多米诺骨牌对的数量
 * https://leetcode.cn/problems/number-of-equivalent-domino-pairs/description/?envType=daily-question&envId=2025-05-04
 */
class Solution1128_numberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] freq = new int[100];
        int sum = 0;
        for (int[] dominoe : dominoes) {
            if (dominoe[0] > dominoe[1]) {
                int temp = dominoe[0];
                dominoe[0] = dominoe[1];
                dominoe[1] = temp;
            }
            int num = dominoe[0] * 10 + dominoe[1];
            // 增加一个数，就是增加这个人之间的数！
            sum += freq[num];
            freq[num]++;
        }
        return sum;
    }
}