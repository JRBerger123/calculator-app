package app;

import calculator.AdvanceCalc;
import calculator.Calculator;


/**
 * The {@link TestBench} class serves as the main entry point for the calculator application.
 * <p>This class provides a user interface for selecting calculator features and performing calculations.</p>
 * 
 * <p>
 * Methods available:
 * <ul>
 * <li>{@link #TestBench()} - Initializes an instance of the {@link TestBench} class.</li>
 * <li>{@link #welcomePrompt()} - Displays a welcome message to the user.</li>
 * <li>{@link #promptAdvancedFeatures()} - Prompts the user to choose between basic and advanced calculator features.</li>
 * <li>{@link #setPrecision(Object)} - Sets the precision for the calculator.</li>
 * <li>{@link #displayMemoryOptions()} - Displays memory options to the user.</li>
 * <li>{@link #handleMemoryOptions(Object, int)} - Handles memory operations based on user input.</li>
 * <li>{@link #run(Object)} - Runs the calculator application.</li>
 * </ul>
 * 
 * @author Brandon Berger, Michael Szigethy
 * @version 1.0
 * @since 2025.04.08
 * @see <a href="https://github.com/JRBerger123/Calculator-App">GitHub Repository</a>
 * @see <a href="https://github.com/JRBerger123">Brandon Berger's GitHub</a>
 * @see <a href="https://github.com/Miz-Bl">Micahel Szigethy's GitHub</a>
 */
public class TestBench {

    /**
     * Default constructor for the {@link TestBench} class.
     * <p>Initializes an instance of the {@link TestBench} class.</p>
     */
    TestBench() {
        welcomePrompt();
    }

    /**
     * Displays a welcome message to the user.
     */
    private void welcomePrompt() {
        System.out.println("Welcome to the Calculator App!");
        System.out.println("This app allows you to perform arithmetic operations.\n");
    }

    /**
     * Prompts the user to choose between basic and advanced calculator features.
     * <p>Returns true if advanced features are selected, false otherwise.</p>
     * 
     * @return boolean indicating whether advanced features are enabled or not
     */
    private boolean promptAdvancedFeatures() {
        while(true) {
            String userInput = Input.getString("Would you like advanced Calculator features? (yes/no): ");

            switch (userInput) {
                case "1", "yes", "y" -> {
                    System.out.println(TextColor.PURPLE.colorize("\tAdvanced Calculator features enabled\n"));
                    return true;
                }
                case "2", "no", "n" -> {
                    System.out.println(TextColor.PURPLE.colorize("\tBasic Calculator features only\n"));
                    return false;
                }
                default -> {
                    System.out.println(TextColor.RED.colorize("Invalid input. Please enter yes or no.\n"));
                }
            }
        }
    }

    /**
     * Sets the precision for the calculator.
     * <p>This method prompts the user to enter a precision value between 0 and 10.</p>
     * @param calc the calculator object (either basic or advanced)
     */
    private void setPrecision(Object calc) {
        try {
            if (calc instanceof AdvanceCalc advanceCalc) {
                int precision = Input.getIntRange("What would you like your calculator's decimal precision to be (0-10)? ", 0, 10);
                advanceCalc.setPrecision(precision);
            }
            else {
                System.out.println("Precision setting is not available in this calculator.\n");
            }
        } 
        catch (IllegalArgumentException e) {
            System.out.println("Error Occurred: " + e.getMessage() + "\n");
        }
    }

    /**
     * Displays memory options to the user.
     * <p>This method provides a menu of memory operations for the user to choose from.</p>
     * @return int representing the selected memory operation option
     */
    private static int displayMemoryOptions() {
        System.out.println("Memory Options:");
        System.out.println("1. Set Memory Value");
        System.out.println("2. Memory Clear");
        System.out.println("3. Memory Add");
        System.out.println("4. Memory Subtract");

        return Input.getIntRange("Select an option (1-4): ", 1, 4);
    }

    /**
     * Handles memory operations based on user input.
     * <p>This method performs memory operations such as setting, clearing, adding, and subtracting memory values.</p>
     * @param calc the calculator object (either basic or advanced)
     * @param option the selected memory operation option
     */
    private static void handleMemoryOptions(Object calc, int option) {
        if (calc instanceof AdvanceCalc advanceCalc) {
            switch (option) {
                case 1 -> {
                    advanceCalc.setMemoryValue();
                    System.out.println();
                }
                case 2 -> advanceCalc.memoryClear(true);
                case 3 -> {
                    double userInput = Input.getDouble("Enter the value to add to memory: ");
                    advanceCalc.memoryAdd(userInput);
                }
                case 4 -> {
                    double userInput = Input.getDouble("Enter the value to subtract from memory: ");
                    advanceCalc.memorySubtract(userInput);
                }
                default -> System.out.println("Invalid option. Please select a number between 1 and 4.");
            }
        } else {
            System.out.println("Memory operations are not available in this calculator.");
        }
    }

    /**
     * Runs the calculator application.
     * <p>This method handles user input and performs calculations based on the selected calculator type.</p>
     * @param calc the calculator object (either basic or advanced)
     * @return boolean indicating whether to continue running the calculator or not
     */
    private boolean run(Object calc) {
        try {
            if (calc instanceof AdvanceCalc advancedCalc) {
                System.out.println("Available operations: +, -, *, /, mem, sqrt, pow");
                String userInput = Input.getString("Enter an operation: ");
    
                switch (userInput) {
                    case "1", "+", "add" -> {
                        double val = Input.getDouble("Enter the number to add: ");
                        System.out.println();
                        advancedCalc.add(val);
                    }
    
                    case "2", "-", "subtract" -> {
                        double val = Input.getDouble("Enter the number to subtract: ");
                        System.out.println();
                        advancedCalc.subtract(val);
                    }
    
                    case "3", "*", "multiply" -> {
                        double val = Input.getDouble("Enter the number to multiply: ");
                        System.out.println();
                        advancedCalc.multiply(val);
                    }
    
                    case "4", "/", "divide" -> {
                        double val = Input.getDouble("Enter the number to divide: ");
                        System.out.println();
                        advancedCalc.divide(val);
                    }
    
                    case "5", "mem" -> {
                        System.out.println();
                        advancedCalc.displayMemoryValue();
                        int optionSelected = displayMemoryOptions();
                        handleMemoryOptions(advancedCalc, optionSelected);
                    }
    
                    case "6", "sqrt" -> {
                        System.out.println();
                        advancedCalc.sqrt();
                    }
    
                    case "7", "pow" -> {
                        double exponent = Input.getDouble("Enter the exponent: ");
                        System.out.println();
                        advancedCalc.pow(exponent);
                    }

                    case "exit" -> {
                        System.out.println(TextColor.PURPLE.colorize("\nExiting the calculator. Goodbye!"));
                        return false; // Exit the method to stop further execution
                    }
    
                    default -> System.out.println("\nInvalid operation. Please try again.\n");
                }
    
            } else if (calc instanceof Calculator basicCalc) {

                System.out.println("Available operations: +, -, *, /");
                String userInput = Input.getString("Enter an operation: ");

                switch (userInput) {
                    case "1", "+", "add" -> {
                        double val = Input.getDouble("Enter the number to add: ");
                        System.out.println();
                        basicCalc.add(val);
                    }
    
                    case "2", "-", "subtract" -> {
                        double val = Input.getDouble("Enter the number to subtract: ");
                        System.out.println();
                        basicCalc.subtract(val);
                    }
    
                    case "3", "*", "multiply" -> {
                        double val = Input.getDouble("Enter the number to multiply: ");
                        System.out.println();
                        basicCalc.multiply(val);
                    }
    
                    case "4", "/", "divide" -> {
                        double val = Input.getDouble("Enter the number to divide: ");
                        System.out.println();
                        basicCalc.divide(val);
                    }

                    case "exit" -> {
                        System.out.println(TextColor.PURPLE.colorize("\nExiting the calculator. Goodbye!"));
                        return false; // Exit the method to stop further execution
                    }
    
                    default -> System.out.println("\nInvalid operation. Please try again.\n");
                }
            }
        } catch (Exception e) {
            System.out.println("Error Occurred: " + e.getMessage() + "\n");
        }
        return true; // Continue running the calculator
    }

    /**
     * Main method to run the calculator application.
     * <p>This method initializes the calculator and handles user input.</p>
     * @param args command line arguments (not used)
     * <p>Note: This method is the entry point of the application.</p>
     */
    public static void main(String[] args) {
        boolean advancedFeaturesEnabled;
        Object calculator;

        TestBench testBench = new TestBench();
        
        advancedFeaturesEnabled = testBench.promptAdvancedFeatures();

        if (advancedFeaturesEnabled) {
            calculator = new AdvanceCalc(){}; // Create an instance of AdvanceCalc using an anonymous subclass because of abstract class
            testBench.setPrecision(calculator);
        } else {
            calculator = new Calculator(){}; // Create an instance of Calculator using an anonymous subclass because of abstract class
        }

        while(testBench.run(calculator)){}

        System.out.println("Thank you for using the calculator app! Have a great day!");
    }
}