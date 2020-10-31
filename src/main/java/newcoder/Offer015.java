package newcoder;

/**
 * @author dingshuangen
 * @date 2020/5/10 14:21
 * <p>
 * 输入一个链表，反转链表后，输出新链表的表头
 */
public class Offer015 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 运行时间：15ms
     * 占用内存：9684k
     *
     * 三个指针同时向前步进1，同时反转next
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head.next.next;
        ListNode mid = head.next;
        ListNode tail = head;
        //尾节点的next置为null
        tail.next = null;
        //遍历当前链表
        while (pre != null){
            //中间节点next指向尾结点
            mid.next = tail;
            //尾结点指针向前移动
            tail = mid;
            //中间节点向前移动
            mid = pre;
            //头节点向前移动
            pre = pre.next;
        }
        //将原链表末尾节点的next指向新的链表
        mid.next = tail;
        return mid;
    }
}
