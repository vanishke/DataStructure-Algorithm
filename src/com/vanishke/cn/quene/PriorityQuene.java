package com.vanishke.cn.quene;

import static java.lang.System.out;
//优先级队列
public class PriorityQuene {

    private int maxSize;

    private int[] priorityArry;

    private int nItems;

    public PriorityQuene(int s)
    {
        maxSize = s;
        priorityArry = new int[maxSize];
        nItems = 0;
    }

    public void insert(int value)
    {
        int j;
        if(nItems == 0)
        {
            priorityArry[nItems++] = value;
        }
        else
        {
            if(maxSize > nItems)
            {
                j = nItems -1;
                while(j>=0 && value >priorityArry[j])
                {
                    priorityArry[j+1] = priorityArry[j];
                    j--;
                }
                priorityArry[j+1] = value;
                nItems ++;
            }
            else
            {
                out.println("优先级队列已满！");
            }

        }
    }

    public int remove()
    {
        int k = nItems -1;
        int value = priorityArry[k];
        priorityArry[k] = -1;
        nItems--;
        return value;
    }

    public boolean isEmpty()
    {
        return (nItems == 0);
    }

    public boolean isFull()
    {
        return (maxSize == nItems-1);
    }

    public int peekMin()
    {
        return priorityArry[nItems-1];
    }

    public static void main(String args[])
    {
        PriorityQuene quene = new PriorityQuene(3);
        quene.insert(2);
        quene.insert(1);
        quene.insert(3);
        out.println("访问优先级队列元素："+quene.peekMin());
        out.println("优先级队列是否为空："+quene.isEmpty());
        out.println("优先级队列是否满："+quene.isFull());
        quene.insert(4);
    }
}
