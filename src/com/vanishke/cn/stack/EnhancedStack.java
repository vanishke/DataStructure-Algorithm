package com.vanishke.cn.stack;

import java.util.Arrays;
import java.util.EmptyStackException;
//加强型栈实现
public class EnhancedStack {

    private Object[] elementData;

    private int size;

    private int top;

    public EnhancedStack()
    {
        elementData = new Object[10];
        this.top = -1;
        this.size = 10;
    }


    public EnhancedStack(int initCapacity)
    {
        if(initCapacity < 0)
        {
            throw new IllegalArgumentException("栈初始化容量不能小于0："+initCapacity);
        }
        this.elementData = new Object[initCapacity];
        this.top = -1;
        this.size = initCapacity;
    }

    public  Object pop()
    {
        Object o = peek();
        remove(this.top);
        return o;

    }

    public Object push(Object item)
    {
        isGrow(this.top+1);
        elementData[++this.top] = item;
        return item;
    }

    public boolean isEmpty()
    {
        return (this.top==-1);
    }

    public boolean isFull()
    {
        return (this.top == this.size-1);
    }
    public Object peek()
    {
        if(this.top == -1)
        {
            throw new EmptyStackException();
        }
        else
        {
            return elementData[this.top];
        }
    }

    public void remove(int top)
    {
        elementData[top] = null;
        this.top--;
    }

    public boolean isGrow(int minCapacity)
    {
        int oldCapacity = this.elementData.length;
        if(minCapacity >= oldCapacity)
        {
            int newCapacity = 0;
            if((minCapacity<<1) - Integer.MAX_VALUE > 0)
            {
                newCapacity = Integer.MAX_VALUE;
            }
            else
            {
                newCapacity =  (minCapacity<<1);
            }
            this.size = newCapacity;
            elementData = Arrays.copyOf(elementData,size);
            return true;
        }
        else
        {
           return false;
        }
    }

    public static void main(String args[])
    {
        /* 栈空间可扩展实现，可存储多种类型
        EnhancedStack s = new EnhancedStack(3);
        System.out.println("压栈");
        s.push(1);
        System.out.println("压栈");
        s.push(2);
        System.out.println("压栈");
        s.push(3);
        System.out.println("栈是否满"+s.isFull());
        System.out.println("栈是否空"+s.isEmpty());
        System.out.println("压栈");
        s.push("abc");
        System.out.println("访问栈顶元素：");
        System.out.println(s.peek());
        System.out.println("出栈");
        System.out.println(s.pop());
        System.out.println("出栈");
        System.out.println(s.pop());
        System.out.println("出栈");
        System.out.println(s.pop());
        System.out.println("访问栈顶元素：");
        System.out.println(s.peek());
        */
        /* 利用栈特性，反转字符串
        EnhancedStack s = new EnhancedStack(3);
        String reverseStr = " this is a reverse String";
        char charArr[] = reverseStr.toCharArray();
        //压栈
        for(char c : charArr)
        {
            s.push(c);
        }
        //出栈
        while(!s.isEmpty())
        {
            System.out.print(s.pop());
        }
        */
        //利用栈实现运算符检测
        EnhancedStack stack = new EnhancedStack(3);
        String str = "12<a[b{c}]>";
        char[] cha = str.toCharArray();
        for(char c : cha){
            switch (c) {
                case '{':
                case '[':
                case '<':
                    stack.push(c);
                    break;
                case '}':
                case ']':
                case '>':
                    if(!stack.isEmpty()){
                        char ch = stack.pop().toString().toCharArray()[0];
                        if(c=='}' && ch != '{'
                                || c==']' && ch != '['
                                || c==')' && ch != '('){
                            System.out.println("Error:"+ch+"‐"+c);
                        }
                        else
                        {
                            System.out.println("match");
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
