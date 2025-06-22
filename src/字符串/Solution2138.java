package 字符串;

/**
 * 2138. 将字符串拆分为若干长度为 k 的组
 */
class Solution2138 {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int size = (n + k - 1) / k;
        String[] ans = new String[size];
        int j = 0;
        for (int i = 0; i < n; i += k) {
            if (j ==  size - 1) {
                String temp = s.substring(i);
                StringBuilder sb = new StringBuilder(temp);
                for (int ii = temp.length(); ii < k; ii++) {
                    sb.append(fill);
                }
                ans[j] = sb.toString();

            } else {
                ans[j] = s.substring(i, i + k);
            }
            j++;
        }
        return ans;
    }
}