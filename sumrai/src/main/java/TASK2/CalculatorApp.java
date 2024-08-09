package TASK2;
import java.util.Scanner;

public class CalculatorApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu(); 
            int choice = getValidChoice(); 
            if (choice == 5) { 
                System.out.println("Exiting...");
                scanner.close();
                System.exit(0); 
            }
            performOperation(choice); 
        }
    }

    private static void displayMenu() {
        System.out.println("Calculator Application");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private static int getValidChoice() {
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
        if (choice < 1 || choice > 5) {
            System.out.println("Invalid choice. Please select a valid option.");
            return getValidChoice();
        }
        return choice;
    }

    private static void performOperation(int choice) {
        double num1 = getValidNumber("Enter the first number: ");
        double num2 = getValidNumber("Enter the second number: ");
        double result = 0;

        switch (choice) {
            case 1:
                result = add(num1, num2);
                break;
            case 2:
                result = subtract(num1, num2);
                break;
            case 3:
                result = multiply(num1, num2);
                break;
            case 4:
                result = divide(num1, num2);
                break;
            default:
                System.out.println("Invalid operation.");
                return;
        }

        System.out.println("The result is: " + result + "\n");
    }

    private static double getValidNumber(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }

    private static double add(double a, double b) {
        return a + b;
    }

    private static double subtract(double a, double b) {
        return a - b;
    }

    private static double multiply(double a, double b) {
        return a * b;
    }

    private static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return Double.NaN; 
        }
        return a / b;
    }
}
