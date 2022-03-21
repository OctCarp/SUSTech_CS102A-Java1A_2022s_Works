package com.assignment2.demos;

import java.util.Scanner;

public class A1Note {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int terms = input.nextInt();//输入项数
        double[] coefficient = new double[terms];//建立数组接受系数ai的值
        for (int i = 0; i < terms; i++) {
            coefficient[i] = input.nextDouble();
        }//输入系数，给数组赋值
        double lower = input.nextDouble();//输入积分下界
        double upper = input.nextDouble();//输入积分上界
        changeCoefficient(coefficient);//调用方法改变积分后的系数
        double sum=substitute(upper,lower,coefficient);//通过代入方法，用上下限和系数数组作参数计算
        System.out.printf("%.7f",sum);
    }

    public static void changeCoefficient(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] /= (i + 1);//改变系数ai，积分后系数变为ai/(i+1)
        }
    }

    public static double substitute(double upper, double lower, double[] coefficient) {
        double sum = 0;
        for (int i = 0; i < coefficient.length; i++) {
            double upperPower = Math.pow(upper, i + 1);//积分后上界第n项为x^n，x^n的值
            double lowerPower = Math.pow(lower, i + 1);//下界同上
            double coe = coefficient[i];//提取对应项的系数
            double term = (upperPower - lowerPower) * coe;//上下界对应的x^n作差后再乘以系数
            sum += term;//加和
        }
        return sum;
    }
}
