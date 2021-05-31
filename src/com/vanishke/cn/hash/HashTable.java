package com.vanishke.cn.hash;

/**
 * 哈希表线性探测实现
 */
public class HashTable {
    /**
     * 哈希表
     */

    private DataItem[] hashArray;
    /**
     * 哈希表容量
     */
    private int arraySize;
    /**
     * 实际存储大小
     */
    private int itemNum;
    /**
     * 空元素
     */
    private DataItem nonItem;

    /**
     * 哈希表初始化
     * @param arraySize
     */
    public HashTable(int arraySize)
    {
        this.arraySize = arraySize;
        this.hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
    }

    /**
     * 判断哈希表是否为空
     * @return
     */
    public boolean isEmpty()
    {
        return itemNum == 0;
    }

    /**
     * 判断哈希表是否已满
     * @return
     */
    public boolean isFull()
    {
       return itemNum == arraySize;
    }

    /**
     * 哈希计算方法，获取数据存储下标
     * @param key
     * @return
     */
    public int hash(int key)
    {
        return key%arraySize;
    }

    /**
     * 哈希表添加元素
     * @param item
     */
    public void insert(DataItem item)
    {
        if(isFull())
        {
            System.out.println("哈希表已满，重新hash");
            expandTable();
        }
        int hashVal = hash(item.getKey());
        while(hashArray[hashVal] !=null && hashArray[hashVal].getKey() != -1)
        {
            ++hashVal;
            hashVal = hashVal%arraySize;
        }
        hashArray[hashVal] = item;
        itemNum++;
    }

    /**
     * 遍历哈希表
     */
    public void display()
    {
        System.out.print(" display Table:");
        for(int j= 0;j<arraySize;j++)
        {
            if(hashArray[j]!=null)
            {
                System.out.print(hashArray[j].getKey()+" ");
            }
            else
            {
                System.out.print("** ");
            }
        }
    }

    /**
     * 哈希表查找元素
     */
    public DataItem find(int key)
    {
        int hashVal = hash(key);
        while(hashArray[hashVal] != null )
        {
            if(hashArray[hashVal].getKey() == key)
            {
                return hashArray[hashVal];
            }
            ++hashVal;
            hashVal%=arraySize;
        }
        return null;
    }

    /**
     * 哈希表删除元素
     * @param key
     * @return
     */
    public DataItem delete(int key)
    {
        int hashVal = hash(key);
        while(hashArray[hashVal]!=null )
        {
            if(hashArray[hashVal].getKey() == key)
            {
                    DataItem item = hashArray[hashVal];
                    hashArray[hashVal] = nonItem;
                    itemNum--;
                    return item;
            }
            ++hashVal;
            hashVal%=arraySize;
        }
        return null;
    }

    /**
     * 哈希表扩展
     */
    public void expandTable()
    {
        DataItem[] oldHashArray = hashArray;
        itemNum = 0;
        arraySize*=2;
        hashArray = new DataItem[arraySize];
        //拷贝节点元素
        for(int i=0;i<oldHashArray.length;i++)
        {
           insert(oldHashArray[i]);
        }
    }

    /**
     * 数据节点
     */
    private static class DataItem {
        int data;

        public DataItem(int data)
        {
            this.data = data;
        }
        public int  getKey()
        {
            return data;
        }
    }

    public static void main(String args[])
    {
        HashTable hashTable = new HashTable(5);
        hashTable.insert(new DataItem(1));
        hashTable.insert(new DataItem(2));
        hashTable.insert(new DataItem(3));
        hashTable.insert(new DataItem(4));
        hashTable.insert(new DataItem(5));
        System.out.println(hashTable.find(1).data);
        hashTable.delete(2);
        hashTable.display();

    }

}
