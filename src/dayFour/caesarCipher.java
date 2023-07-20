package dayFour;

import java.util.Scanner;
public class caesarCipher {
    private static String output = "";
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the Caesar Cipher program!");
        System.out.print("Would you like to encrypt or decrypt a message(0 to encrypt, 1 to decrypt)?");
        int choice = in.nextInt();

        if(choice == 0){
            System.out.print("Enter a string to encrypt: ");
            String input = in.next();
            System.out.print("Enter a number to shift by: ");
            int shift = in.nextInt();
            encrypt(input, shift);
        } else if(choice == 1){
            System.out.println("Enter a string to decrypt: ");
            String input = in.nextLine();
            decrypt(input);
        } else {
            System.out.println("Invalid choice.");
        }

        System.out.println(output);

    }

    public static void encrypt(String input, int shift){
        input.toUpperCase();
        for(int i = 0; i < input.length(); i++){
        char letter = input.charAt(0);
        int ascii = (int) letter - 65;
        int newAscii = (ascii + shift) % 26;
        output += (char) (newAscii + 65);
        }
    }

    public static void decrypt(String input){

    }
}
