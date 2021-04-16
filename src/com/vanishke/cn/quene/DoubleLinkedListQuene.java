package com.vanishke.cn.quene;

import com.vanishke.cn.linkedlist.DoublePointLinkedList;
import static java.lang.System.out;
public class DoubleLinkedListQuene {

    private DoublePointLinkedList quene ;

    public DoubleLinkedListQuene()
    {
        quene = new DoublePointLinkedList();
    }

    public void insert(Object value)
    {
        quene.addHead(value);
    }

    public boolean remove()
    {
       return  quene.deleteHead();
    }

    public int getSize()
    {
        return quene.getSize();
    }

    public boolean isEmpty()
    {
        return (quene.getSize() == 0);
    }

    public static void main(String args[])
    {
        out.println("双端队列初始化");
        DoubleLinkedListQuene quene =new  DoubleLinkedListQuene();
        out.println("双端队列是否为空："+quene.isEmpty());
        out.println("双端队列长度："+quene.getSize());
        out.println("队列添加元素："+1);
        quene.insert(1);
        out.println("队列添加元素："+2);
        quene.insert(2);
        out.println("队列添加元素："+3);
        quene.insert(3);
        out.println("双端队列是否为空："+quene.isEmpty());
        out.println("双端队列长度："+quene.getSize());
        quene.remove();
        out.println("双端队列是否为空："+quene.isEmpty());
        out.println("双端队列长度："+quene.getSize());
    }
}
