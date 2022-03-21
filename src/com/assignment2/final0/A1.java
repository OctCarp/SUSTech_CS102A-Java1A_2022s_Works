package com.assignment2.final0;

import java.util.Scanner;

public class A1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int terms = input.nextInt();
        double[] coefficient = new double[terms];
        for (int i = 0; i < terms; i++) {
            coefficient[i] = input.nextDouble();
        }
        double lower = input.nextDouble();
        double upper = input.nextDouble();
        changeCoefficient(coefficient);
        double sum=substitute(upper,lower,coefficient);
        System.out.printf("%.7f",sum);
    }

    public static void changeCoefficient(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] /= (i + 1);
        }
    }

    public static double substitute(double upper, double lower, double[] coefficient) {
        double sum = 0;
        for (int i = 0; i < coefficient.length; i++) {
            double upperPower = Math.pow(upper, i + 1);
            double lowerPower = Math.pow(lower, i + 1);
            double coe = coefficient[i];
            double term = (upperPower - lowerPower) * coe;
            sum += term;
        }
        return sum;
    }
}

