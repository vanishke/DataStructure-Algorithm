package com.vanishke.cn.sort;
import java.util.Arrays;
import static java.lang.System.out;
// 插入排序
public class DirectInsertSort {

    public static void sort(int arr[])
    {
        //记录每次需要直接插入的值
       int temp;
       //待排序序列从下表1开始，第一个元素自动有序
       for(int i=1;i< arr.length;i++)
       {
           temp = arr[i];
           if(arr[i-1] > arr[i])
           {
               for(int j=i;j>=0;j--)
               {
                   if(j>0 && arr[j-1] > temp)
                   {
                        arr[j] = arr[j-1];
                   }
                   else
                   {
                       arr[j] = temp;
                       break;
                   }
               }
               out.print("第"+i+"次比较结果");
               out.println(Arrays.toString(arr));
           }

       }
    }

    public static void main(String args[])
    {

        int arr[] = {2,1,5,3,6,4,9,8,7};
        out.println("排序前：");
        out.println(Arrays.toString(arr));
        sort(arr);
        out.println("排序后：");
       out.print(Arrays.toString(arr));
       out.println();
    }
}
