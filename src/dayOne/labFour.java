package dayOne;

import java.util.Scanner;

public class labFour {

    private static int numPixels = 0;
    private static double estimate = 0;
    private static int estimateWidth = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the desired width: ");
        int width = in.nextInt();

        topAndBottom(width);

        middle(width);

        topAndBottom(width);

        System.out.println("4 * " + numPixels + " / " + width * width + " = " + 4 * numPixels / (double) (width * width));

        System.out.print("Enter the minimum desired error for the estimate of PI: ");
        double error = in.nextDouble();

        estimateWidth = width;
        while(Math.abs(estimate - Math.PI) > error){
            estimateWidth++;
            numPixels = 0;
            estimate = 0;
            middle(estimateWidth);
        }



        System.out.println("An estimate of " + estimate + " was achieved with a width of " + estimateWidth + ".");
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
            if(estimateWidth == 0){
                System.out.print("| ");
            }
            for (int k = 0; k < width; k++) {
                if (Math.sqrt((height * height) + (k * k)) <= width - 0.5) {
                    numPixels++;
                    if(estimateWidth == 0){
                        System.out.print("*");
                    }
                } else if(estimateWidth == 0){
                    System.out.print(" ");
                }
            }
            if(estimateWidth == 0){
                System.out.println(" |");
            }
            height--;
        }

        estimate = 4 * numPixels / (double) (width * width);
    }

}