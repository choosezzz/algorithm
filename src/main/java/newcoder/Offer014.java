package main.java.newcoder;

/**
 * @author dingshuangen
 * @date 2020/5/10 13:46
 * <p>
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Offer014 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 运行时间：20ms
     * 占用内存：9672k
     * 先遍历链表，获取链表长度 len
     * 在遍历链表获取第(len - k)个节点
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head, int k) {

        if (head == null || k < 0) {
            return null;
        }
        ListNode node = head;
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        if (count < k){
            return null;
        }
        node = head;
        int index = 0;
        while (index++ < (count - k)){
            node = node.next;
        }
        return node;
    }

    /**
     *
     * 运行时间：17ms
     * 占用内存：9684k
     * 思路：两个指针p1,p2都从头开始，p1先向后移动k-1步，此时[p2,p1]之间有k个节点
     * 然后p1，p2同时向后走，当p1移动到链表尾部时，p2即为倒数第k个节点
     * 可以得到链表总长度，判断边界条件
     * @param head
     * @param k
     * @return
     */
    public ListNode findKthToTail(ListNode head, int k) {

        if (head == null || k < 0) {
            return null;
        }
        //先行指针，先走k-1步
        ListNode p1 = head;
        //后行指针，当先行指针走k-1步之后，一起向前走
        ListNode p2 = head;
        int count = 0;
        while (p1 != null){
            //p1先行k-1步
            if (count < k){
                p1= p1.next;
            }else {
                //同时向前走
                p1=p1.next;
                p2=p2.next;
            }
            //记录行走步数
            count++;
        }
        if (count < k){
            return null;
        }
        return p2;
    }
}
