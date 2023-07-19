package dayOne;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.Scanner;


public class labFour extends Application {

    private static int numPixels = 0;
    private static double estimate = 0;
    private static int estimateWidth = 0;

    public static void main(String[] args) {
        Application.launch(args);
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
        while (Math.abs(estimate - Math.PI) > error) {
            estimateWidth += 3;
            numPixels = 0;
            estimate = 0;
            estimateCalc(estimateWidth);
            System.out.print("An estimate of " + estimate + " was calculated with a width of " + estimateWidth + "\r");
        }
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

        estimate = 4 * numPixels / (double) (width * width);
    }

    public static void estimateCalc(int width) {
        int height = width - 1;
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

    @Override
    public void start(Stage stage) throws Exception {
        Label display = new Label("Hello, World!");
        Scene scene = new Scene(display);
        stage.setScene(scene);
        stage.show();
    }
}
