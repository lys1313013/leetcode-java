package 方法使用;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 类功能描述
 *
 * @author Lys
 * @date 2025/05/17 14:00
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        // 向队列尾部添加元素1，并打印添加结果(true表示成功)
        System.out.println(queue.offer(1));
        // 移除并返回队列头部的元素(先进先出)，并打印该元素
        System.out.println(queue.poll());
    }
}
