package dayThree;

public class birthdayProblem {
    public static void main(String[] args) {
        int count = 0;
        int[] birthdays = new int[Integer.parseInt(args[1])];
        for(int i = 0; i < Integer.parseInt(args[0]); i++){
            for(int j = 0; j < Integer.parseInt(args[1]); j++){
                birthdays[j] = (int)(Math.random() * 365);
            }
            for(int k = 0; k < birthdays.length; k++){
                for(int l = k + 1; l < birthdays.length; l++){
                    if(birthdays[k] == birthdays[l]){
                        count++;
                        break;
                    }
                }
            }
            System.out.println(i + "/" + Integer.parseInt(args[0]));
        }
        System.out.println("The probability of two people having the same birthday is " + (double)count / Integer.parseInt(args[0]));


    }
}
