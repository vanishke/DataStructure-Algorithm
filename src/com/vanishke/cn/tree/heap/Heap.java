package com.vanishke.cn.tree.heap;

public class Heap {

    private int maxSize;
    private int currentSize;
    private Node[] heapArray;

    public Heap(int size)
    {
        this.maxSize = size;
        currentSize = 0;
        heapArray = new Node[size];
    }

    public boolean isFull()
    {
        return currentSize == maxSize;
    }

    public boolean isEmpty()
    {
        return currentSize == 0;
    }

    public boolean insert(int key) {
        if (isFull()) {
            return false;
        }
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickUp(currentSize++);
        return true;
    }

    public void trickUp(int index)
    {
        int parent = (index-1)/2;
        while(index > 0 && heapArray[parent].getKey() < heapArray[index].getKey())
        {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent-1)/2;
        }
    }

    public void remove(int key)
    {

    }

}
