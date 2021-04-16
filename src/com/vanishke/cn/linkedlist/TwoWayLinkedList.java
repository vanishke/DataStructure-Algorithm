package com.vanishke.cn.linkedlist;
import static java.lang.System.out;
//双向链表
public class TwoWayLinkedList {
    //头结点
    private Node head;
    //尾结点
    private Node tail;
    //链表大小
    private int size;
    public class Node
    {
        private Object data;
        private Node prev;
        private Node next;
        public Node(Object data)
        {
            this.data = data;
        }
    }
    //链表初始化
    public TwoWayLinkedList()
    {
        head = null;
        tail = null;
        size = 0;
    }
    //链表头新增节点
    public void addHead(Object value)
    {
        Node newNode = new Node(value);
        if(size == 0)
        {
            head = newNode;
            tail = newNode;
            size++;
        }
        else
        {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            size++;
        }
    }
    //链表尾新增节点
    public void  addTail(Object value)
    {
        Node newNode = new Node(value);
        if(size == 0)
        {
            head = newNode;
            tail = newNode;
            size++;
        }
        else
        {
            newNode.prev = tail;
            tail.next = newNode;
            tail  = newNode;
            size++;
        }
    }
    //链表头部删除节点
    public Node deleteHead()
    {
        Node temp = head;
        if(size != 0)
        {
            head = head.next;
            head.prev = null;
            size--;
        }
        return temp;
    }
    //链表尾部删除节点
    public Node deleteTail()
    {
        Node temp = tail;
        if(size != 0)
        {
            tail = tail.prev;
            tail.next = null;
            size--;
        }
        return temp;
    }
    //获取链表长度
    public int getSize()
    {
        return size;
    }
    //判断链表是否为空
    public boolean isEmpty()
    {
        return (size == 0);
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
                out.println("["+node.data+"]");
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
            out.println("[]");
        }
    }

    public static void main(String args[])
    {
        TwoWayLinkedList link = new TwoWayLinkedList();
        out.println("双端链表初始化");
        out.println("双端链表是否为空：" + link.isEmpty());
        out.println("双端链表长度：" + link.getSize());
        out.println("链表头部添加元素"+1);
        link.addHead(1);
        out.println("链表头部添加元素"+2);
        link.addHead(2);
        out.println("链表头部添加元素"+4);
        link.addHead(4);
        out.println("链表头部添加元素"+6);
        link.addHead(6);
        out.println("链表头部添加元素"+3);
        link.addHead(3);
        out.println("链表尾部添加元素"+5);
        link.addTail(5);
        out.println("双端链表是否为空：" + link.isEmpty());
        out.println("双端链表长度：" + link.getSize());
        out.println("链表遍历");
        link.display();
    }

}


