package com.week6;

import java.util.Scanner;

public class E3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] termsThree = {0, 1, 1};
        for (int i = 0; i < n; i++) {
            int b = termsThree[1];
            int c = termsThree[2];
            termsThree[2] = b + c;
            termsThree[1] = c;
            termsThree[0] = b;
        }
        System.out.println(termsThree[0]);
    }
}
