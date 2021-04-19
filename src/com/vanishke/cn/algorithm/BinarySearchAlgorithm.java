package com.vanishke.cn.algorithm;
import static java.lang.System.out;
//二分查找
public class BinarySearchAlgorithm {

    public static int binarySearch(int array[] ,int key)
    {
        int start = 0;
        int last = array.length -1;
        while(start < last)
        {
            int mid = (last+start)/2 ;
            if(key == array[mid])
            {
                return mid;
            }
            else if(key > array[mid])
            {
               start = mid +1;
            }
            else if(key < array[mid])
            {
                last = mid -1;
            }
        }
        return -1;
    }


    public static void main(String args[])
    {
        int array[] = {1,2,3,4,5,6};
        //二分查找
        out.println(binarySearch(array,5));


    }
}
