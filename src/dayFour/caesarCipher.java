package dayFour;

import java.util.Scanner;

public class caesarCipher {
    private static String output = "";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the Caesar Cipher program!");
        System.out.print("Would you like to encrypt or decrypt a message(0 to encrypt, 1 to decrypt)?");
        int choice = in.nextInt();

        if (choice == 0) {
            System.out.print("Enter a string to encrypt: ");
            String input = in.next();
            System.out.print("Enter a number to shift by: ");
            int encryptShift = in.nextInt();
            encrypt(input, encryptShift);
        } else if (choice == 1) {
            System.out.print("Enter a string to decrypt: ");
            String input = in.next();
            System.out.print("Enter a number to shift by(0 to see all possibilities): ");
            int decryptShift = in.nextInt();
            decrypt(input, decryptShift);
        } else {
            System.out.println("Invalid choice.");
        }

        System.out.println(output);

    }

    @SuppressWarnings("StringConcatenationInLoop")
    public static void encrypt(String input, int shift) {
        shift = shift % 26;
        input = input.toUpperCase();
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            int ascii = (int) letter - 65;
            int newAscii = (ascii + shift) % 26;
            output += (char) (newAscii + 65);
        }
    }

    @SuppressWarnings("StringConcatenationInLoop")
    public static void decrypt(String input, int shift) {
        input = input.toUpperCase();
        if (shift == 0) {
            decryptAll(input);
        } else {
            shift = shift % 26;
            for (int i = 0; i < input.length(); i++) {
                char letter = input.charAt(i);
                int ascii = (int) letter - 65;
                int newAscii = (ascii - shift) % 26;
                output += (char) newAscii + 65;
            }
        }
    }

    @SuppressWarnings("StringConcatenationInLoop")
    public static void decryptAll(String input){
        for (int j = 0; j < 26; j++) {
            for (int i = 0; i < input.length(); i++) {
                char letter = input.charAt(i);
                int ascii = (int) letter - 65;
                int newAscii = (ascii + j) % 26;
                if(newAscii < 0)
                    output += (char) (newAscii + 26 + 65);
                else {
                    output += (char) (newAscii + 65);
                }
            }
            output += "\n";
        }
    }
}
