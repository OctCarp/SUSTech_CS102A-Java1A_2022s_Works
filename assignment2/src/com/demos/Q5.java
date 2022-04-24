package com.demos;

import java.util.ArrayList;
import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long r = input.nextLong();
        ArrayList<Long> primes = prime(r);
        ArrayList<Long> compute = new ArrayList<>();
        long product = 1;
        if (primes.size() == 0) {
            product = 1;
        } else if (primes.size() == 1) {
            product = 3;
        } else {
            compute.add(1L);
            for (int i = 1; i < primes.size(); i++) {
                int size = compute.size();
                long b = primes.get(i);
                long a = primes.get(i - 1);
                if (b == a) {
                    long x = compute.get(size - 1);
                    compute.set(size - 1, x + 1);
                } else {
                    compute.add(1L);
                }
            }
            for (int i = 0; i < compute.size(); i++) {
                product *= (compute.get(i) * 2 + 1);
            }
        }
        if (r == 0) {
            System.out.println(1);
        } else if (r == 1) {
            System.out.println(4);
        } else {
            System.out.println(4 * product);
        }
    }

    public static ArrayList<Long> prime(long a) {
        ArrayList<Long> prime = new ArrayList<Long>();
        long temp = a;
        for (long i = 2; i <= temp; i++) {
            if (temp % i == 0 && temp != i) {

                if (i % 4 == 1) {
                    prime.add(i);
                }
                temp /= i;
                i--;
            }
            if (temp == i && temp != a && temp != 2) {
                prime.add(i);
            }
        }
        if (temp == a && a % 4 == 1) {
            prime.add(a);
        }
        return prime;
    }

}
