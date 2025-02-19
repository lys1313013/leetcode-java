package 数组;

import java.util.List;

class Solution0624 {
   public int maxDistance(List<List<Integer>> arrays) {
       int res = 0;
       int min = arrays.get(0).get(0);
       int max = arrays.get(0).get(arrays.get(0).size() - 1);
       // 关键点在与不要用当前数组的最大值减最小值的场景被计算进去
       for (int i = 1; i < arrays.size(); i++) {
            List<Integer> list = arrays.get(i);
            res = Math.max(res, Math.abs(max - list.get(0)));
            res = Math.max(res, Math.abs(list.get(list.size() - 1) - min));
            max = Math.max(max, list.get(list.size() - 1));
            min = Math.min(min, list.get(0));
       }
       return res;
   }
}
