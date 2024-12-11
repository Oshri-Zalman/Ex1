
import java.util.Scanner;
/*
This program asks the user to enter two numbers. It checks if the numbers are in the correct format.
If they are, it adds and multiplies the numbers, then shows the results in a base that the user chooses (between 2 and 16).
 The program also shows the biggest number out of the ones entered. If the user types "quit," the program stops.
If there's an error with the numbers or the base, the program will show an error message.
 */
public class Ex1Main {
  public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
      String num1 = "", num2 = "", quit = "quit";

      while (!num1.equals(quit) && !num2.equals(quit)) {
         System.out.println();
         System.out.println("Ex1 class solution:");
         System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
         num1 = sc.nextLine();

          if (!num1.equals(quit)) {
           boolean isNum1Valid = Ex1.isNumber(num1); // check the format of num1 with the function "isNumber"
           int value1 = -1;

             if (isNum1Valid) {
               value1 = Ex1.number2int(num1);
               System.out.println("num1= " + num1 + " is number: " + isNum1Valid + " , value: " + value1);
               System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                num2 = sc.nextLine();

                 if (!num2.equals(quit)) {
                   boolean isNum2Valid = Ex1.isNumber(num2); // check the format of num2 with the function "isNumber"
                    int value2 = -1;
                    if (isNum2Valid) {
                      value2 = Ex1.number2int(num2);
                      }
                        System.out.println("num2= " + num2 + " is number: " + isNum2Valid + " , value: " + value2);

                        if (!isNum2Valid) {
                            System.out.println("ERR: num2 is in the wrong format! (" + num2 + ")");
                        } else {
                            System.out.println("Enter a base for output: (a number [2,16]): ");
                            int base = sc.nextInt();
                            sc.nextLine();

                            if (base < 2 || base > 16) { // check if the base is valid.
                                System.out.println("ERR: wrong base, should be [2,16], got (" + base + ")");
                            } else {
                              int sum = value1 + value2; // sum of the 2 numbers
                              int product = value1 * value2; // product of the 2 numbers
                              String sumInBase = Ex1.int2Number(sum, base); // convert the sum to the base that the user chose with the function "int2Number"
                              String productInBase = Ex1.int2Number(product, base); // convert the product to the base that the user chose with function "int2Number".

                              System.out.println(num1 + " + " + num2 + " = " + sumInBase);
                              System.out.println(num1 + " * " + num2 + " = " + productInBase);

                              String[] numbers = {num1, num2, sumInBase, productInBase}; // check the max index with the function "maxIndex".
                              int maxIndex = Ex1.maxIndex(numbers);
                              String maxNumber = numbers[maxIndex];
                              System.out.println("Max number over [" + String.join(",", numbers) + "] is: " + maxNumber);
                            }
                        }
                    }
                } else {
                    System.out.println("ERR: num1 is in the wrong format! (" + num1 + ")");
                }
            }
        }
        System.out.println("quitting now....");
    }
}

