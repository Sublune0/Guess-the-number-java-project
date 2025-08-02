/*
* Assignment: Project 2A 
* Name: Benjamin Bever
* Date: 07/31/2025
*
* Program Description:
* This program shows a menu with three options:
* 1. The computer tries to guess the user's number.
* 2. The user tries to guess the computer's number.
* 3. Exit the program.
*
* Honor Code Statement:
* I affirm that this program is my own work and that I have not
* shared this code or provided unauthorized assistance with it.
*
* Purpose:
* To practice conditionals, loops, user input, and random numbers.
*
* Input:
* Menu choice, number guesses, and user feedback.
*
* Output:
* Messages that show if guesses are correct or not.
*
* Notes:
* - The computer has 7 tries to guess the user's number.
* - The user can keep guessing until they get it right.
*/


package project2a_BenjaminBever;

import java.util.Scanner;

public class project2a {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int choice = 0;

        while (choice != 3) {
            System.out.println("----- Menu -----");
            System.out.println("1. Guess Your Number");
            System.out.println("2. Guess My Number");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scnr.nextInt();

            if (choice == 1) {
                int low = 0;
                int high = 100;
                int tries = 0;
                char reply = ' ';

                System.out.println("Think of a number from 0 to 100.");
                System.out.println("I will guess it in 7 tries or less.");

                while (tries < 7 && reply != 'C') {
                    int guess = (low + high) / 2;
                    System.out.print("Is it " + guess + "? (H = too high, L = too low, C = correct): ");
                    reply = scnr.next().toUpperCase().charAt(0);
                    tries++;

                    if (reply == 'H') {
                        high = guess - 1;
                    } else if (reply == 'L') {
                        low = guess + 1;
                    }
                }

                if (reply == 'C') {
                    System.out.println("I guessed your number in " + tries + " tries!");
                } else {
                    System.out.println("I couldn’t guess your number in 7 tries.");
                }

            } else if (choice == 2) {
                int secret = (int)(Math.random() * 100) + 1;
                int guess = 0;
                int tries = 0;

                System.out.println("I'm thinking of a number from 1 to 100.");

                while (guess != secret) {
                    System.out.print("Enter your guess: ");
                    guess = scnr.nextInt();
                    tries++;

                    if (guess < secret) {
                        System.out.println("Too low.");
                    } else if (guess > secret) {
                        System.out.println("Too high.");
                    } else {
                        System.out.println("Correct! You guessed it in " + tries + " tries.");
                    }
                }

            } else if (choice == 3) {
                System.out.println("Exiting program. Goodbye!");
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        scnr.close();
    }
}
