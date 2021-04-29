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

    //删除节点
    @Override
    public boolean delete(int data) {
        //记录当前节点
        Node current = root;
        //记录父节点
        Node parentNode = root;
        //记录是否是父节点的左分支
        boolean isLeftChild = false;
        while(current.data != data)
        {
            //当前节点数据大于查找的数据，遍历左子树
            parentNode = current;
            if(current.data > data)
            {
                //进入左分支
                isLeftChild =true;
                current = current.leftNode;
            }
            //当前节点数据小于查找的数据，遍历右子树
            else
            {
                //进入右分支
                isLeftChild = false;
                current = current.rightNode;
            }
            //没有找到对应的节点值
            if(current == null)
            {
                return false;
            }
        }
        //当前节点是叶子节点，左右子树为空
        if(current.leftNode == null && current.rightNode == null)
        {
            //查找到的节点是根节点
            if(current == root)
            {
                root = null;
            }
            //查找到节点是左子树叶子结点
            else if(isLeftChild)
            {
                parentNode.leftNode = null;
            }
            //查找到的节点是右子树叶子节点
            else
            {
                parentNode.rightNode = null;
            }
            return true;
        }
        //当前节点只有一个右子节点
        if(current.leftNode == null && current.rightNode != null)
        {
            //根节点下只有一个右叶子节点
            if(current == root)
            {
                root = current.rightNode;
            }
            //查找到的节点只有右子节点，且属于父节点的左分支
            else if(isLeftChild)
            {
                parentNode.leftNode = current.rightNode;
            }
            //查找到的节点只有右子节点，且属于父节点的右分支
            else
            {
                parentNode.rightNode = current.rightNode;
            }
            return true;
        }
        //当前只有一个左子节点
        if(current.leftNode != null && current.rightNode == null)
        {
            //根节点只存在一个左叶子节点
            if(current == root)
            {
                root = current.leftNode;
            }
            //查找到的节点是左节点，且属于父节点左分支
            else if(isLeftChild)
            {
                parentNode.leftNode = current.leftNode;
            }
            //查找到的节点是左节点，且属于父节点右分支
            else
            {
                parentNode.rightNode = current.leftNode;
            }
            return true;
        }
        //左右子树都不空，至少存在两个子节点
        if(current.leftNode != null && current.rightNode != null)
        {
            //获取待删除节点的后继节点
            Node successor = getSuccessor(current);
            //待删除节点是根节点
            if(current == root)
            {
                root = successor;
            }
            //待删除节点是其父节点的左分支
            else if(isLeftChild)
            {
                //父节点的左分支指向后继节点的左子树
                parentNode.leftNode = successor.leftNode;
            }
            //待删除节点是其父节点的右分支
            else
            {
                //父节点的右分支指向后继节点的右子树
                parentNode.rightNode = successor.rightNode;
            }
            //后继节点的左分支指向待删除节点的左子树
            successor.leftNode = current.leftNode;
            return true;
        }

        return false;
    }

    //查找后继节点,后继节点为待删除节点右子树中最小值节点
    @Override
    public Node getSuccessor(Node delNode){
        //记录后继节点的父节点
        Node successorParent = delNode;
        //记录后继节点
        Node successor = delNode;
        //记录待删除节点的右子树的第一个节点
        Node current = delNode.rightNode;
        while(current!=null)
        {
            //遍历右子树左分支上的节点
            successorParent = successor;
            successor = current;
            current = current.leftNode;
        }
        //后继节点不是右子树的头结点，位于左分支上的处理
        if(successor != delNode.rightNode)
        {
            //后继节点的父节点的左分支指向后继节点的右子树
            successorParent.leftNode = successor.rightNode;
            //后继节点的有分支指向待删除节点的右子树
            successor.rightNode = delNode.rightNode;
        }

        return successor;

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
        if(current != null)
        {
            //先遍历左节点
            infixOrder(current.leftNode);
            //遍历当前节点
            out.print(current.data+" ");
            //遍历右节点
            infixOrder(current.rightNode);
        }

    }
    //前序遍历
    @Override
    public void preOrder(Node current) {
        //递归调用
        if(current != null)
        {
            //遍历当前节点
            out.print(current.data+" ");
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
        if(current != null)
        {
            //遍历左节点
            postOrder(current.leftNode);
            //遍历右节点
            postOrder(current.rightNode);
            //遍历当前节点
            out.print(current.data+" ");
        }

    }


    public static void main(String args[])
    {
        BinaryTree bt = new BinaryTree();
        bt.insert(10);
        bt.find(10);
        bt.insert(12);
        bt.insert(13);
        bt.insert(14);
        bt.insert(15);
        bt.insert(16);
        bt.insert(18);
        bt.insert(100);
        bt.delete(16);
        bt.delete(20);
        out.println("查找最大值："+bt.findMax().data);
        out.println("查找最小值："+bt.findMin().data);

        bt.infixOrder(bt.root);
        out.println();
        bt.preOrder(bt.root);
        out.println();
        bt.postOrder(bt.root);

    }
}
