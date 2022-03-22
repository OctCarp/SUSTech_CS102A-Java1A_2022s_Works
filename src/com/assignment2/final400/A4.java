package com.assignment2.final400;

import java.util.Scanner;

public class A4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(3 * n + 3);
        int x = 1;
        System.out.printf("-1 0\n" + "0 -1\n" + "-1 -1\n");
        for (; x <= n; x++) {
            System.out.printf("%d %d\n", x, x);
            System.out.printf("%d %d\n", x - 1, x);
            System.out.printf("%d %d\n", x, x - 1);
        }
    }
}