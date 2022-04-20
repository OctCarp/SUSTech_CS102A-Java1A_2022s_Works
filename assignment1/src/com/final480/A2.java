package com.Assignments1.Final;

import java.util.Scanner;

public class A2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);//输入数据
        long id = input.nextLong();//输入8位学生id
        String test = input.next();//输入七天数据
        boolean pcr = true;//判断核酸测试是否通过
        int sum = 0;//Y的总个数
        boolean legal = true;//判断数据是否合规

        if (id < 10000000 || id > 99999999) {
            legal = false;//id不合法
        }
        if (test.length() != 7) {
            legal = false;//String长度不合法
        } else {
            for (int x = 0; x < 7; x++) {
                if (test.charAt(x) == 'Y' || test.charAt(x) == 'N') {
                } else {
                    legal = false;//判断String是否由YN以外的字符组成
                }
            }
            for (int i = 0; i < 7; i++) {
                if (test.charAt(i) == 'Y') {
                    sum += 1;//计算Y的个数
                }
            }
            for (int i = 0; i < 5; i++) {
                if (test.charAt(i) == 'N' && test.charAt(i + 1) == 'N' && test.charAt(i + 2) == 'N') {
                    pcr = false;//连续3天N则核酸不通过
                }
            }
        }
        if (sum < 4) {
            pcr = false;//如果Y小于4天则核酸不通过
        }
        if (!legal) {
            System.out.println("Not valid");//数据不合法
        } else {
            if (pcr) {
                System.out.println("Good, keep it up!");//核酸通过
            } else {
                System.out.println("Has not participated in Nucleic Acid PCR tests as required!");
                //核酸不通过
            }
        }
    }
}
