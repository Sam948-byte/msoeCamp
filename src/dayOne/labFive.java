package dayOne;

import java.util.Scanner;

public class labFive {
    private static double givenAmount = 0;
    private static int weeks = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        randomize();

        System.out.println("Which option do you want? (0 or 1)");
        int choice = in.nextInt();

        for(int j = 1; j <= weeks; j++){

            System.out.println("Week " + j + "  |  Linear: $" + linear(j) + "  |  Exponential: $" + exponential(j));

            if(linear(j) < exponential(j) && choice == 0){
                System.out.println("Your uncle died after " + weeks + " weeks.  Sadly, you missed out on $" + exponential(weeks) + " by choosing the linear option.");
                break;
            } else if(linear(j) < exponential(j)){
                System.out.println("Your uncle died after " + weeks + " weeks.  You lucked into $" + exponential(weeks) + " by choosing the exponential option.");
                break;
            }

        }

        if(linear(weeks) > exponential(weeks) && choice == 0) {
            System.out.println("Your uncle died after " + weeks + " weeks.  You lucked into $" + linear(weeks) + " by choosing the linear option.");
        } else if(linear(weeks) > exponential(weeks)){
            System.out.println("Your uncle died after " + weeks + " weeks.  Sadly, you missed out on $" + linear(weeks) + " by choosing the exponential option.");
        }
    }

    public static void randomize(){
        givenAmount = Math.round(Math.random() * 5000);
        weeks = (int)(Math.random() * 39 + 1);
    }

    public static double linear(int weeks){
        return givenAmount * (weeks);
    }

    public static double exponential(int weeks){

            return 0.01 * (Math.pow(2, weeks));

    }
}
