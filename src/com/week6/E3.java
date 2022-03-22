package com.week6;

import java.util.Scanner;

public class E3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] threeTerms = {0, 1, 1};
        for (int i = 0; i < n; i++) {
            int b = threeTerms[1];
            int c = threeTerms[2];
            threeTerms[2] = b + c;
            threeTerms[1] = c;
            threeTerms[0] = b;
        }
        System.out.println(threeTerms[0]);
    }
}
