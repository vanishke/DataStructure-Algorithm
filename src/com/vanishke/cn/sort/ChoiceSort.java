package com.vanishke.cn.sort;

public class ChoiceSort {

    public static int[] sort(int[] array)
    {
        for(int i=0;i < array.length-1;i++)
        {
            int min = i;
            for(int j =i+1 ;j<array.length;j++)
            {
                if(array[j] < array[min])
                {
                   min = j;
                }
            }
            if(i != min)
            {
                int temp  = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
            System.out.print("第"+i+"轮排序结果为：");
            display(array);
        }
        return array;
    }
    public static void display(int array[])
    {
        for(int k=0;k<array.length;k++)
        {
            System.out.print(array[k]+" ");

        }
        System.out.print("\n");
    }

    public static void main(String args[])
    {
        int array[] = {4,2,8,9,5,7,6,1,3};
        System.out.println("未排序数组为：");
        display(array);
        System.out.println("-----------------------------------");
        array = sort(array);
        System.out.println("-----------------------------------");
        System.out.print("排序完成的数组结果为：");
        display(array);
    }
}
