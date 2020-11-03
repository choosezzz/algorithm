package newcoder;

import common.ListNode;

import java.util.ArrayList;

/**
 * @Author dingshuangen
 * @Date 2020/11/3 23:07
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class Offer055 {

    /**
     * 运行时间：13ms
     * <p>
     * 占用内存：9704k
     * list 保存遍历过的节点数据
     *
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {

        if (pHead == null) {
            return null;
        }

        ListNode curr = pHead;
        ListNode next = pHead.next;
        ArrayList<ListNode> list = new ArrayList<>();
        list.add(curr);
        while (next != null) {

            if (list.contains(next.next)) {
                return next.next;
            }
            curr = next;
            list.add(curr);
            next = next.next;
        }
        return null;
    }

    /**
     * 使用快慢指针
     * 初始化：快指针fast指向头结点， 慢指针slow指向头结点
     * 让fast一次走两步， slow一次走一步，第一次相遇在C处，停止
     * 然后让slow指向头结点，fast原地不动，然后fast，slow每次走一步，当再次相遇，就是入口结点。
     *
     * 运行时间：12ms
     *
     * 占用内存：9560k
     * @param pHead
     * @return
     */
    public ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        //快指针每次走两步
        ListNode fast = pHead;
        //慢指针每次走一步
        ListNode slow = pHead;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast){
                break;
            }
        }

        //遍历到尾节点，无环的存在
        if (fast == null || fast.next == null){
            return null;
        }

        //慢指针从头开始跑
        slow = pHead;
        while (slow != fast){
            //都走一步，直到慢指针再次和快指针相遇
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
