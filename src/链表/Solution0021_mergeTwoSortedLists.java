package 链表;

/**
 * 21. 合并两个有序链表
 * https://leetcode.cn/problems/merge-two-sorted-lists/
 */
class Solution0021_mergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        while (list1 != null && list2 !=  null) {
            if (list1.val < list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        if (list1 == null) {
            pre.next = list2;
        } else {
            pre.next = list1;
        }
        return head.next;
    }
}