package 深度优先搜索;

import java.util.Arrays;

/**
 * 1061. 按字典序排列最小的等效字符串
 */
class Solution1061 {
      public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // 当前字母可以转成较小的值
        int[] exchanges = new int[26];
        for (int i = 0; i < exchanges.length; i++) {
            exchanges[i] = i;
        }

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            replace(c1 - 'a', c2 - 'a', exchanges);
        }
        System.out.println(Arrays.toString(exchanges));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            char c = baseStr.charAt(i);
            System.out.println("转换前:" + c);

            c = (char) (findAndReplace(exchanges, c - 'a') + 'a');
            System.out.println("转换后:" + c);
            sb.append(c);
        }

        return sb.toString();
    }

    public int findAndReplace(int[] exchanges, int x) {
        if (exchanges[x] != x) {
            exchanges[x] = findAndReplace(exchanges, exchanges[x]);
        }
        return exchanges[x];
    }

    public void replace(int c1, int c2, int[] exchanges) {
        int min1 = findAndReplace(exchanges, c1);
        int min2 = findAndReplace(exchanges, c2);
        if (min1 > min2) {
            exchanges[min1] = min2;
        } else {
            exchanges[min2] = min1;
        }
    }
}