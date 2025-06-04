package 方法使用;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 类功能描述
 *
 * @author Lys
 * @date 2025/05/17 14:33
 */
public class ListTest {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(4);

        list.sort((a, b) -> {
            return b - a;
        });

        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("d");
        // 排序
        stringList.sort(Comparator.reverseOrder());

        System.out.println(stringList);

        // 转数组
        int[] array = list.stream()
                .mapToInt(Integer::intValue) // 或 .mapToInt(i -> i)
                .toArray();
    }
}
