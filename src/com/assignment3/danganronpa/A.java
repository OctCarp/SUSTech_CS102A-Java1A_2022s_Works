package com.assignment3.danganronpa;

import java.io.*;
import java.util.*;

public class A {
}

class QReader {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer tokenizer = new StringTokenizer("");

    private String innerNextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String nextLine = innerNextLine();
            if (nextLine == null) {
                return false;
            }
            tokenizer = new StringTokenizer(nextLine);
        }
        return true;
    }

    public String nextLine() {
        tokenizer = new StringTokenizer("");
        return innerNextLine();
    }

    public String next() {
        hasNext();
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}

class QWriter implements Closeable {
    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public void print(Object object) {
        try {
            writer.write(object.toString());
        } catch (IOException e) {
            return;
        }
    }

    public void println(Object object) {
        try {
            writer.write(object.toString());
            writer.write("\n");
        } catch (IOException e) {
            return;
        }
    }

    @Override
    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            return;
        }
    }
}

class MinHeap {
    private static final int MAXSIZE = 10010;
    private int[] a = new int[MAXSIZE];

    private void swap(int x, int y) {
        a[x] = a[x] ^ a[y];
        a[y] = a[y] ^ a[x];
        a[x] = a[x] ^ a[y];
    }

    private void up() {
        int p = a[0];
        while (p > 1) {
            if (a[p] < a[p / 2]) {
                swap(p, p / 2);
                p = p / 2;
            } else
                break;
        }
    }

    public void push(int k) {
        a[++a[0]] = k;
        up();
    }

    public void pop() {
        int s = 2, t = 1;
        a[1] = a[a[0]--];
        while (s <= a[0]) {
            if (s <= a[0] - 1 && a[s + 1] < a[s])
                ++s;
            if (a[s] < a[t]) {
                swap(s, t);
                t = s;
                s *= 2;
            } else
                break;
        }
    }

    public int getMin() {
        return a[1];
    }

    public int size() {
        return a[0];
    }
}

class MaxHeap {
    private static final int MAXSIZE = 10010;
    private int[] a = new int[MAXSIZE];

    private void swap(int x, int y) {
        a[x] = a[x] ^ a[y];
        a[y] = a[y] ^ a[x];
        a[x] = a[x] ^ a[y];
    }

    private void up() {
        int p = a[0];
        while (p > 1) {
            if (a[p] > a[p / 2]) {
                swap(p, p / 2);
                p = p / 2;
            } else
                break;
        }
    }

    public void push(int k) {
        a[++a[0]] = k;
        up();
    }

    public void pop() {
        int s = 2, t = 1;
        a[1] = a[a[0]--];
        while (s <= a[0]) {
            if (s <= a[0] - 1 && a[s + 1] > a[s])
                ++s;
            if (a[s] > a[t]) {
                swap(s, t);
                t = s;
                s *= 2;
            } else
                break;
        }
    }

    public int getMax() {
        return a[1];
    }

    public int size() {
        return a[0];
    }
}