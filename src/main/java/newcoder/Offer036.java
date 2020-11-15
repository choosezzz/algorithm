package newcoder;

import common.ListNode;

/**
 * @Author dingshuangen
 * @Date 2020/11/15 21:06
 * 输入两个链表，找出它们的第一个公共结点。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 *
 * 解题思路：
 *
 * 假设链表A和链表B有公共节点，那么若两个链表长度不相等，则可以在A链表头部增加B链表
 * B链表头部增加A链表，即A+B=B+A
 * 采用双指针进行遍历
 */
public class Offer036 {


    /**
     * 运行时间：13ms
     * 占用内存：9748k
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        //前提条件：两个链表必须有公共节点，否则将死循环
        while (p1 != p2) {
            //每个指针都向后走一步
            p1 = p1.next;
            p2 = p2.next;
            //此时若两个节点不相等
            if (p1 != p2) {
                //若A链表已经遍历到最后，则从B链表头部重新开始
                if (p1 == null) {
                    p1 = pHead2;
                }
                //若B链表已经遍历到最后，则从A链表头部重新开始
                if (p2 == null) {
                    p2 = pHead1;
                }
            }
        }
        return p1;
    }

}
