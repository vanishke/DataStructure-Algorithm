package com.vanishke.cn.linkedlist;

import static java.lang.System.out;
public class SingleLinkedList {
    //链表大小
    private int size;
    //头结点
    private Node head;
    //链表构造初始化
    public SingleLinkedList()
    {
        size = 0;
        head = null; //链表为空的情况下头结点指向空指针
    }
    //内部节点初始化
    public class Node
    {
        private Object data; //每个节点存储数据
        private Node next; // 每个节点指向下一个节点指针
        // 节点数据赋值
        public Node(Object data)
        {
            this.data = data;
        }
    }
    //链表头增加节点
    public Object addHead(Object obj)
    {
        Node newNode = new Node(obj);
        //链表为空的情况下添加元素
        if(size == 0)
        {
            //头结点直接指向新增加节点
            head = newNode;
        }
        else
        {
            //头插法增加节点
            newNode.next = head;
            head = newNode;
        }
        size++;
        return obj;
    }
    //链表头删除节点
    public Object deleteHead()
    {
        Object obj = head.data;
        //头结点指向下一个节点，移除第一个节点
        head = head.next;
        size--;
        return obj;
    }
    //查找链表任意位置元素，找到了返回Node,找不到返回null;
    public Node find(Object obj)
    {
        //借助中间变量current、tempSize,更加方便的遍历链表，head节点和size属性在遍历过程中不受影响
        Node current = head;
        int tempSize = size;
        while(tempSize>0)
        {
            if(current.data.equals(obj))
            {
                //找到对应元素的情况下直接返回
                return current;
            }
            else
            {
                //指向当前链表的指针后移
               current = current.next;
            }
            tempSize--;

        }
        return null;
    }
    //链表任意位置删除元素
     public boolean delete(Object value)
     {
         //链表为空的情况下直接返回false
         if(size == 0)
         {
             return false;
         }
         //获取前一个元素节点当前节点
         Node previous = head;
         Node current = head;
         //当前节点和查找元素不相等的情况下
         while(current.data != value)
         {
             //链表只有一个节点元素的情况下没有找到直接返回false
             if(current.next == null)
             {
                 return false;
             }
             else
             {
                 //当前节点和前一个节点后移
                 previous = current;
                 current = current.next;
             }
         }
         //当前节点和查找元素相等
         //当前节点是头结点
         if(current == head)
         {
             head = head.next;
             size--;
         }
         else
         {
             //当前节点不是头结点
             previous.next = current.next;
             size--;
         }
         return true;
     }
     //判断链表是否为空
     public boolean isEmpty()
     {
         return (size == 0);
     }
     //遍历链表
     public void display()
     {
         Node node = head;
         int tempSize = size;
         if(size > 0)
         {
             //链表只有一个元素
            if(tempSize ==1)
            {
               out.print("["+node.data+"]");
            }
            else
            {
                //遍历操作
                while(tempSize > 0)
                {
                    //头结点处理方式
                    if(node.equals(head))
                    {
                        out.print("["+node.data+"->");
                    }
                    //尾结点处理方式
                    else if(node.next == null)
                    {
                        out.print(node.data+"]");
                    }
                    //中间节点处理方式
                    else
                    {
                        out.print(node.data+"->");
                    }
                    //节点后移
                    node = node.next;
                    tempSize--;
                }
            }
            out.println();
         }
         else
         {
                //链表为空的情况下打印空数据集合
                out.print("[]");
         }

     }
    public static void main(String args[])
    {
        out.println("单向链表");
        SingleLinkedList list = new SingleLinkedList();
        list.addHead("A");
        list.addHead("B");
        list.addHead("C");
        list.addHead("D");
        out.print("遍历链表:");
        list.display();
        out.print("链表删除元素B");
        list.delete("B");
        out.print("遍历链表:");
        list.display();
        out.print("遍历链表,查找元素C");
        out.print(list.find("C"));
    }
}
