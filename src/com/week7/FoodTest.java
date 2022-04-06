package com.week7;

import java.util.ArrayList;

public class FoodTest {
    public static void main(String[] args) {
        ArrayList<Food> menu=new ArrayList<>();
        Food pizza1=new Food();
        pizza1.setId(1);
        pizza1.setName("pizza");
        pizza1.setType("Seafood");
        pizza1.setSize(11);
        pizza1.setPrice(12);
        Food pizza2=new Food();
        pizza2.setId(2);
        pizza2.setName("pizza");
        pizza2.setType("Beef");
        pizza2.setSize(9);
        pizza2.setPrice(10);
        Food firedRice=new Food();
        firedRice.setId(3);
        firedRice.setName("fired rice");
        firedRice.setType("Seafood");
        firedRice.setSize(5);
        firedRice.setPrice(12);
        Food noodles=new Food();
        noodles.setId(4);
        noodles.setName("noodles");
        noodles.setType("Beef");
        noodles.setSize(6);
        noodles.setPrice(10);
        menu.add(pizza1);
        menu.add(pizza2);
        menu.add(firedRice);
        menu.add(noodles);
        System.out.println("---------welcome, this is Start of the Menu---------");
        pizza1.getMenu();
        pizza2.getMenu();
        firedRice.getMenu();
        noodles.getMenu();
        System.out.println("----------welcome, this is End of the Menu----------");
    }
}
