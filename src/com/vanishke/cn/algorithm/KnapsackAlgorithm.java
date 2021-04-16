package com.vanishke.cn.algorithm;
import static java.lang.System.out;
//动态规划-01背包问题
public class KnapsackAlgorithm {
    //商品体积 2,3,4,5
    static int w[] = {0,2,3,4,5};
    //商品价值 3,4,5,6
    static int v[] = {0,3,4,5,6};
    //背包容量
    static int capacity = 8;
    //动态规划表
    static int worth[][] = new int[5][9];
    //最优解记录
    static int items[] = new int[5];

    //初始化动态规划表
    public static void dpTableInit(int w[],int v[],int capacity,int worth[][])
    {
        for(int i=1;i<=4;i++)
        {
            for(int j=1;j<=8;j++)
            {
                if(j< w[i])
                {
                    worth[i][j] = worth[i-1][j];
                }
                else
                {
                    worth[i][j] = Math.max(worth[i-1][j],worth[i-1][j-w[i]]+v[i]);
                }
            }
        }
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<9;j++)
            {
                out.print(worth[i][j]+" ");
            }
            out.println();
        }
    }

    //回溯最优解
    public static void backTracing(int i,int j)
    {
        if(i>0)
        {
             if(worth[i][j] == worth[i-1][j])
             {
                  items[i] = 0;
                  backTracing(i-1,j);
             }
             else if(j-w[i]>=0 && worth[i][j] == worth[i-1][j-w[i]]+v[i])
             {
                  items[i] = i;
                  backTracing(i-1,j-w[i]);
             }
        }
    }

    //输出选中的商品
    public static void display(int items[])
    {
        out.println("选中了以下商品");
        for(int k=0;k<items.length;k++)
        {
            if(items[k] != 0)
            {
                out.print(items[k]+" ");
            }
        }
    }

    public static void main(String args[])
    {
        //初始化动态规划表
        dpTableInit(w,v,capacity,worth);
        //回溯最优解
        backTracing(w.length-1,capacity);
        //输出最优解
        display(items);
    }
}
