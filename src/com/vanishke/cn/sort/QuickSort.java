package com.vanishke.cn.sort;

import static java.lang.System.out;
//快速排序
public class QuickSort {

    public static int count = 1;
    //打印排序后的数组元素
    public static void display(int a[] , int count)
    {
        if(count != 0)
        {
            out.println("第"+count+"次排序结果");
            for(int i=0;i<a.length;i++)
            {
                out.print(a[i]+ " ");
            }
            out.println();
        }
    }
    //计算交换排序之后轴值所在位置
    public static int partition(int []array,int low,int high)
    {
        //将第一个数组元素作为轴值
        int key = array[low];
        //前后双向扫描
        while(low < high)
        {
            //扫描从右往左优先，找到第一个小于轴值的元素
            while(low<high&&array[high] >= key)
            {
                //数组下标往左移动
                high--;
            }
            //当前扫描到小于轴值的元素，发生交换
            array[low] = array[high];
            //从左往右扫描,找到第一个大于轴值的元素
            while(low<high&&array[low] <= key )
            {
                //数组下标往右移动
                low++;
            }
            //当前扫描到大于轴值的元素，发生交换
            array[high] = array[low];
        }
        //此时左右扫描的下标重合，low=high
        array[high] = key;
        display(array,count++);
        return high;
    }
    //快排，采用递归方式
    public static void quickSort(int a[],int low,int high)
    {
        if(low>=high)
        {
            return ;
        }
        //找到轴值所在的位置
        int index = partition(a,low,high);
        //左边待排序列有序
        quickSort(a,low,index-1);
        //右边待排序列有序
        quickSort(a,index+1,high);
    }

    //生成随机数组
    public static int[]  gennerateArray(int len,int max){
        int[] arr=new int[len];
        for(int i=0;i<arr.length;i++){
            //Math.random()返回[0.0,1.0)区间的double类型的随机数据数据
            //强制转换为int类型数组
            arr[i]=(int)(Math.random()*max);
        }
        return arr;
    }


    public static void main(String args[])
    {
        //随机数组生成
        int [] a = gennerateArray(12,100);
        long begin = System.currentTimeMillis();
        quickSort(a,0,a.length-1);
        out.println("耗时："+(System.currentTimeMillis() - begin)+"毫秒");
    }
}
