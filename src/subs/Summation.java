package subs;

public class Summation {
    public static int main(String[] args) {
        //our sum starts at 0
        int sum = 0;

        for (int i = 0; i < args.length; ++i) {
            //add each argument to the sum, checking to see if it's a valid argument
            try{
                sum += Integer.parseInt(args[i]);
//                System.out.println("Argument " + i + ": " + args[i]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid argument: " + args[i]);
                System.exit(1);
            }

        }

        //print the
        return sum;
    }
}
