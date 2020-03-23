package jike;

/**
 * 链表数据结构联系
 *
 * @author Jiantao Yan
 * @title: MyLink
 * @date 2020/3/23 18:32
 */
public class MyLink {

    Node head = null;

    /**
     * 链表数据结构
     */
    class Node {
        Node next = null;
        int data;
        public Node(int data) {
            this.data = data;
        }
    }

    public void add(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }

        Node pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = node;

    }

    @Override
    public String toString() {
        if (head == null) {
            System.out.println("链表为空");
            return "链表为空";
        }

        StringBuffer sb = new StringBuffer();

        Node pointer = head;
        while (pointer.next != null) {
            sb.append(pointer.data).append("->");
            pointer = pointer.next;
        }
        sb.append(pointer.data);
        return sb.toString();
    }


}


