package com.Assignments1.Demo;

import java.util.Scanner;

public class Space {
    public static void main(String[] args) {
        while (true) {
            Scanner input = new Scanner(System.in);
            String s1 = input.nextLine();

            System.out.println(s1.replaceAll(" ", "").length());
            System.out.println(s1);

        }
    }
}
