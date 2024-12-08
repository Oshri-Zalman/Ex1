import javax.swing.*;
import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */


public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2="", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (!num1.equals("quit")) {
                boolean num1format = Ex1.isNumber(num1);
                if (num1format) {
                    System.out.println("its in the format good job!");
                    System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                    num2 = sc.next();
                    if (!num2.equals("quit")) {
                        boolean num2format = Ex1.isNumber(num2);
                        if (num2format) {
                            System.out.println("its in the format good job!");
                        }
                        else {
                            System.out.println("its isnt in the format try again!");
                        }
                    }
                    }
                else {
                    System.out.println("its isnt format try again!");
                }

            }
        }
        System.out.println("quiting now...");
    }
}
