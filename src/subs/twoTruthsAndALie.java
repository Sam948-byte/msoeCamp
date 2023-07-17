package subs;

import java.util.Scanner;

import static java.lang.System.in;

public class twoTruthsAndALie {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] order = {0, 1, 2};

        String[][] truthsAndLie = {{"I've gone to the same school since elementary school.", "truth"},
        {"I've never been outside the country", "truth"},
        {"I've been to all 50 states.", "lie"}};

        //shuffle order
        for (int i = 0; i < order.length; i++) {
            int randomIndexToSwap = (int) (Math.random() * order.length);
            int temp = order[randomIndexToSwap];
            order[randomIndexToSwap] = order[i];
            order[i] = temp;
        }


        System.out.println("Welcome to Two Truths and a Lie!\n");

        for(int j = 0; j < order.length; j++) {
            System.out.println(truthsAndLie[order[j]][0]);
        }

        System.out.println("\nGuess which statement is the lie:");
        int guess = in.nextInt();


        if (truthsAndLie[order[guess - 1]][1] == "lie") {
            System.out.println("Correct! That one's the lie.");
        } else {
            System.out.println("Incorrect! That one's not the lie.");
        }
    }
}
