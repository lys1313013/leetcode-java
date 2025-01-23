package 动态规划;

import java.util.Arrays;
import java.util.List;

public class Solution2218 {

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[] dp = new int[k + 1];
        // 遍历每个集合，保证每个集合只使用一次
        for (List<Integer> pile : piles) {
            int sum = 0;
            for (int i = 0; i < pile.size() && i < k; i++) {
                // 直接覆盖数据，避免重复计算
                sum += pile.get(i);
                pile.set(i, sum);
            }
            for (int i = k; i > 0; i--) {
                for (int j = pile.size(); j > 0; j--) {
                    if (i >= j) {
                        dp[i] = Math.max(dp[i], dp[i - j] + pile.get(j - 1));
                    }
                }
            }
        }
        return dp[k];
    }

    public static void main(String[] args) {
        Solution2218 solution = new Solution2218();
        List<List<Integer>> piles;

        piles = Arrays.asList(Arrays.asList(1, 100, 3), Arrays.asList(7, 8, 9));
        System.out.println(solution.maxValueOfCoins(piles, 2)); // 输出：101

        piles = Arrays.asList(Arrays.asList(100), Arrays.asList(100), Arrays.asList(100), Arrays.asList(100), Arrays.asList(100), Arrays.asList(100), Arrays.asList(1, 1, 1, 1, 1, 1, 700));
        System.out.println(solution.maxValueOfCoins(piles, 7)); // 输出：706

        // piles = [[100],[100],[100],[100],[100],[100],[1,1,1,1,1,1,700]], k = 7
        piles = Arrays.asList(Arrays.asList(100), Arrays.asList(100), Arrays.asList(100), Arrays.asList(100), Arrays.asList(100), Arrays.asList(100), Arrays.asList(1, 1, 1, 1, 1, 1, 600));
        System.out.println(solution.maxValueOfCoins(piles, 6)); // 输出：600

        // piles = [[48,14,23,38,33,79,3,52,73,58,49,23,74,44,69,76,83,41,46,32,28]] k = 10
        piles = Arrays.asList(Arrays.asList(48, 14, 23, 38, 33, 79, 3, 52, 73, 58, 49, 23, 74, 44, 69, 76, 83, 41, 46, 32, 28));
        System.out.println(solution.maxValueOfCoins(piles, 10)); // 输出：421


        piles = Arrays.asList(Arrays.asList(1), Arrays.asList(1, 1, 1, 1));
        System.out.println(solution.maxValueOfCoins(piles, 5)); // 输出：5

        // [[37,88],[51,64,65,20,95,30,26],[9,62,20],[44]]
        piles = Arrays.asList(Arrays.asList(37, 88), Arrays.asList(51, 64, 65, 20, 95, 30, 26), Arrays.asList(9, 62, 20), Arrays.asList(44));
        System.out.println(solution.maxValueOfCoins(piles, 9)); // 输出：494

        // [[80,62,78,78,40,59,98,35],[79,19,100,15],[79,2,27,73,12,13,11,37,27,55,54,55,87,10,97,26,78,20,75,23,46,94,56,32,14,70,70,37,60,46,1,53]]
        piles = Arrays.asList(Arrays.asList(80, 62, 78, 78, 40, 59, 98, 35), Arrays.asList(79, 19, 100, 15), Arrays.asList(79, 2, 27, 73, 12, 13, 11, 37, 27, 55, 54, 55, 87, 10, 97, 26, 78, 20, 75, 23, 46, 94, 56, 32, 14, 70, 70, 37, 60, 46, 1, 53));
        System.out.println(solution.maxValueOfCoins(piles, 25)); // 输出：1332
    }
}