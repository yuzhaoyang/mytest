package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Cycle {

    public static boolean hasCycle1(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<ListNode>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }


    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode (1);
        ListNode node2= new ListNode (2);
        head.next= node2;
        head.next.next= new ListNode (3);
        head.next.next.next= new ListNode (4);
        head.next.next.next.next= node2;

      boolean flag=  hasCycle(head);
        System.out.println(flag);
    }
}
