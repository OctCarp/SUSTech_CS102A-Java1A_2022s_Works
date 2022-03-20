package com.Assignments1.Final;

import java.util.Scanner;

public class A3 {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            String str1 = input.nextLine();
            String str2 = input.nextLine();
            int startTime = DataManager.transTime(str1);
            int endTime = DataManager.transTime(str2);
            input.close();
            if (startTime == -1 || endTime == -1) {
                System.out.println("Not valid");
            } else {
                DataManager stu = new DataManager(startTime, endTime);
                stu.Output();
            }
        } catch (Exception e) {
            System.out.println("Not valid");
        }
    }
}

class DataManager {
    final private int duringTime; //must in seconds.
    public DataManager(int startTime, int endTime) {
        this.duringTime = endTime - startTime;
    }

    public static int transTime(String input) {
        String[] split = input.split(" ");
        if (split.length > 3) return -1;
        int hh = Integer.parseInt(split[0]);
        if (hh < 0 || hh > 23) return -1;
        int mm = Integer.parseInt(split[1]);
        if (mm < 0 || mm > 59) return -1;
        int ss = Integer.parseInt(split[2]);
        if (ss < 0 || ss > 59) return -1;
        return hh * 3600 + mm * 60 + ss;
    }

    public void Output() {
        if (duringTime < 0) {
            System.out.println("Not valid");
        } else if (duringTime == 0) {
            System.out.println("0s");
        } else {
            System.out.println(OutputFormat());
        }
    }

    public String OutputFormat() {
        int hh = duringTime / 3600;
        int mm = (duringTime % 3600) / 60;
        int ss = (duringTime % 3600) % 60;
        String[] str = new String[3];
        if (hh != 0) str[0] = hh + "h";
        else str[0] = "";
        if (mm != 0) str[1] = mm + "m";
        else str[1] = "";
        if (ss != 0) str[2] = ss + "s";
        else str[2] = "";
        return str[0] + str[1] + str[2];
    }
}