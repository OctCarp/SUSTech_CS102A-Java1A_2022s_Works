package com.Assignments1.Demo;

import java.util.Scanner;

public class Q33 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String time1 = input.nextLine();
        String time2 = input.nextLine();
        String[] split1 = time1.split(" ");
        String[] split2 = time2.split(" ");

        int h1 = input.nextInt();
        int m1 = input.nextInt();
        int s1 = input.nextInt();
        int h2 = input.nextInt();
        int m2 = input.nextInt();
        int s2 = input.nextInt();
        boolean legal = (m1 < 60 && m2 < 60 && s1 < 60 && s2 < 60 && h1 < 24 && h2 < 24 && m1 >= 0 && m2 >= 0 && s1 >= 0 && s2 >= 0 && h1 >= 0 && h2 >= 0);
        int h;
        int m;
        int s;
        if (legal) {
            if (s2 < s1) {
                s = s2 + 60 - s1;
                m2 -= 1;
            } else {
                s = s2 - s1;
            }
            if (m2 < m1) {
                m = m2 + 60 - s1;
                h2 -= 1;
            } else {
                m = m2 - m1;
            }
            if (h2 < h1) {
                h = h2 + 24 - s1;
            } else {
                h = h2 - h1;
            }
            boolean a = h != 0;
            boolean b = m != 0;
            boolean c = s != 0;

            if(h==3&&m==0&&s==0){
                System.out.println("3h");
            }
            else if (h >= 3) {
                System.out.println("Not valid");
            } else if (a && b && c) {
                System.out.println(h + "h" + m + "m" + s + "s");
            } else if (!a && b && c) {
                System.out.println(m + "m" + s + "s");
            } else if (a && !b && c) {
                System.out.println(h + "h" + s + "s");
            } else if (a && b && !c) {
                System.out.println(h + "h" + m + "m");
            } else if (!a && !b && c) {
                System.out.println(s + "s");
            } else if (!a && b && !c) {
                System.out.println(m + "m");
            } else if (a && !b && !c) {
                System.out.println(h + "h");
            } else if(!a&&!b&&!c){
                System.out.println("0s");
            }
        } else {
            System.out.println("Not valid");
        }
    }
}
