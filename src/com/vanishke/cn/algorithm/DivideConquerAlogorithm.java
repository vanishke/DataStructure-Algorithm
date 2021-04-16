package com.vanishke.cn.algorithm;
import static java.lang.System.out;
//分治算法-汉诺塔问题
public class DivideConquerAlogorithm {

    public static void hanioTower(int dish,String from,String temp,String to)
    {
        if(dish ==1)
        {
            out.println("将盘子"+dish+"从塔座"+from+"移动到目标塔座"+to);
        }
        else
        {
            hanioTower(dish-1,from,to,temp);// A为初始塔座，B为目标塔座,C为中间塔座
            out.println("将盘子"+dish+"从塔座"+from +"移动到目标塔座"+to);
            hanioTower(dish-1,temp,from,to);// A为初始塔座，B为目标塔座,C为中间塔座
        }
    }

    public static void main(String args[])
    {
        hanioTower(10,"A","B","C");
    }
}
