package main.java.newcoder;

/**
 * @author dingshuangen
 * @date 2020/5/10 14:36
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 */
public class Offer016 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 运行时间：23ms
     * 占用内存：9672k
     * <p>
     * 递归实现
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list2.next, list1);
            return list2;
        }
    }

    /**
     * 运行时间：30ms
     * 占用内存：9680k
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        //头节点
        ListNode head = null;
        //当前节点
        ListNode current = null;
        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {

                if (head == null) {
                    head = current = list1;
                } else {
                    //当前节点永远指向以merge链表的尾部
                    current.next = list1;
                    current = current.next;
                }
                list1 = list1.next;
            } else {
                if (head == null) {
                    head = current = list2;
                } else {
                    current.next = list2;
                    current = current.next;
                }
                list2 = list2.next;
            }
        }
        //list1全部merge完
        if (list1 == null) {
            current.next = list2;
        }
        //list2全部merge完
        if (list2 == null) {
            current.next = list1;
        }
        return head;
    }

    /**
     * 每次比较两个链表的头节点，值小的节点向后移动
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeList(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode head = null;
        ListNode curr = null;
        while (list1 != null && list2 != null){

            if (list1.val <= list2.val){

                if (head == null){
                    head = curr = list1;
                }else {
                    curr.next = list1;
                }
                //链表向后移动
                list1 = list1.next;
            }else {
                if (head == null){
                    head = curr = list2;
                }else {
                    curr.next = list2;
                }
                list2 = list2.next;
            }
        }
        return head;
    }
}
