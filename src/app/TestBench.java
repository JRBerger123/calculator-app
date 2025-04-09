package app;

import java.util.Scanner;

import calculator.AdvanceCalc;
import calculator.Calculator;
import calculator.MemoryCalc;



public class TestBench {

    class BasicCalc extends Calculator<Double> {}
    class AdvancedCalc extends AdvanceCalc<Double> {}

    public TestBench() {
        BasicCalc basicCalc = new BasicCalc();
        AdvancedCalc advancedCalc = new AdvancedCalc();
        welcomePrompt(basicCalc);

        
        welcomePrompt(advancedCalc);
    }

    public void welcomePrompt(Object calc) {
        Scanner scanner = new Scanner(System.in); // Create scanner once

        System.out.println("Welcome to the Calculator App!");
        System.out.println("This app allows you to perform arithmetic operations.");

        if (calc instanceof AdvanceCalc) {
        System.out.println("You are using the Advanced Calculator.");
        System.out.print("What would you like your calculator's decimal precision to be (0-10)? ");

        // Validate user input
        while (true) {
            try {
                int userInput = Integer.parseInt(scanner.nextLine());
                if (userInput >= 0 && userInput <= 10) {
                    setPrecision(userInput);
                    break;
                } else {
                    System.out.print("Please enter a Integer between 0 and 10, inclusive: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter an Integer between 0 and 10, inclusive: ");
            }
        }


        if (calc instanceof AdvanceCalc) {
            String userInput = scanner.nextLine();

            System.out.println("Available operations: +, -, *, /, mem, sqrt, pow");

            switch (userInput) {
                case "5", "mem" -> displayMemoryOptions();

                case "6", "sqrt" -> calc.sqrt();

                case "7", "pow" -> {
                    System.out.print("Enter the exponent: ");
                    double exponent = scanner.nextDouble();
                    calc.pow(exponent);
                }

                default -> System.out.println("Invalid operation. Please try again.");
            }
            
        } 
        else if (calc instanceof MemoryCalc) {
            String userInput = scanner.nextLine();

            System.out.println("Available operations: +, -, *, /, mem");


        }
        
        System.out.println("Type 'exit' to quit the application.");
    }

    public static int displayMemoryOptions() {
        System.out.println("Memory Options:");
        System.out.println("1. Display Memory Value");
        System.out.println("2. Memory Clear");
        System.out.println("3. Memory Add");
        System.out.println("4. Memory Subtract");
        System.out.println("5. Set Memory Value");
        System.out.print("Select an option (1-5): ");
        Scanner scanner = new Scanner(System.in);
        try {
        return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter an Integer between 1 and 5.");
            return -1; // Return an invalid option
        }
    }

    public static void main(String[] args) {
        System.out.println("TestBench is running...");
        new TestBench();
    }
}