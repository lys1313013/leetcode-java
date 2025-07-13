package 贪心;

import java.util.Arrays;

/**
 * 2410. 运动员和训练师的最大匹配数
 */
class Solution2410 {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int sum = 0;
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i = 0;
        int j = 0;
        int m = players.length;
        int n = trainers.length;
        while (i < m && j < n) {
            if (players[i] <= trainers[j]) {
                i++;
                j++;
                sum++;
            } else {
                j++;
            }
        }
        return sum;   
    }
}