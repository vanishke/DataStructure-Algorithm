package com.vanishke.cn.tree;
import static java.lang.System.out;
//二叉树
public class BinaryTree implements Tree {
    //根节点
    private Node root;

    //查找对应数据的节点
    @Override
    public Node find(int data) {
        Node current = root;
        //非叶子节点的情况下遍历左右子树
        if(current != null)
        {
            //当前节点的数据大于查找的值,查找左子树
            if(current.data > data)
            {
                current  = current.leftNode;
            }
            //当前节点的数据小于查找的值，查找右子树
            else if(current.data < data)
            {
                current = current.rightNode;
            }
            else
            {
                //当前节点数据等于查找的值
                return current;
            }
        }
        //没有找到的情况下，返回空指针
        return null;
    }

    //插入节点
    @Override
    public boolean insert(int data) {

        Node current = root;
        Node parentNode  = null;
        Node newNode = new Node(data);
        //二叉树为空的情况下，插入节点直接升级为根节点
        if(root == null)
        {
            root = newNode;
            return true;
        }
        else
        {
            while(current != null)
            {
                parentNode = current;
                //遍历左子树，找到最后一个节点
                if(current.data > data)
                {
                   current = current.leftNode;
                   if(current == null)
                   {
                        parentNode.leftNode = newNode;
                        return true;
                   }
                }
                else
                {
                    //遍历右子树，找到最后一个节点
                    current = current.rightNode;
                    if(current == null)
                    {
                        parentNode.rightNode = newNode;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void delete(int data) {
        Node current = root;
    }
    //查找二叉树中的最大值
    @Override
    public Node findMax() {
        Node current = root;
        Node maxNode = current;
        //从二叉树根节点一直遍历左节点，最后一个不为空的节点就是最大值
        while(current != null)
        {
            maxNode = current;
            current = current.rightNode;
        }
        return maxNode;
    }
    //查找二叉树中的最小值
    @Override
    public Node findMin() {
        Node current = root;
        Node minNode = current;
        while(current != null)
        {
            minNode = current;
            current = current.leftNode;
        }
        return minNode;
    }
    //中序遍历
    @Override
    public void infixOrder(Node current) {
        //递归调用
        while(current != null)
        {
            //先遍历左节点
            infixOrder(current.leftNode);
            //遍历当前节点
            out.print(current.data);
            //遍历右节点
            infixOrder(current.rightNode);
        }
    }
    //前序遍历
    @Override
    public void preOrder(Node current) {
        //递归调用
        while(current != null)
        {
            //遍历当前节点
            out.print(current.data);
            //遍历左节点
            preOrder(current.leftNode);
            //遍历右节点
            preOrder(current.rightNode);
        }
    }
    //后续遍历
    @Override
    public void postOrder(Node current) {
        //递归调用
        while(current != null)
        {
            //遍历左节点
            postOrder(current.leftNode);
            //遍历右节点
            postOrder(current.rightNode);
            //遍历当前节点
            out.print(current.data);
        }
    }
}
