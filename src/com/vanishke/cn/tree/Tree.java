package com.vanishke.cn.tree;
//二叉树
public interface Tree {

    /**
     * 查找节点
     * @param data
     * @return
     */
    public Node find(int data);

    /**
     * 插入节点
     * @param Data
     */
    public boolean insert(int Data);

    /**
     * 删除节点
     * @param data
     */
    public void delete(int data);

    /**
     * 查找最大值
     * @return
     */
    public Node findMax();

    /**
     * 查找最小值
     * @return
     */
    public Node findMin();

    /**
     * 中序遍历
     * @param current
     */
    public void infixOrder(Node current);

    /**
     * 前序遍历
     * @param current
     */
    public void preOrder(Node current);

    /**
     * 后序遍历
     * @param current
     */
    public void postOrder(Node current);

}
