package 遍历;

/**
 * 1534. 统计好三元组
 * https://leetcode.cn/problems/count-good-triplets/description/?envType=daily-question&envId=2025-04-14
 *
 */
class Solution1534 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a &&
                            Math.abs(arr[j] - arr[k]) <= b &&
                            Math.abs(arr[i] - arr[k]) <= c) {
                        sum++;
                    }
                }
            }
        }
        return sum;
    }
}