package com.vanishke.cn.stack;
import com.vanishke.cn.linkedlist.SingleLinkedList;
import static java.lang.System.out;
/*
单链表实现栈
 */
public class SingleLinkedListStack {
    private SingleLinkedList link ;

    //栈初始化
    public SingleLinkedListStack()
    {
        link = new SingleLinkedList();
    }
    // 压栈
    public void push(Object value)
    {
        link.addHead(value);
    }
    //出栈
    public Object pop()
    {
        return link.deleteHead();
    }
    //判断栈是否为空
    public boolean isEmpty()
    {
        return link.isEmpty();
    }
    //遍历栈
    public void display()
    {
        link.display();
    }
    public static void main(String args[])
    {
        SingleLinkedListStack stack = new SingleLinkedListStack();
        out.print("栈是否为空："+stack.isEmpty());
        out.print("压栈操作，入栈元素：A");
        stack.push("A");
        out.print("压栈操作，入栈元素：B");
        stack.push("B");
        out.print("压栈操作，入栈元素：C");
        stack.push("C");
        //遍历栈
        out.print("遍历栈");
        stack.display();
        out.print("出栈操作:");
        stack.pop();
        //遍历栈
        out.print("遍历栈");
        stack.display();
    }
}
