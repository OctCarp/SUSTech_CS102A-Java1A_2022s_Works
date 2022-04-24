package com.Assignments1.Final;

import java.util.Scanner;

public class A1Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long id = input.nextLong();
        float temperature = input.nextFloat();
        char test = input.next().charAt(0);
        boolean a = (id > 9999999 & id < 1000000000);
        boolean b = (temperature > 35.0 & temperature < 45.0);
        boolean c = (test =='Y' | test=='N');
        if (a && b && c) {
            System.out.println("Submit successfully");
        }
        if (a && b && !c) {
            System.out.println("Error in Nucleic Acid PCR test");
        }
        if (a && !b && c) {
            System.out.println("Error in Temperature");
        }
        if (!a && b && c){
            System.out.println("Error in Student ID");
        }
        if(!a&&!b&&c){
            System.out.println("Error in Student ID and Temperature");
        }
        if(!a&&b&&!c){
            System.out.println("Error in Student ID and Nucleic Acid PCR test");
        }
        if(a&&!b&&!c){
            System.out.println("Error in Temperature and Nucleic Acid PCR test");
        }
        if(!a&&!b&&!c){
            System.out.println("Error in Student ID and Temperature and Nucleic Acid PCR test");
        }
    }
}
