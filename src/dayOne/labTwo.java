package dayOne;

import java.util.Scanner;

public class labTwo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //negation problem
        System.out.print("1. Negate \n Enter an integer value:");
        int negate = in.nextInt();
        System.out.println("Result: " + negate * -1);

        //penny problem
        System.out.print("2. How Many Pennies \n Enter a dollar amount:");
        double pennies = in.nextDouble();
        System.out.println("Result: " + Math.floor(pennies * 100));

        //last half problem
        System.out.print("3. Last Half \n Enter a word:");
        String word = in.next();
        System.out.println("Result: " + word.substring(word.length() / 2));

        // Make Initialization Problem
        System.out.print("4. Make Initialization \n Enter a name:");
        String name = in.next();
        System.out.print("Enter an integer value:");
        int make = in.nextInt();
        System.out.println("Result: " + name + " = " + make);

        //Fraction Problem
        System.out.print("5. Fraction \n Enter a numerator:");
        double numerator = in.nextDouble();
        System.out.print("Enter a denominator:");
        double denominator = in.nextDouble();
        System.out.println("Result: " + numerator / denominator);
    }
}
