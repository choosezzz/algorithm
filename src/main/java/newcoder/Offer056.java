package newcoder;

import common.ListNode;

import java.util.HashSet;

/**
 * @Author dingshuangen
 * @Date 2020/11/4 0:10
 * <p>
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * <p>
 * 有序链表重复元素必须是相邻的
 */
public class Offer056 {


    /**
     * 运行时间：13ms
     *
     * 占用内存：9596k
     * 直接删除，在遍历的过程中，跳过连续相等的重复元素
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = pHead;
        ListNode pre = newHead;
        ListNode curr = pHead;
        while (curr != null){
            if (curr.next != null && curr.val == curr.next.val){
                //查找后续全部相同的节点
                while (curr.next != null && curr.val == curr.next.val){
                    curr = curr.next;
                }
                //跳过重复节点
                curr = curr.next;
                //前一个节点保持不变，前一个节点的下一个节点改为当前节点
                pre.next = curr;
            }else {
                //相邻不重复的时候，向后移动
                pre = pre.next;
                curr = curr.next;
            }
        }
        return newHead.next;
    }

    /**
     * 运行时间：13ms
     * <p>
     * 占用内存：9588k
     *
     * @param pHead
     * @return
     */
    public ListNode violentDelete(ListNode pHead) {
        if (pHead == null) {
            return null;
        }

        HashSet<Integer> set = new HashSet<>();
        ListNode curr = pHead;
        ListNode next = pHead.next;
        while (next != null) {
            if (curr.val == next.val) {
                set.add(curr.val);
            }
            curr = curr.next;
            next = next.next;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = pHead;
        curr = pHead;
        ListNode pre = newHead;
        while (curr != null) {
            if (set.contains(curr.val)) {
                curr = curr.next;
                pre.next = curr;
            } else {
                pre = pre.next;
                curr = curr.next;

            }
        }
        return newHead.next;
    }
}
