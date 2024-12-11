# Ex1.java
This program includes:
various functions for converting numbers between different bases, checking if numbers are valid,
and performing basic arithmetic operations. It supports base conversions from 2 to 16 and includes
a set of utility functions for working with number strings in custom bases.
# Features:
1. number2int(String num): Converts a number (in a string format) from any valid base (2 to 16) to its decimal value.

2. isNumber(String a): Checks if a given string represents a valid number in a custom base format (e.g., "101b2" for binary, "1FbG" for hexadecimal).

3. int2Number(int num, int base): Converts a decimal number to a string in a specified base (between 2 and 16).

4. equals(String n1, String n2): Compares two numbers (as strings) and returns true if they are equal, false otherwise.

5. maxIndex(String[] arr): Finds the index of the largest number in an array of strings representing numbers in various bases.

# Ex1Main.java
This program allows users to input two numbers (in various bases), perform basic arithmetic operations on them,
and display the results in a specified base. It also determines the largest number from the input values and outputs.
# Features:
* Input Validation: The program checks if the input numbers are in a valid format for custom bases (2 to 16).

* Base Conversion: The program converts the sum and product of the two input numbers to a user-defined base between 2 and 16.

* Arithmetic Operations: The program performs addition and multiplication on the two numbers.

* Max Value Calculation: After performing the operations, the program finds the largest number among the inputs and results.

* User Interaction: The program interacts with the user through the command line, requesting inputs and displaying outputs in a loop until the user types "quit".

# Ex1Test :
This project contains a JUnit test class (Ex1Test) that tests the functionality of the methods implemented in the Ex1 class.
These methods are designed to handle operations related to number conversion between different bases, including binary, octal, decimal, and hexadecimal.
The tests aim to verify the correctness of methods such as number2int, int2Number, isNumber, maxIndex, and equals.
The test class consists of multiple test methods, each focusing on a different function of the Ex1 class.

1. computeNumberTest:
This test verifies if the conversion from string to integer (number2int) and integer to string (int2Number) functions work correctly.
It checks the consistency between the input string, the converted integer, and the string converted back from the integer.

2. isBasisNumberTest:
This test checks if the isNumber function correctly identifies valid and invalid number strings in different bases.


3. int2NumberTest:
This test evaluates the int2Number function, which converts a decimal integer to a string in a specified base.


4. maxIndexTest:
This test verifies the maxIndex function, which finds the index of the largest number from an array of strings.


5. equalsTest:
This test checks the equals function, which compares two number strings to see if they represent the same value in different bases.




