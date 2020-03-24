package jike;

import java.util.LinkedList;

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

    /**
     * 添加元素
     * @param data
     */
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
    
    public void add(int data, int index) {
        // 得到链表长度
        int length = length();
        if (index <0 || index > length) {
            System.out.println("数组下标错误");
            return;
        }

        Node node = new Node(data);
        if (index == 0) {
//            Node headNode = head;
            node.next = head;
            head = node;
            return;
        }

        int i = 1;
        Node preNode = head;
        Node curNode = head.next;
        while (curNode != null) {
            if (i == index) {
                node.next = preNode.next;
                preNode.next = node;
                return;
            }
            if (i == length+1) {
                curNode.next = node;
            }
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
        preNode.next = node;

    }

    /**
     * 根据链表下标删除链表
     * @param index 元素的下标
     * @return  是否删除成功
     */
    public boolean delete(int index) {
        // 得到链表长度
        int length = length();

        // 数组下标错误
        if (index < 0 || index > length) {
            System.out.println("下标错误");
            return false;
        }

        // 删除第一个元素
        if (index == 0) {
            head = head.next;
            return true;
        }

        // 删除中间末尾元素
        Node preNode = head;
        Node curNode = head.next;
        int i = 1;
        while (curNode != null) {
            if (i == index) {
                preNode.next = curNode.next;
                return true;
            }
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }

        preNode.next = null;
        return true;
    }

    /**
     * 链表反转
     * 将链表数据放入一个数组中
     * 再次新建一个链表
     */
    public void reverseLink1() {

        int length = this.length();

        int [] arr = new int[length];

        if (head == null || head.next == null) {
            return;
        }

        int i = 0;
        Node pointer = head;
        while (pointer != null) {
            arr[i] = pointer.data;
            pointer = pointer.next;
            i++;
        }

        head = new Node(arr[length -1]);
        Node pointer2 = head;
        for (int j = 0; j < length -1; j++) {

            pointer2.next = new Node(arr[length-j-2]);
            pointer2 = pointer2.next;

        }

    }

    /**
     * 链表反转算法-2
     * next 指向 head.next 的下个节点 (前移一位）
     * head.next 指向 pre 上个节点 （指针反向）
     * pre 指向 head 节点 （前移一位）
     * head 指向 next 节点 （前移一位）
     * 动图地址：https://boolean-dev.oss-cn-hangzhou.aliyuncs.com/blog/file/2020-03/v2-c434ed3a1a229820ae04b07f26896d32_b.webp
     */
    public void reverseLink2() {
        if (head ==null || head.next == null) {
            return;
        }

        Node preNode = null;
        Node nextNode = null;
        while (head != null) {
            nextNode = head.next;
            head.next = preNode;
            preNode = head;
            head = nextNode;
        }
    }

    /**
     * 为链表添加一个环
     * @param data  data
     */
    public void addRing(int data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
            return;
        }
        node.next = head;

        Node pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = node;
    }

    /**
     * 检测是否有环
     * 快慢指针方法
     * @return  环的位置
     */
    public int checkRing() {
        if (head == null) {
            System.out.println("链表为空");
            return 0;
        }

        Node one = head;
        Node two = head.next.next;
        int index = 0;
        while (one.next != null) {
            if (one.next == two.next) {
                break;
            }
            one = one.next;
            if (two.next != null && two.next.next != null) {
                two = two.next.next;
            }else {
                return -1;
            }

            index++;
        }
        return index;
    }

    /**
     * 合并两个链表
     * @param second    待合并链表
     */
    public void merge(MyLink second) {
        if (head == null) {
            head = second.head;
        }

        // 遍历到第一个链表结尾
        Node pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = second.head;
    }

    /**
     * 删除倒数第 N 个数据
     * 使用快慢指针，快指针比慢指针先走 N 个元素
     * 随后快慢指针同样的速度走，当快指针走到终点，即找到了要删除的元素
     * @param reciprocalIndex   删除的倒数下标位置
     * @return  删除是否成功
     */
    public boolean deleteReciprocal(int reciprocalIndex) {
        int length = this.length();

        if (reciprocalIndex > length-1) {
            System.out.println("数组下标越界");
            return false;
        }

        Node slow = head;
        Node fast = head;
        for (int i = 0; i < reciprocalIndex; i++) {
            fast = fast.next;
        }
        int index = 0;
        Node preNode = null;
        while (fast.next != null) {
            preNode = slow;
            slow = slow.next;
            fast = fast.next;
            index++;
        }

        // 第一个节点
        if(preNode == null) {
            head = head.next;
        }else {
            preNode.next = slow.next;
        }


        return true;

    }

    /**
     * 查找中间节点
     * 利用快慢指针，快指针比慢指针每步多走一步
     * 当快指针走到末尾，慢指针走到中间
     * 注意链表奇偶长度判断，此处偶数取中间靠右节点
     * @return  中间节点数据
     */
    public int findMid() {
        if (head == null) {
            return -1;

        }
        if (head.next == null) {
            return head.data;
        }
        boolean isSinger = true;
        Node slow = head;
        Node fast = head;
        while (fast.next != null) {
            if (fast.next.next == null) {
                isSinger = false;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        if (isSinger) {
            return slow.data;
        }else {
            return slow.next.data;
        }
    }

    public int length() {
        int length = 0;

        Node pointer = head;
        while (pointer != null) {
            pointer = pointer.next;
            length++;
        }
        return length;
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
//            System.out.println("pointerData:" + pointer.data);
        }
        sb.append(pointer.data);
        return sb.toString();
    }


}


