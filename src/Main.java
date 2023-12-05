import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

class FibonacciUtils {
    static int cycleExecute(int n) {
        if (n <= 1) {
            return n;
        }
        int previous = 0, current = 1;
        for (int i = 2; i <= n; i++) {
            int next = previous + current;
            previous = current;
            current = next;
        }
        return current;
    }

    static int recursionExecute(int n) {
        if (n <= 1) {
            return n;
        } else {
            return recursionExecute(n - 1) + recursionExecute(n - 2);
        }
    }
}

class FactorialUtils {
    static int cycleExecute(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    static int recursionExecute(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * recursionExecute(n - 1);
        }
    }
}

class SumOfDigits {
    static int execute(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + execute(n / 10);
    }
}

class BitwiseAddition {
    static int execute(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return execute(sum, carry);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = getUserInput("Enter a value for N (questions 1-3): ", scanner);
        int B = getUserInput("Enter a value for A (question 4)", scanner);
        int C = getUserInput("Enter a value for C (question 4): ", scanner);
        scanner.close();

        if (A < 0 || B < 0 || C < 0) {
            System.out.println("Input should be non-negative");
            return;
        }

        int question1_1 = FactorialUtils.cycleExecute(A);
        int question2_1 = FactorialUtils.recursionExecute(A);
        assert question1_1 == question2_1 : "Different values at question 1";

        int question1_2 = FibonacciUtils.cycleExecute(A);
        int question2_2 = FibonacciUtils.recursionExecute(A);
        assert question2_2 == question1_2 : "Different values at question 2";

        int question3 = SumOfDigits.execute(A);
        int question4 = BitwiseAddition.execute(B, C);

        System.out.println("\nCycle\nFactorial of " + A + ": " + question1_1 + "\nFibonacci of " + A + ": " + question1_2);
        System.out.println("\nRecursion\nFactorial of " + A + ": " + question2_1 + "\nFibonacci of " + A + ": " + question2_2);
        System.out.println("\nquestion 3\nSum of numbers: " + question3);
        System.out.println("\nquestion 4\nBitwise summary: " + question4);
    }

    private static int getUserInput(String prompt, @NotNull Scanner scanner) {
        System.out.print(prompt);
        return scanner.nextInt();
    }
}
