/**
 * @author 谛听
 * @className Leetcode02
 * @descriiption TODO
 * @date 2019/11/20 11:47
 **/
public class Leetcode02 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode11 = new ListNode(4);
        ListNode listNode12 = new ListNode(9);
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
        leetcode02.addTwoNumbers(listNode12, listNode2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

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