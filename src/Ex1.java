
public class Ex1 {
    public static int number2int(String num) {
        if (num == null || num.isEmpty()) { // if "num" empty return ''false''
            return -1;
        }

        if (!isNumber(num)) { // check if ''num'' is valid like the format in the second function named "isNumber"
            return -1;
        }

        if (!num.contains("b")) { // in case that "num" is already regular number without "b"
            try {
                return Integer.parseInt(num); // // convert to decimal representation
            } catch (NumberFormatException e) {
                return -1; // if the input can not convert to decimal representation return -1
            }
        }

        String[] Halves = num.split("b"); // split b from ''num'' in left side is the numbers part and right side is the basis part.
        String numbers = Halves[0]; // the numbers part
        String basis = Halves[1]; // the basis part

        int basis2int;
        if (Character.isDigit(basis.charAt(0))) { // convert the basis to number
            basis2int = Integer.parseInt(basis); // if the basis is already number
        } else {
            basis2int = basis.charAt(0) - 'A' + 10; // if the basis is a letter (A-G) the result will be a number
        }

        int decimalvalue = 0;
        int multiplier = 1;


        for (int i = numbers.length() - 1; i >= 0; i--) { // for "loop" that calculate the decimal value of the numbers part based on the basis. we start from the right side of the number until left.
            char c = numbers.charAt(i);
            int digitValue;

            if (Character.isDigit(c)) {
                digitValue = c - '0'; // if the char is numbers (0-9)
            } else {
                digitValue = c - 'A' + 10; // if the char is a letters (A-F).
            }

            decimalvalue += digitValue * multiplier; // like in Digital Systems Course we study how to calculate every number in every basis (2-16) to his decimal value.
            // we multiply every digit in his basis (the basis power based on his local) from right to left, and in the end we sum up all the results.
            multiplier *= basis2int; // multiplier multiply with the basis every loop
        }

        return decimalvalue;
    }

    public static boolean isNumber(String a) {
        boolean ans = true; // if the number is like in the format return true
        if (a == null || a.isEmpty()) return false; // if null or empty return false
        if (a.startsWith("-") || a.startsWith("b") || a.contains(" ")) return false; // if a start with "b" or start with "-" or contain space return false
        if (!a.contains("b")) { // if a not contains "b" so the string is only with digits.
            return a.matches("[0-9]+");
        }
        String[] Halves = a.split("b"); // split b from ''a'' in left side is the numbers part and right side is the basis part.
        if (Halves.length != 2) { // if length is not equal to 2 its false
            return false;
        }
        String numbers = Halves[0]; // the numbers of "a"
        String basis = Halves[1]; // the basis of "a"

        if (!basis.matches("[2-9,A-G]")) { // if the basis isn't 1 char from the example its false.
            return false;
        }
        int basisint;
        if (Character.isDigit(basis.charAt(0))) {
            basisint = Integer.parseInt(basis); // if the basis is number
        } else {
            basisint = basis.charAt(0) - 'A' + 10; // if the basis is letter (A-G)
        }

        if (basisint < 2 || basisint > 16) { // checks if the basis in the range of 2 until 16.
            return false;
        }
        char[] chars = numbers.toCharArray(); // convert the numbers to chars.
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            int value;

            if (Character.isDigit(ch)) { // calculate the value of the char
                value = ch - '0'; // if its number (0-9)
            } else {
                value = ch - 'A' + 10; // if its letter (A-F)
            }

            if (value >= basisint) { // check if the number is bigger/equal to the basis if that happen its false.
                return false;
            }
        }

        return ans; // if the number in the format return true.
    }


    public static String int2Number(int num, int base) {
        String ans = "";
        if (num < 0 || base < 2 || base > 16) {
            return ans; // if the num is smaller than 0 or the base smaller than 2 or bigger than 16 return ("")
        }
        if (num == 0) {
            String basestring = "";
            if (base >= 2 && base <=9) { // if the basis is number (0-9) the char basis will be the number.
                basestring = "" + (char) ('0' + base);
            }else {
                basestring = "" + (char) ('A' + (base - 10)); // else the basis will be a letter.
            }
            return "0b" + basestring;// if num = 0 its will return 0b with the basis.
        }

        StringBuilder result = new StringBuilder(); // object that we can change and do string effectively.
        char[] digits = "0123456789ABCDEF".toCharArray(); // every char in this string have a place in the array.

        // "while" loop that convert number from decimal to (2-16) basis according to the division and remainder method.
        while (num > 0) {
            int remainder = num % base; // the remainder of the division
            result.insert(0, digits[remainder]); // adding the char to the beginning of the result.
            num /= base; // divide the number in the base.
        }

        char baseChar;
        if (base >= 2 && base <=9 ) { // check like in the beginning if the base is number or letter.
            baseChar = (char) ('0' + base);
        }else{
            baseChar = (char) ('A' + (base - 10));
        }

        return result + "b" + baseChar; // return the result of the convert from decimal to any number in basis (2-16) and his basis in the right side of b.
        }


    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        int decimaln1 = number2int(n1);  // convert n1 to his decimal value
        int decimaln2 = number2int(n2);  // convert n2 to his decimal value

        if (decimaln1 != decimaln2) { // if the decimal values not equals ans = false
            ans = false;
        }
        return ans;  // else, if there are equals return true
    }


        public static int maxIndex(String[] arr) {
            int ans = 0;  // assume that the first index is the maximum
            int maxvalue = Integer.MIN_VALUE;  // minimum value from the beginning.


            for (int i = 0; i < arr.length; i++) { // for "loop" that passing through all the array and search the maximum
                if (arr[i] != null && !arr[i].equals("-1")) { // true if -1 and null not included in the array

                    int currentValue = number2int(arr[i]);  // convert the number to his decimal value

                    if (currentValue > maxvalue) { // if the new number is bigger than the previous.
                        maxvalue = currentValue;  // the new number is now the max value.
                        ans = i; // the index of the maximum value number is the ans now.
                    }
                }
            }

            return ans;  // return the index of the maximum value number.
        }
    }
