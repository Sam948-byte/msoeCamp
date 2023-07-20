package dayOne;

import java.util.Scanner;

public class labFour {

    private static long numPixels = 0;
    private static double estimate = 0;
    private static long estimateWidth = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the desired width: ");
        long width = in.nextLong();
        if (width < 10000) {
            topAndBottom(width);

            middle(width);

            topAndBottom(width);
        } else {
            estimateCalc(width);
        }
        System.out.println("4 * " + numPixels + " / " + width * width + " = " + 4 * numPixels / (double) (width * width));

        System.out.print("Enter the minimum desired error for the estimate of PI: ");
        double error = in.nextDouble();

        System.out.print("Enter the desired increment: ");
        int increment = Integer.parseInt(in.next());

        if (increment <= 0) {
            increment = 1;
        }

        estimateWidth = width;
        while (Math.abs(estimate - Math.PI) > error) {
            estimateWidth += increment;
            numPixels = 0;
            estimate = 0;
            estimateCalc(estimateWidth);
            System.out.print("An estimate of " + estimate + " was computed with a width of " + estimateWidth + "\r");
        }


        System.out.println("An estimate of " + estimate + " was achieved with a width of " + estimateWidth + ".");
    }

    public static void topAndBottom(long width) {
        System.out.print("+");
        for (int i = 0; i < width + 2; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }

    public static void middle(long width) {
        long height = width - 1;
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

        estimate = 4 * numPixels / (double) (width * width);
    }

    public static void estimateCalc(long width) {
        long height = width - 1;
        for (int j = 0; j < width; j++) {

            for (int k = 0; k < width; k++) {
                if (Math.sqrt((height * height) + (k * k)) <= width - 0.5) {
                    numPixels++;
                }
            }
            height--;
        }

        estimate = 4 * numPixels / (double) (width * width);
    }
}
