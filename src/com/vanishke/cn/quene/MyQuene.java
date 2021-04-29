package com.vanishke.cn.quene;

import java.util.concurrent.ThreadPoolExecutor;

import static java.lang.System.out;
//队列
public class MyQuene {
    //队列实际数据存放数组
    private Object[] queArray;
    //队列最大长度
    private int maxSize;
    //队头指针
    private int front;
    //队尾指针
    private int rear;
    //时间队列大小
    private int nItems;

    /*
        初始化
     */
    public MyQuene(int s)
    {
        maxSize = s;
        queArray = new Object[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
    /*
        入队
     */
    public void insert(int value)
    {
        if(isFull())
        {
            System.out.println("队列已满！！！");
        }
        else
        {
            if(rear == maxSize-1)
            {
                rear = -1;
            }
            queArray[++rear] = value;
            nItems++;
        }
    }

    public Object remove()
    {
        Object removeValue = null;
        if(isEmpty())
        {
            System.out.println("队列为空！");
        }
        else
        {
            removeValue = queArray[front];
            queArray[front] = null;
            front++;
            if(front == maxSize)
            {
                front = 0;
            }
            nItems--;
            return removeValue;
        }
        return removeValue;
    }
    /*
        队列是否满
     */
    public boolean isFull()
    {
        return (maxSize == nItems);
    }
    /*
        队列是否空
     */
    public boolean isEmpty()
    {
        return  (nItems == 0);
    }
    /*
        队列实际大小
     */
    public int getSize()
    {
        return nItems;
    }
    /*
    访问队头元素
     */
    public Object peekFront()
    {
        return queArray[front];
    }

    public static void main(String args[])
    {
        MyQuene queue = new MyQuene(3);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);//queArray数组数据为[1,2,3]
        out.println(queue.peekFront()); //1
        queue.remove();//queArray数组数据为[null,2,3]
        out.println(queue.peekFront()); //2
        queue.insert(4);//queArray数组数据为[4,2,3]
        queue.insert(5);//队列已满,queArray数组数据为[4,2,3]
        queue.remove();//[4,null,3]
        out.println(queue.peekFront());//3
        queue.remove();//[4,null,null]
        out.println(queue.peekFront());//4
        queue.remove();//[null,null,null]
        out.println(queue.getSize());//0
        out.println(queue.peekFront());//null

    }
}
