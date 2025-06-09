package 深度优先搜索;

import java.util.ArrayList;
import java.util.List;

/**
 * 386. 字典序排数
 */
public class Solution0386 {
    public List<Integer> lexicalOrder(int n) {
        int number = 1;
        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            ans.add(number);
            if (number * 10 <= n) {
                number *= 10;
            } else {
                while (number % 10 == 9 || number >= n) {
                    number /= 10;
                }
                number++;
            }
        }
        return ans;
    }

}
