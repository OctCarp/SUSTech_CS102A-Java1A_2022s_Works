package com.Assignments1.Final;

import java.util.Scanner;

public class A4Q4 {
    public static void main(String[] args) {
        boolean legal = true;
        String test1 = "";
        String test2 = "";
        String test3 = "";
        String test4 = "";
        Scanner test = new Scanner(System.in);
        String allTest = test.nextLine();
        if (allTest.length() == 31) {
            if (allTest.charAt(7) == ' ' && allTest.charAt(15) == ' ' && allTest.charAt(23) == ' ') {
                test1 = allTest.substring(0,7);
                test2 = allTest.substring(8,15);
                test3 = allTest.substring(16,23);
                test4 = allTest.substring(24,31);
            } else {
                legal = false;
            }
        } else {
            legal = false;
        }

        boolean pcr1 = true;
        boolean pcr2 = true;
        boolean pcr3 = true;
        boolean pcr4 = true;
        int sum1 = 0;
        if (test1.length() != 7) {
            legal = false;
        } else {
            for (int x = 0; x < 7; x++) {
                if (test1.charAt(x) == 'Y' || test1.charAt(x) == 'N') {
                } else {
                    legal = false;
                }
            }
            for (int i = 0; i < 7; i++) {
                if (test1.charAt(i) == 'Y') {
                    sum1 += 1;
                }
            }
            for (int i = 0; i < 5; i++) {
                if (test1.charAt(i) == 'N' && test1.charAt(i + 1) == 'N' && test1.charAt(i + 2) == 'N') {
                    pcr1 = false;
                }
            }
        }
        if (sum1 < 4) {
            pcr1 = false;
        }

        int sum2 = 0;
        if (test2.length() != 7) {
            legal = false;
        } else {
            for (int x = 0; x < 7; x++) {
                if (test2.charAt(x) == 'Y' || test2.charAt(x) == 'N') {
                } else {
                    legal = false;
                }
            }
            for (int i = 0; i < 7; i++) {
                if (test2.charAt(i) == 'Y') {
                    sum2 += 1;
                }
            }
            for (int i = 0; i < 5; i++) {
                if (test2.charAt(i) == 'N' && test2.charAt(i + 1) == 'N' && test2.charAt(i + 2) == 'N') {
                    pcr2 = false;
                }
            }
        }
        if (sum2 < 4) {
            pcr2 = false;
        }

        int sum3 = 0;
        if (test3.length() != 7) {
            legal = false;
        } else {
            for (int x = 0; x < 7; x++) {
                if (test3.charAt(x) == 'Y' || test3.charAt(x) == 'N') {
                } else {
                    legal = false;
                }
            }
            for (int i = 0; i < 7; i++) {
                if (test3.charAt(i) == 'Y') {
                    sum3 += 1;
                }
            }
            for (int i = 0; i < 5; i++) {
                if (test3.charAt(i) == 'N' && test3.charAt(i + 1) == 'N' && test3.charAt(i + 2) == 'N') {
                    pcr3 = false;
                }
            }
        }
        if (sum3 < 4) {
            pcr3 = false;
        }

        int sum4 = 0;
        if (test4.length() != 7) {
            legal = false;
        } else {
            for (int x = 0; x < 7; x++) {
                if (test4.charAt(x) == 'Y' || test4.charAt(x) == 'N') {
                } else {
                    legal = false;
                }
            }
            for (int i = 0; i < 7; i++) {
                if (test4.charAt(i) == 'Y') {
                    sum4 += 1;
                }
            }
            for (int i = 0; i < 5; i++) {
                if (test4.charAt(i) == 'N' && test4.charAt(i + 1) == 'N' && test4.charAt(i + 2) == 'N') {
                    pcr4 = false;
                }
            }
        }
        if (sum4 < 4) {
            pcr4 = false;
        }
        int wrong = 0;
        if (!legal) {
            System.out.println("Not valid");
        } else {
            if (!pcr1) {
                wrong++;
            }
            if (!pcr2) {
                wrong++;
            }
            if (!pcr3) {
                wrong++;
            }
            if (!pcr4) {
                wrong++;
            }
            if (wrong == 0) {
                System.out.println("100");
            }
            if (wrong == 1) {
                System.out.println("90");
            }
            if (wrong == 2) {
                System.out.println("75");
            }
            if (wrong == 3) {
                System.out.println("55");
            }
            if (wrong == 4) {
                System.out.println("30");
            }
        }
        ;

    }
}
