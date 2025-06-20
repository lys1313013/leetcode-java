package 贪心;

/**
 * 3443. K 次修改后的最大曼哈顿距离
 */
class Solution3443 {
    public int maxDistance(String s, int k) {
        int n = s.length();
        int N = 0;
        int S = 0;
        int W = 0;
        int E = 0;

        char[] cs = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int temp = k;
            if ('N' == cs[i]) {
                N++;
            } else if ('S' == cs[i]) {
                S++;
            } else if ('W' == cs[i]) {
                W++;
            } else {
                E++;
            }

            int max1 = 0;
            int max2 = 0;
            if (N > S) {
                max1 = N - S;
                int min = Math.min(S, temp);
                max1 += min * 2;
                temp -= min;
            } else {
                max1 = S - N;
                int min = Math.min(N, temp);
                max1 += min * 2;
                temp -= min;
            }

            if (W > E) {
                max2 = W - E;
                int min = Math.min(E, temp);
                max2 += min * 2;
            } else {
                max2 = E - W;
                int min = Math.min(W, temp);
                max2 += min * 2;
            }
            ans = Math.max(ans, max1 + max2);
        }

        return ans;
    }
}