package com.Assignments1.Demo;

import java.util.Scanner;

public class Q22 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long id = input.nextLong();
        String test = input.next();
        boolean pcr = true;
        int sum = 0;

        for (int i = 0; i < 7; i++) {
            if (test.charAt(i) == 'Y') {
                sum += 1;
            }
        }
        for (int i = 0; i < 5; i++) {
            if (test.charAt(i) == 'N' && test.charAt(i + 1) == 'N' && test.charAt(i + 2) == 'N') {
                pcr = false;
            }
        }
        if (sum < 4) {
            pcr = false;
        }

        if (pcr) {
            System.out.println("Good, keep it up!");
        } else {
            System.out.println("Has not participated in Nucleic Acid PCR tests as required!");
        }

    }
}
