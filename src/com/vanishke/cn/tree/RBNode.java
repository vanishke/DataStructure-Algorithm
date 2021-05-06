package com.vanishke.cn.tree;

public class RBNode <T extends Comparable<T>>{
    //节点颜色
    private boolean color;
    //节点值
    private T key;
    //父节点
    private RBNode parent;
    //左子节点
    private RBNode left;
    //右子节点
    private RBNode right;

    public RBNode(boolean color ,T key,RBNode<T> left,RBNode<T> right,RBNode<T> parent)
    {
        this.color = color;
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public T getKey()
    {
        return key;
    }
    @Override
    public String toString()
    {
        return ""+key+(color == true?"R":"B");
    }
}
