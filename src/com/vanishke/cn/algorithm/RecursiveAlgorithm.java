package com.vanishke.cn.algorithm;
import static java.lang.System.out;
public class RecursiveAlgorithm {
    //阶乘
    public static int getFactorial(int n)
    {
        if(n < 0)
        {
            return -1;
        }
        else if(n == 0 || n == 1)
        {
            return 1;
        }
        else
        {
           return n*getFactorial(n-1);
        }
    }
    //二分递归查找
    public static int recursiveSearch(int array[],int key,int start,int last)
    {
        int mid = (start+last)/2;
        if(start < last)
        {
            if(key == array[mid])
            {
                return mid;
            }
            else if(key < array[mid])
            {
                return recursiveSearch(array,key,start,mid-1);
            }
            else if(key > array[mid])
            {
                return recursiveSearch(array,key,mid+1,array.length);
            }
        }
        return -1;
    }
    public static void main(String args[])
    {
        //阶乘计算
        int n =10;
        out.println(getFactorial(n));
        //递归查找
        int array[] = {1,2,3,4,5,6};
        out.println(recursiveSearch(array,6,0,array.length-1));
    }
}
