//友人z受VMware图标启发，灵感乍现
//我想称为无限python爬楼梯形
package com.assignment2.demos;

import java.util.Scanner;

public class A4Note {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();//n个python形
        //从(1,1)开始，从右上角的方块向左向下，作一个反L形，到(n,n)结束
        // 则(0,0)到(n-1,n-1)的n个块都是符合条件的，(0,0)左下方再包裹一个正L型即可
        System.out.println(3 * n + 3);//小学数学计算总数
        int x = 1;//(0,0)要排除在外，从(1,1)开始输出
        System.out.printf("-1 0\n" + "0 -1\n" + "-1 -1\n");//包裹(0,0)的正L形
        for (; x <= n; x++) {
            System.out.printf("%d %d\n", x, x);//斜线上的中心块
            System.out.printf("%d %d\n", x - 1, x);//向左
            System.out.printf("%d %d\n", x, x - 1);//向下
        }
    }
}
