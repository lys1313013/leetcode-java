package 链表;

/**
 * 1290. 二进制链表转整数
 */
class Solution1290 {
    public int getDecimalValue(ListNode head) {
        int result = 0;
        while (head != null) {
            result *= 2;
            result += head.val;
            head = head.next;
        }
        return result;
    }
}