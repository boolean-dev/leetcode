/**
 * @author 谛听
 * @className Leetcode02
 * @descriiption TODO
 * @date 2019/11/20 11:47
 **/
public class Leetcode02 {


    /*
    给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

    示例：

    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 0 -> 8
    原因：342 + 465 = 807
     */

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode11 = new ListNode(4);
        ListNode listNode12 = new ListNode(3);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode21 = new ListNode(9);
        ListNode listNode22 = new ListNode(9);
        ListNode listNode23 = new ListNode(9);
        ListNode listNode24 = new ListNode(9);
        ListNode listNode25 = new ListNode(9);
        ListNode listNode26 = new ListNode(9);
        ListNode listNode27 = new ListNode(9);
        ListNode listNode28 = new ListNode(9);
        ListNode listNode29 = new ListNode(9);

        listNode11.next = listNode12;
        listNode1.next = listNode11;

        listNode28.next = listNode29;
        listNode27.next = listNode28;
        listNode26.next = listNode27;
        listNode25.next = listNode26;
        listNode24.next = listNode25;
        listNode23.next = listNode24;
        listNode22.next = listNode23;
        listNode21.next = listNode22;
        listNode2.next = listNode21;

        System.out.println(listNode1.toString());
        System.out.println(listNode2.toString());

        Leetcode02 leetcode02 = new Leetcode02();
//        leetcode02.addTwoNumbers(listNode1, listNode2);
        leetcode02.addTwoNumbers(new ListNode(1), listNode2);
    }


    /**
     * 优化之后的算法
     * 模拟加法相加，每个节点单独比较
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;

        int add = 0;
        ListNode result = null;
        ListNode next = null;
        int index = 0;

        // 两个都不为空，则走下面循环
        while (p.next != null || q.next != null) {
            int tempValue = p.val + q.val + add;
            add = (tempValue/10) >=1 ? tempValue/10 : 0;

            // 如果是第一次，则生成根节点
            if (index == 0) {
                result = new ListNode(tempValue % 10);
                next = result;
            }else {
                ListNode temp =  new ListNode(tempValue % 10);
                next.next = temp;
                next = temp;
            }

            // 一次比较完成，指向下一个节点
            p = p.next != null ? p.next : new ListNode(0);
            q = q.next != null ? q.next : new ListNode(0);
            index++;
        }

        // 如果两个的下个节点都为空
        int tempValue = p.val + q.val + add;
        add = (tempValue/10) >=1 ? tempValue/10 : 0;
        ListNode temp =  new ListNode(tempValue % 10);

        // 如果上面循环从未执行过，则两个节点都没有子节点，则当前节点则为结果的根节点
        if (next == null) {
            result = temp;
            next = temp;
        }else {
            next.next = temp;
            next = temp;
        }

        next.next = add >= 1 ? new ListNode(add) : null;

        System.out.println(result.toString());
        return result;
    }




    // --------------------------------------------------------------------------------
    // 以下为错误解法


    /**
     * 下面思路是将其转换成int，然后int相加，然后再转换成node
     * 数值过大，会溢出弃用
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {

        long node1Value = this.nodeToNum(l1);
        long node2Value = this.nodeToNum(l2);
        System.out.println(node1Value);
        System.out.println(node2Value);
        long nodeValue = node1Value + node2Value;

        ListNode result = this.numToNode(nodeValue);
        System.out.println(result.toString());
        return result;
    }

    private long nodeToNum(ListNode node) {
        long result = 0;
        int heep = 0;
        ListNode indexNode = node;
        do {
            System.out.println("Math.pow(10, heep)=" + Math.pow(10, heep));
            result += indexNode.val * Math.pow(10, heep);
            indexNode = indexNode.next;
            heep++;
        }while (indexNode != null);

        return result;
    }

    private ListNode numToNode(long num) {
        ListNode root = new ListNode(0);
        ListNode next = null;
        if (num >= 1) {
            root = new ListNode((int) (num % 10));
            num /= 10;
            next = root;
        }
        while (num >= 1) {
            ListNode temp = new ListNode((int) (num % 10));
            num /= 10;
            next.next = temp;
            next = temp;
        }
        return root;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}