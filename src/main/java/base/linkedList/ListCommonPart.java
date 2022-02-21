package base.linkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ListCommonPart {
    /**
     * 打印两个有向单链表的公共部分
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

    }

    // 双指针
    public static void printCommonPart(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                head1 = head1.next;
            } else if (head1.val > head2.val) {
                head2 = head2.next;
            } else {
                System.out.println(" "+head1.val);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }
}
