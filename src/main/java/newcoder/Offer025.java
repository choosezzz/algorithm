package newcoder;

import common.RandomListNode;

import java.util.HashMap;

/**
 * @Author dingshuangen
 * @Date 2020/10/31 0:15
 * <p>
 * 输入一个复杂链表
 * （每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点）
 * 请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Offer025 {

    /**
     * 借助HashMap存储每个节点值对应新的节点
     * 运行时间：13ms
     * 占用内存：9680k
     * @param pHead
     * @return
     */
    public RandomListNode clone(RandomListNode pHead){

        if (pHead == null){
            return null;
        }

        //原链表指针
        RandomListNode point = pHead;
        //新的链表头节点
        RandomListNode copyHead = new RandomListNode(pHead.label);
        //新的链表指针
        RandomListNode node = copyHead;
        //存储节点值对应新的节点
        HashMap<Integer, RandomListNode> nodeMap = new HashMap<>();
        nodeMap.put(pHead.label, copyHead);
        //复制链表next结构
        while (point != null){
            if (point.next != null){
                node.next = new RandomListNode(point.next.label);
                nodeMap.put(point.next.label, node.next);
                node = node.next;
            }
            point = point.next;
        }

        point = pHead;
        node = copyHead;
        while (point != null){
            node.random = point.random == null ? null : nodeMap.get(point.random.label);
            node = node.next;
            point = point.next;
        }
        return copyHead;
    }

    public RandomListNode Clone(RandomListNode pHead) {
        cloneNextNode(pHead);
        cloneRandomNode(pHead);
        return reconnectNode(pHead);
    }

    private void cloneNextNode(RandomListNode pHead) {
        RandomListNode node = pHead;
        while (node != null) {
            RandomListNode next = new RandomListNode(node.label);
            next.next = node.next;
            node.next = next;
            node = next.next;
        }
    }

    private void cloneRandomNode(RandomListNode pHead) {
        RandomListNode node = pHead;
        while (node != null) {
            RandomListNode clonedNext = node.next;
            if (node.random != null) {
                clonedNext.random = node.random.next;
            }
            node = clonedNext.next;
        }
    }

    private RandomListNode reconnectNode(RandomListNode pHead) {
        RandomListNode copyHead = null;
        RandomListNode copyNode = null;
        RandomListNode node = pHead;
        if (node != null) {
            copyHead = node.next;
            copyNode = copyHead;
            node.next = copyHead.next;
            node = node.next;
        }

        while (node != null) {
            copyNode.next = node.next;
            copyNode = copyNode.next;
            node.next = copyNode.next;
            node = node.next;
        }

        return copyHead;
    }
}
