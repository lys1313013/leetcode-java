package 数学;

import java.util.HashMap;
import java.util.Map;

/**
 * 781. 森林中的兔子
 * https://leetcode.cn/problems/rabbits-in-forest/description/?envType=daily-question&envId=2025-04-20
 * #数学 #哈希表 #数组
 */
class Solution {
    public int numRabbits(int[] answers) {
        // 统计每个回答的个数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < answers.length; i++) {
            map.put(answers[i], map.getOrDefault(answers[i], 0) + 1);
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int size = entry.getKey() + 1;
            if (entry.getValue() % size == 0) {
                sum = sum + entry.getValue();
            } else {
                // 向上取整
                sum = sum + ((entry.getValue() / size) + 1) * size;
            }
        }
        return sum;
    }
}