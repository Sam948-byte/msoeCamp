package dayOne;

import java.util.Scanner;

public class labThree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //list of all brackets, first group is single, second married
        double[][][] filerBrackets = {{{0, 0.10, 1027.5}, {10275, 0.12, 3780}, {41775, 0.22, 10406}, {89075, 0.24, 19434}, {170050, 0.32, 14688}, {215950, 0.35, 113382.5}, {539900, 0.37}},
                {{0, 0.10, 2055}, {20550, 0.12, 13816}, {83350, 0.22, 20856}, {178150, 0.24, 38868}, {340100, 0.32, 29376}, {431900, 0.35, 75582.5}, {647850, 0.3766480}}};

        //get data from user
        System.out.println("Welcome to the tax calculator!");
        System.out.print("Please enter your estimated income for 2022: $");
        double income = in.nextDouble();
        System.out.print("Are you a single filer or a married joint filer (enter 0 for single and 1 for married): ");
        int status = in.nextInt();

        //calculate tax
        double tax = 0;
        int bracket = 0;
        for(int i = 0; i < filerBrackets[status].length; i++) {
           if(income > filerBrackets[status][i][0]){
               bracket = i;
           }
        }

        for(int j = 0; j < bracket; j++) {
            tax += filerBrackets[status][j][2];
        }
        tax += (income - filerBrackets[status][bracket][0]) * filerBrackets[status][bracket][1];

        System.out.println("Your estimated tax for 2022 is: $" + tax);
        System.out.println("Your estimated tax rate for 2022 is: " + Math.floor((tax / income) * 100) + "%");
    }
}