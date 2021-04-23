package com.vanishke.cn.sort;

import java.util.Arrays;
import static java.lang.System.out;
//希尔排序
public class ShellKnuthSort {

    public static void sort(int array[])
    {
        out.println("原数组为"+Arrays.toString(array));
        int step = 1 ;
        int len = array.length;
        while(step <= len/3)
        {
            //步长间隔3n+1
            step = step*3 + 1;
            out.println("step:"+step);
        }
        while(step > 0){
            //分别对每个增量间隔进行排序
            for(int i = step ; i < len ; i++)
            {
                //记录需要进行交换的数据
                int temp = array[i];
                int j = i;
                //比较对应3n+1间隔的数据，如果满足条件，则交换
                while(j > step-1 && temp <= array[j-step])
                {
                    array[j] = array[j-step];
                    j = j-step;
                }
                array[j] = temp;
            }
            out.println("间隔为"+step+"的排序结果为"+Arrays.toString(array));
            step =(step-1)/3;
        }
        out.println("最终排序："+Arrays.toString(array));
    }

    public static void main(String args[])
    {
        int a[] = {3,21,24,9,15,23,6,1,5,8};
        sort(a);
    }

}
