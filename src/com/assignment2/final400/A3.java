package com.assignment2.final400;

import java.util.Scanner;

public class A3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int[] pigeons = new int[number];
        int[] seats = new int[number];
        for (int i = 0; i < number; i++) {
            pigeons[i] = input.nextInt();
        }
        for (int i = 0; i < number; i++) {
            seats[i] = input.nextInt();
        }
        sort(pigeons);
        sort(seats);
        int[] distance = new int[number];
        for (int i = 0; i < number; i++) {
            distance[i] = Math.abs(pigeons[i] - seats[i]);
        }
        sort(distance);
        System.out.println(distance[number - 1]);
    }

    public static void sort(int[] chaos) {
        for (int i = 0; i < chaos.length; i++) {
            for (int j = i + 1; j < chaos.length; j++) {
                int former = chaos[i];
                int now = chaos[j];
                if (former > now) {
                    int temp = former;
                    chaos[i] = now;
                    chaos[j] = temp;
                }

            }
        }
    }
}
