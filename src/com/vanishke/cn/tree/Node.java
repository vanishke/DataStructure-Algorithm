package com.vanishke.cn.tree;
import static java.lang.System.out;
//二叉树节点
public class Node{
    //节点数据
    public  int data;
    //左节点
    public  Node leftNode;
    //右节点
    public  Node rightNode;
    //节点初始化
    public Node(int data)
    {
        this.data = data;
    }
    public void display()
    {
        out.println(data);
    }
}
