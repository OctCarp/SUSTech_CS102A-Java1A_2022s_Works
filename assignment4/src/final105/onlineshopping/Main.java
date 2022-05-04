package final105.onlineshopping;

import final105.onlineshopping.BigBinary;

public class Main {
    public static void main(String[] args) {
        int[] b1 = {1,1,0,1,1,1,1,1,1,0,0,1,1,0,0};
        int[] b2 = {0,1};

        BigBinary bigBinary1 = new BigBinary(b1, false);
        BigBinary bigBinary2 = new BigBinary(b2, false);

        System.out.println(bigBinary1);
        System.out.println(bigBinary2);
        System.out.println(bigBinary1.add(bigBinary2));
        System.out.println(bigBinary1);
        System.out.println(bigBinary2);
    }
}







