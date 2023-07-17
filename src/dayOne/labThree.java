package dayOne;

import java.util.Scanner;

public class labThree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //list of all brackets, first group is single, second married
        double[][][] filerBrackets = {{{0, 0.10, 1027.5}, {10275, 0.12, 3780}, {41775, 0.22, }, {89075, 0.24}, {170050, 0.32}, {215950, 0.35}, {539900, 0.37}}, {{0, 0.10}, {20550, 0.12}, {83350, 0.22}, {178150, 0.24}, {340100, 0.32}, {431900, 0.35}, {647850, 0.37}}};

        //get data from user
        System.out.println("Welcome to the tax calculator!");
        System.out.println("Please enter your estimated income for 2022: $");
        double income = in.nextDouble();
        System.out.print("Are you a single filer or a married joint filer (enter 0 for single and 1 for married): ");
        int status = in.nextInt();

        //calculate tax
        double tax = 0;
        for(int i = 0; i < filerBrackets[status].length; i++) {
            if(income > filerBrackets[status][i][0] && income < filerBrackets[status][i + 1][0]) {
                tax += (0.01 * filerBrackets[status][i][1]) *
                        (income - filerBrackets[status][i][0]);
            }
        }

        System.out.println("Your estimated tax for 2022 is: $" + tax);
        System.out.println("Your estimated tax rate for 2022 is: " + (tax / income) * 100 + "%");
    }
}