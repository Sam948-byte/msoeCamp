package dayOne;

import java.util.Scanner;

public class labFour {

    private static int numPixels;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the desired width: ");
        int width = in.nextInt();

        topAndBottom(width);

        middle(width);

        topAndBottom(width);

        System.out.println("\nNumber of pixels: " + numPixels);
    }

    public static void topAndBottom(int width) {
        System.out.print("+");
        for (int i = 0; i < width + 2; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }

    public static void middle(int width) {
        int height = width - 1;
        for (int j = 0; j < width; j++) {
            System.out.print("| ");
            for (int k = 0; k < width; k++) {
                if (Math.sqrt((height * height) + (k * k)) <= width - 0.5) {
                    numPixels++;
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println(" |");
            height--;
        }
    }
}
