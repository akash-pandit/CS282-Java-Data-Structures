import java.lang.Math;

class SumOfDigits {
    public static void main(String[] args) {
        System.out.println("\n!!! Behold, recursion! !!!\nSumming the digits of an integer.");
        System.out.println("When dealing with negative integers, the first number will be considered to be negative.");

        int input = 192;
        printSumOfDigits(input);
        input = 000123;  // input is read as octal due to leading 0s, decimal conversion is 83
        printSumOfDigits(input);
        input = -1329;
        printSumOfDigits(input);
        input = 0;
        printSumOfDigits(input);
        input = 6;
        printSumOfDigits(input);
    }

    static void printSumOfDigits(int input) {
        System.out.printf("Sum of digits in %d: %d\n", input, sumOfDigits(input));
    }

    static int sumOfDigits(int digit) {
        // 1 digit, sum is found (base case)
        if (Math.abs(digit) < 10) {
            return digit;
        }

        // set vars for recursion
        int rightmostDigit = Math.abs(digit) % 10;
        int remainingDigits = digit / 10;
        // System.out.printf("rightmost %d remaining %d\n", rightmostDigit, remainingDigits);

        // recursive call
        return rightmostDigit + sumOfDigits(remainingDigits);
    }
}