package com.wsh.test;

/**
 * @author wsh
 * @date 2022/5/8 8:25 下午
 */
public class Node {

    /**
     * 根节点索引位置
     */
    public int foot;

    /**
     * 链表长度
     */
    public int count;

    /**
     * 头结点
     */
    public Node root;

    /**
     * 数据
     */
    public int data;
    /**
     * 节点
     */
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    /**
     * 添加数据
     *
     * @param data
     */
    private void add(int data) {
        //如何当前节点的下一个数据是空的话就进行data赋值
        if (this.next == null) {
            this.next = new Node(data);
        } else { //否则递归 去查看下一个数据节点是不是空
            this.next.add(data);
        }
    }

    private void remove(Node node, int index) {

    }

    /**
     * 反转单链表
     *
     * @param head
     * @return
     */
    private static Node reverseNode(Node head) {
        Node per = null;
        Node next = null;
        while (head != null) {
            //保存当前节点的后续节点
            next = head.next;
            //改变当前节点的指向
            head.next = per;
            per = head;
            head = next;
        }
        return per;
    }

    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Node node = new Node(2);
        Node node1 = Node.reverseNode(node);
        printLinkedList(node1);

    }



}
