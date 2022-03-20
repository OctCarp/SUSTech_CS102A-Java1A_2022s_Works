package week5;

import java.util.Scanner;

public class E1 {
    public static void main(String[] args) {
        double[] score=new double[10];
        Scanner input=new Scanner(System.in);
        System.out.println("Please input 10 scores of these students:");
        for(int i=0;i<score.length;i++){
            score[i]=input.nextDouble();
        }
        double max=getMax(score);
        double min=getMin(score);
        double sum=0;
        for(int i=0;i<score.length;i++){
            sum+=score[i];
        }
        double average=(sum-max-min)/8;
        System.out.printf("Average score is "+"%5.2f",average);
        input.close();
    }
    public static double getMax(double[] arr){
        double tem=arr[0];
        for(int i=1;i< arr.length;i++){
            if(arr[i]>tem){tem=arr[i];}
        }
        return tem;
    }
    public static double getMin(double[] arr){
        double tem=arr[0];
        for(int i=1;i< arr.length;i++){
            if(arr[i]<tem){tem=arr[i];}
        }
        return tem;
    }
}
