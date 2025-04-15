package app;

import java.util.Scanner;


/**
 * The {@code Input} class provides methods for obtaining user input from the console.
 * Input validation is performed based on the method used.
 * <p>
 * Methods available:
 * </p>
 * <ul>
 *     <li>{@link #getLine(String)} - Retrieves a line of input from the user.</li>
 *     <li>{@link #getString(String)} - Retrieves a non-empty string from the user.</li>
 *     <li>{@link #getInt(String)} - Retrieves an integer value from the user.</li>
 *     <li>{@link #getDouble(String)} - Retrieves a double value from the user.</li>
 *     <li>{@link #getIntRange(String, int, int)} - Retrieves an integer within a specified range.</li>
 *     <li>{@link #getDate(String)} - Retrieves a valid date in the MM-DD-YYYY format.</li>
 * </ul>
 *
 * @author Brandon Berger, Michahel Szigethy
 * @version 1.0
 * @since 2025.04.07
 * @see <a href="https://github.com/JRBerger123/Calculator-App">GitHub Repository</a>
 * @see <a href="https://github.com/JRBerger123">Brandon Berger's GitHub</a>
 * @see <a href="https://github.com/Miz-Bl">Micahel Szigethy's GitHub</a>
 */
public class Input {
    /**
     * The {@code Scanner} object used for reading user input from the console.
     * It is declared as static to allow access from static methods.
     */
    private static final Scanner sc = new Scanner(System.in);

    /**
     * This method prompts for the user's input and returns the entire line entered by the user.
     * @param prompt is the message to display to the user when prompting for input
     * @return the string value entered by the user
     */
    protected static String getLine(String prompt) {
		System.out.print(prompt);
		return Input.sc.nextLine();
	}

    /**
     * This method prompts for the user's input and verifies that the user input is not empty.
     * @param prompt is the message to display to the user when prompting for input
     * @return the string value entered by the user
     */
    protected static String getString(String prompt) {
        String userInput;
        System.out.print(prompt);

        while (true) {
            userInput = Input.sc.nextLine().trim();

            if (userInput.isEmpty()) {
                System.out.print("Invalid input! Please enter a value: ");
            } else {
                break;
            }
        }
        return userInput;
    }

    /**
     * This method prompts for the user's input and verifies that the user input is a valid integer.
     * @param prompt is the message to display to the user when prompting for input
     * @return the integer value entered by the user
     */
    protected static int getInt(String prompt) {
    	int userInput;
		System.out.print(prompt);

        while (!Input.sc.hasNextInt()) {
            System.out.print("Invalid input! Please enter a number: ");
            Input.sc.next();  // clear the data in the input buffer
        }

		userInput = Input.sc.nextInt();
		Input.sc.nextLine(); // consume newline left-over
		return userInput;
	}

    /**
     * This method prompts for the user's input and verifies that the user input is a valid double.
     * @param prompt is the message to display to the user when prompting for input
     * @return the double value entered by the user
     */
    protected static double getDouble(String prompt) {
    	double userInput;
		
		System.out.print(prompt);

        while (!Input.sc.hasNextDouble()) {

            System.out.print("Invalid input! Please enter a double: ");
            Input.sc.next();  // clear the data in the input buffer

        }
			
		userInput = Input.sc.nextDouble();
		Input.sc.nextLine(); // consume newline left-over
		
		return userInput;
	}
    
    /**
     * This method prompts for the user's input and verifies that the user input is a valid integer within a specified range.
     * @param prompt is the message to display to the user when prompting for input
     * @param low is the lower bound of the valid range, inclusive
     * @param high is the upper bound of the valid range, inclusive
     * @return the integer value entered by the user
     */
    protected static int getIntRange(String prompt, int low, int high) {
        int userInput = -1;
    
        while (true) {
            System.out.print(prompt);
            try {
                String line = Input.sc.nextLine(); // read entire line
                userInput = Integer.parseInt(line); // parse manually
    
                if (userInput >= low && userInput <= high) {
                    break;
                } else {
                    System.out.printf("Invalid input! Please enter a number between (%d - %d)\n\n", low, high);
                }
            } catch (NumberFormatException e) {
                System.out.printf("Invalid input! Please enter a number between (%d - %d)\n\n", low, high);
            }
        }
        return userInput;
    }
}
