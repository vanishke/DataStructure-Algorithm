package com.vanishke.cn.stack;
//栈实现
public class MyStack {
    //栈存储数据数组
    private int[] array;
    //栈大小
    private int maxSize;
    //栈顶
    private int top ;

    //栈初始化
    public  MyStack(int size)
    {
        this.maxSize = size;
        array = new int[size];
        top = -1;
    }

    //出栈
    public int pop()
    {
        return array[top--];

    }
    //压栈
    public void push(int value)
    {
        if(top < maxSize-1)
        {
            array[++top] = value;
        }

    }
    //访问栈顶元素
    public int peek()
    {
        return array[top];
    }

    //判断栈空
    public boolean isEmpty()
    {
        return (top == -1);
    }
    //判断栈满
    public boolean isFull()
    {
        return (top == maxSize-1);
    }

    public static void main(String args[])
    {
        System.out.println("初始化栈，大小为："+5);
        MyStack stack = new MyStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("访问栈顶元素："+ stack.peek());
        System.out.println("栈是否为空："+stack.isEmpty());
        System.out.println("栈是否满："+stack.isFull());
    }

}
