package 数组;

import java.util.ArrayList;
import java.util.List;

/**
 * 1656. 设计有序流
 * https://leetcode.cn/problems/design-an-ordered-stream/description/?envType=daily-question&envId=2025-02-24
 */
class OrderedStream {
    String[] arr;
    int i = 1;

    public OrderedStream(int n) {
        arr = new String[n + 1];

    }
    
    public List<String> insert(int idKey, String value) {
        arr[idKey] = value;
        List<String> result = new ArrayList<>();
        boolean found = false;
        int j = i;
        for (; j < arr.length; j++) {
            if (arr[j] == null) {
                break;
            } else {
                found = true;
                result.add(arr[j]);
            }

        }
        if (found) {
            // 跳出循环时 j 就是 最后那个 id + 1
            i = j;
        }
        return result;
    }

    public static void main(String[] args) {
        OrderedStream os = new OrderedStream(5);
        System.out.println(os.insert(3, "ccccc"));
        System.out.println(os.insert(1, "aaaaa"));
        System.out.println(os.insert(2, "bbbbb"));
        System.out.println(os.insert(5, "eeeee"));
        System.out.println(os.insert(4, "ddddd"));

    }
}