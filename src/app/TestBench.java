package app;

import calculator.AdvanceCalc;
import calculator.Calculator;
import java.util.Scanner;



public class TestBench {

    class BasicCalc extends Calculator<Double> {}
    class AdvancedCalc extends AdvanceCalc<Double> {}

    public void setPrecision(Object calc) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("What would you like your calculator's decimal precision to be (0-10)? ");
            int precision = scanner.nextInt();
            
            if (precision < 0 || precision > 10) {
                throw new IllegalArgumentException("Precision must be between 0 and 10.");
            }

            if (calc instanceof AdvanceCalc<?> advanceCalc) {
                @SuppressWarnings("unchecked")
                AdvanceCalc<Double> ac = (AdvanceCalc<Double>) advanceCalc; // Explicitly cast to AdvanceCalc<Double>
                ac.setPrecision(precision);
            }

            System.out.println("Decimal precision set to: " + precision);
        } 
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void run(Object calc) {
        try (Scanner scanner = new Scanner(System.in)) {
    
            if (calc instanceof AdvanceCalc<?> advancedCalc) {
                // Explicit cast to AdvanceCalc<Double>
                AdvanceCalc<Double> ac = (AdvanceCalc<Double>) advancedCalc;
    
                System.out.println("Available operations: +, -, *, /, mem, sqrt, pow");
                System.out.print("Enter an operation: ");
                String userInput = scanner.nextLine();
    
                switch (userInput) {
                    case "1", "+", "add" -> {
                        System.out.print("Enter the number to add: ");
                        double addend = scanner.nextDouble();
                        ac.add(addend);
                    }
    
                    case "2", "-", "subtract" -> {
                        System.out.print("Enter the number to subtract: ");
                        double subtrahend = scanner.nextDouble();
                        ac.subtract(subtrahend);
                    }
    
                    case "3", "*", "multiply" -> {
                        System.out.print("Enter the number to multiply: ");
                        double multiplicand = scanner.nextDouble();
                        ac.multiply(multiplicand);
                    }
    
                    case "4", "/", "divide" -> {
                        System.out.print("Enter the number to divide: ");
                        double divisor = scanner.nextDouble();
                        ac.divide(divisor);
                    }
    
                    case "5", "mem" -> displayMemoryOptions();
    
                    case "6", "sqrt" -> ac.sqrt();
    
                    case "7", "pow" -> {
                        System.out.print("Enter the exponent: ");
                        double exponent = scanner.nextDouble();
                        ac.pow(exponent);
                    }

                    case "exit" -> {
                        System.out.println("Exiting the calculator. Goodbye!");
                        return; // Exit the method to stop further execution
                    }
    
                    default -> System.out.println("Invalid operation. Please try again.");
                }
    
            } else if (calc instanceof Calculator<?> calculator) {
                // Explicit cast to Calculator<Double>
                Calculator<Double> bc = (Calculator<Double>) calculator;

                System.out.println("Available operations: +, -, *, /, mem");
                System.out.print("Enter an operation: ");
                String userInput = scanner.nextLine();

                switch (userInput) {
                    case "1", "+", "add" -> {
                        System.out.print("Enter the number to add: ");
                        double addend = scanner.nextDouble();
                        bc.add(addend);
                    }
    
                    case "2", "-", "subtract" -> {
                        System.out.print("Enter the number to subtract: ");
                        double subtrahend = scanner.nextDouble();
                        bc.subtract(subtrahend);
                    }
    
                    case "3", "*", "multiply" -> {
                        System.out.print("Enter the number to multiply: ");
                        double multiplicand = scanner.nextDouble();
                        bc.multiply(multiplicand);
                    }
    
                    case "4", "/", "divide" -> {
                        System.out.print("Enter the number to divide: ");
                        double divisor = scanner.nextDouble();
                        bc.divide(divisor);
                    }

                    case "exit" -> {
                        System.out.println("Exiting the calculator. Goodbye!");
                        return; // Exit the method to stop further execution
                    }
    
                    default -> System.out.println("Invalid operation. Please try again.");
                }
            }    
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    public boolean promptAdvancedFeatures() {
        try (Scanner scanner = new Scanner(System.in)) {
            while(true) {
                System.out.println("Would you like advanced Calculator features? ");
                String userInput = scanner.nextLine();

                switch (userInput) {
                    case "1", "yes", "y" -> {
                        System.out.println("Advanced Calculator features enabled.");
                        return true; // Return true to indicate advanced features are enabled
                    }
                    case "2", "no", "n" -> {
                        System.out.println("Basic Calculator features only.");
                        return false; // Return false to indicate basic features only
                    }
                    default -> {
                        System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                    }
                }
            }
        }
    }

    public void welcomePrompt() {
        System.out.println("Welcome to the Calculator App!");
        System.out.println("This app allows you to perform arithmetic operations.");
    }

    public static void handleMemoryOptions(AdvancedCalc calc, int option) {
        switch (option) {
            case 1 -> calc.displayMemoryValue();
            case 2 -> calc.memoryClear();
            case 3 -> calc.memoryAdd();
            case 4 -> calc.memorySubtract();
            case 5 -> calc.setMemoryValue();
            default -> System.out.println("Invalid option. Please select a number between 1 and 5.");
        }
    }

    public static int displayMemoryOptions() {
        System.out.println("Memory Options:");
        System.out.println("1. Display Memory Value");
        System.out.println("2. Memory Clear");
        System.out.println("3. Memory Add");
        System.out.println("4. Memory Subtract");
        System.out.println("5. Set Memory Value");
        System.out.print("Select an option (1-5): ");

        while (true) {
            try (Scanner scanner = new Scanner(System.in)) {
                int option = scanner.nextInt();

                if (option < 1 || option > 5) {
                    System.out.println("Invalid option. Please select a number between 1 and 5.");
                    return -1; // Return an invalid option
                } else {
                    return option;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an Integer between 1 and 5.");
            }
        }
    }

    public static void main(String[] args) {
        TestBench testBench = new TestBench();

        testBench.welcomePrompt();

        if (testBench.promptAdvancedFeatures()) {
            AdvancedCalc calculator = testBench.new AdvancedCalc();
            testBench.setPrecision(calculator);
            testBench.run(calculator);
        } else {
            BasicCalc calculator = testBench.new BasicCalc();
            testBench.run(calculator);
        }
    }
}