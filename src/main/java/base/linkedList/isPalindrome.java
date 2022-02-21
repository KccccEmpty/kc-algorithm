package base.linkedList;

public class isPalindrome {
    /**
     * 回文链表 LeetCode.234
     * 整个流程可以分为以下五个步骤：
     * 1、找到前半部分链表的尾节点。
     * 2、反转后半部分链表。
     * 3、判断是否回文。
     * 4、恢复链表。
     * 5、返回结果
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

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode halfNode = getHalfNode(head);
        ListNode secondListStart = reverseList(halfNode.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondListStart;
        boolean result = true;
        while(result && p2 != null) {
            if(p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        halfNode.next = reverseList(p2);
        return result;

    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    // 快慢指针找到链表中点
    public static ListNode getHalfNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }
}
