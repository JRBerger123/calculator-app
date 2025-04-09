package app;

import java.util.Scanner;

import calculator.AdvanceCalc;
import calculator.Calculator;
import calculator.MemoryCalc;



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

            if (calc instanceof AdvanceCalc<?> ac) { // Required to use subclass method of setPrecision
                ac.setPrecision(precision);
            }
            
            System.out.println("Decimal precision set to: " + precision);
        } 
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void run() {
        //...
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

    public void welcomePrompt(Object calc) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Calculator App!");
        System.out.println("This app allows you to perform arithmetic operations.");

        if (calc instanceof AdvanceCalc) {
        System.out.println("You are using the Advanced Calculator.");


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


        if (calc instanceof AdvanceCalc<?> ac) {
            String userInput = scanner.nextLine();

            System.out.println("Available operations: +, -, *, /, mem, sqrt, pow");

            switch (userInput) {
                case "1", "add" -> {
                    System.out.println("Enter number to add: ");
                    double userVariable = scanner.nextDouble();
                    ac.add(userVariable);

                }

                case "2", "subtract" -> {
                    System.out.println("Enter number to subtract: ");
                    userInput = scanner.nextLine();

                }

                case "3", "multiply" -> {
                    System.out.println("Enter number to multiply: ");
                    userInput = scanner.nextLine();

                }

                case "4", "divide" -> {
                    System.out.println("Enter number to divide: ");
                    userInput = scanner.nextLine();

                }
            }
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
        TestBench testBench = new TestBench();

        if (testBench.promptAdvancedFeatures()) {
            AdvancedCalc calculator = testBench.new AdvancedCalc();
            welcomePrompt(calculator);
        } else {
            BasicCalc calculator = testBench.new BasicCalc();
        }

        try (Scanner scanner = new Scanner(System.in)) {
            testBench.welcomePrompt(args);
        }

        testBench.run();
    }
}