import java.util.Scanner;

public class E7 {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Please input a number to print the Multiplication Table [0 to terminate]:");
            Scanner input = new Scanner(System.in);
            int number = input.nextInt();
            if (number == 0) {
                break;
            } else if (number > 9 || number < 0) {
                System.out.println("Please input a number between [1,9]");
            } else {
                for (int i = 1; i < number + 1; i++) {
                    for (int j = 1; j < i + 1; j++) {
                        System.out.print(j + "*" + i + "=" + (i * j) + "\t");
                    }
                    System.out.print("\n");
                }
            }
        }

    }
}