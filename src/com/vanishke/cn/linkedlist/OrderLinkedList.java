package com.vanishke.cn.linkedlist;
import static java.lang.System.out;
//有序链表
public class OrderLinkedList {
    //头节点
    private Node head;

    public class Node
    {
        private int data; //节点数据
        private Node next;//指向下一个节点
        public Node(int data)
        {
            this.data = data;
        }
    }
    //链表初始化
    public OrderLinkedList()
    {
        head = null;
    }
    //头插法
    public void addHead(int value)
    {
        Node node = new Node(value);
        Node pre = null;
        Node current = head;
        if( current != null && value > current.data)
        {
            pre = current;
            current = current.next;
        }
        if(pre == null)
        {
            head = node;
            head.next = current;
        }
        else
        {
            pre.next = node;
            node.next = current;
        }
    }
    //删除头结点元素
    public void deleteHead()
    {
        head = head.next;
    }
    //链表遍历
    public void display()
    {
        Node node = head;
        while(node != null)
        {
            out.print(node.data+" ");
            node = node.next;
        }
        out.println();
    }

    public static void main(String args[])
    {
        OrderLinkedList link = new OrderLinkedList();
        out.println("有序链表初始化");
        out.println("添加元素 1");
        link.addHead(1);
        out.println("添加元素 3");
        link.addHead(3);
        out.println("添加元素 2");
        link.addHead(2);
        link.display();
    }
}
