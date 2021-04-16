package com.vanishke.cn.sort;
import static java.lang.System.out;
//归并排序
public class MergeSort {

    public static int[] sort(int a[],int b[])
    {
        int c[] = new int[a.length+b.length];
        int aNum = 0,bNum = 0,cNum = 0;
        while(aNum < a.length && bNum < b.length)
        {
            if(a[aNum] <= b[bNum])
            {
                c[cNum++] = a[aNum++];
            }
            else
            {
                c[cNum++] = b[bNum++];
            }
        }
        while(aNum == a.length && bNum < b.length)
        {
            c[cNum++] = b[bNum++];
        }
        while(bNum == b.length && aNum < a.length)
        {
            c[cNum++] = a[aNum++];
        }
        return c;
    }

    public static void display(int s[])
    {
        out.print("遍历数组：");
        for(int k = 0;k < s.length;k++)
        {
            out.print(s[k]+" ");
        }
    }

    public static void main(String args[])
    {
        int a[] = {1,3,6,8,13} ,b[] ={2,4,6,8,13,18};
        display(sort(a,b));


    }
}
