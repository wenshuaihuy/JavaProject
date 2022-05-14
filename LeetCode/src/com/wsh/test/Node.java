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
     *链表长度
     */
    public int count;

    /**
     * 头结点
     */
    public Node root;

    /**
     *数据
     */
    public int data;
    /**
     *节点
     */
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    /**
     * 添加数据
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


}
