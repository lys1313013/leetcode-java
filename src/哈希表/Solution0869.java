package 哈希表;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 869. 重新排序得到 2 的幂
 */
class Solution0869 {
    private static Set<String> set = new HashSet<>();

    static {
        for (int i = 1; i < 1e9; i <<= 1) {
            set.add(num2str(i));
        }
    }

    public static String num2str(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public boolean reorderedPowerOf2(int n) {
        return set.contains(num2str(n));
    }
}