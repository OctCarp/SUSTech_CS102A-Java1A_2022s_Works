package com.assignment3.third;

public class Demo {
    public static void main(String[] args) {
        Player p1=new Player(new Mail("xxx"),"123");
        System.out.println(p1.checkIdentity(new Mail("xxx"),"123"));
    }
}
