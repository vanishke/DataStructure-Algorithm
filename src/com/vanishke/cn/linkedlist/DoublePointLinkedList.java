package com.vanishke.cn.linkedlist;
import static java.lang.System.out;
//双端链表
public class DoublePointLinkedList {
    //链表大小
    private int size;
    //链表头结点
    private Node head;
    //链表尾结点
    private Node tail;

    private class Node
    {
        private Object data;//节点数据
        private Node next;//指向下一个节点
        public Node(Object data)
        {
            this.data = data;
        }
    }
    //链表初始化
    public DoublePointLinkedList()
    {
        size = 0;
        head = null;
        tail = null;
    }
    //头插法
    public void addHead(Object data)
    {
        Node newNode  = new Node(data);
        if(size == 0)
        {
            head = newNode;
            tail = newNode;
            size++;
        }
        else
        {
            newNode.next = head;
            head = newNode;
            size++;
        }
    }
    //尾插法
    public void addTail(Object data)
    {
        Node newNode = new Node(data);
        if(size == 0)
        {
            head = newNode;
            tail = newNode;
            size++;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }
    //删除头结点元素
    public boolean deleteHead()
    {
        if(size == 0 )
        {
            return false;
        }
        if(head.next == null)
        {
            head = null;
            tail = null;
        }
        else
        {
            head = head.next;
        }
        size--;
        return true;
    }
    //判断链表是否为空
    public boolean isEmpty()
    {
        return (size == 0);
    }
    //获取链表大小
    public int getSize()
    {
        return size;
    }
    //链表遍历
    public void display()
    {
        Node node = head;
        int tempSize = size;
        if(size > 0)
        {
            if(tempSize == 1)
            {
                out.print("["+node.data+"]");
            }
            while(tempSize > 0)
            {
                if(node.equals(head))
                {
                   out.print("["+node.data+"->");
                }
                else if(node.next == null)
                {
                    out.print(node.data+"]");
                }
                else
                {
                    out.print(node.data+"->");
                }
                node = node.next;
                tempSize--;
            }
            out.println();
        }
        else
        {
            out.print("[]");
        }
    }

    public static void main(String args[])
    {
        DoublePointLinkedList link = new DoublePointLinkedList();
        out.println("双端列表初始化");
        out.println("头插法：新增节点A");
        link.addHead("A");
        out.println("头插法：新增节点B");
        link.addHead("B");
        out.println("头插法：新增节点C");
        link.addHead("C");
        out.println("链表是否为空"+link.isEmpty());
        out.print("遍历链表");
        link.display();
    }
}
