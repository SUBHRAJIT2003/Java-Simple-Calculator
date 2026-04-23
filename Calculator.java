import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        System.out.println("=== Simple Java Backend Calculator ===");

        // A loop to allow multiple calculations until the user decides to quit
        while (keepRunning) {
            try {
                System.out.print("\nEnter the first number: ");
                double num1 = scanner.nextDouble();

                System.out.print("Enter an operator (+, -, *, /) or type 'q' to quit: ");
                char operator = scanner.next().charAt(0);

                // Exit condition
                if (operator == 'q' || operator == 'Q') {
                    System.out.println("Closing the calculator. Goodbye!");
                    keepRunning = false;
                    break;
                }

                System.out.print("Enter the second number: ");
                double num2 = scanner.nextDouble();

                double result = 0;
                boolean validOperation = true;

                // Perform the calculation based on the chosen operator
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            System.out.println("Error: Division by zero is not allowed!");
                            validOperation = false;
                        }
                        break;
                    default:
                        System.out.println("Error: Invalid operator!");
                        validOperation = false;
                }

                // Print the result if the operation was valid
                if (validOperation) {
                    System.out.println("-------------------------");
                    System.out.println("Result: " + num1 + " " + operator + " " + num2 + " = " + result);
                    System.out.println("-------------------------");
                }
                
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter numbers only.");
                scanner.nextLine(); // Clear the bad input from the scanner
            }
        }

        // Always close the scanner to prevent memory leaks
        scanner.close();
    }
}