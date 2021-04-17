package com.vanishke.cn.sort;

public class BubbleSort {

    public static int[] sort(int []array)
    {
       for(int i=0;i<array.length-1;i++)
       {
           boolean flag = true;
           for(int j=0;j<array.length-i-1;j++)
           {
               if(array[j+1] < array[j])
               {
                   int temp = array[j];
                   array[j] = array[j+1];
                   array[j+1] = temp;
                   flag = false;
               }

           }
           if(flag)
           {
               break;
           }
           System.out.print("第"+i+"轮排序结果为：");
           display(array);
       }
       return array;
    }

    public static void display(int []array)
    {
        for(int k = 0 ;k < array.length;k++)
        {
            System.out.print(array[k]+" ");
        }
        System.out.println();
    }

    public static void main(String []args)
    {
        int[] array = {4,2,8,9,5,7,6,1,3};
        //未排序数组顺序为
        System.out.println("未排序数组顺序为：");
        display(array);
        System.out.println("‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐");
        array = sort(array);
        System.out.println("‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐");
        System.out.println("经过冒泡排序后的数组顺序为：");
        display(array);
    }
}
