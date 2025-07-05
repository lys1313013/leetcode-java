package 方法使用;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 类功能描述
 *
 * @author Lys
 * @date 2025/07/04 12:45
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        priorityQueue.add(2);
        System.out.println("peek:" + priorityQueue.peek());
        priorityQueue.add(3);
        System.out.println("peek:" + priorityQueue.peek());
        priorityQueue.add(1);
        System.out.println("peek:" + priorityQueue.peek());

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.remove());
        }
    }
}
