package 链表;

import java.util.ArrayList;
import java.util.List;

/**
 * 2. 两数相加
 * https://leetcode.cn/problems/add-two-numbers/solutions/435246/liang-shu-xiang-jia-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked
 * 
 */
class Solution0002_addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        while (l1 != null) {
            list1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            list2.add(l2.val);
            l2 = l2.next;
        }

        if (list1.size() < list2.size()) {
            List<Integer> temp = list1;
            list1 = list2;
            list2 = temp;
        }
        
        boolean shi = false;
        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            int a = list1.get(i);
            
            int b = 0;
            if (list2.size() > i) {
                b = list2.get(i);
            }
            if (shi) {
                a++;
                shi = false;
            }
            int sum = a + b;
            if (sum >=10 ) {
                ansList.add(sum % 10);
                shi = true;
            } else {
                ansList.add(sum);
            }
        }
        if (shi) {
            ansList.add(1);
        }

        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for (int i = 0; i < ansList.size(); i++) {
            ListNode temp = new ListNode(ansList.get(i));
            cur.next = temp;
            cur = cur.next;
        }
        return head.next;
    }
}