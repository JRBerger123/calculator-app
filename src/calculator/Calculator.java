package calculator;

/**
 * The {@code Calculator} class represents a calculator object. <p>
 * The {@code Calculator} class implements the {@code BasicMath} interface and defines the following methods:
 * <ul>
 *      <li>void add(N)</li>
 *      <li>void subtract(N)</li>
 *      <li>void multiply(N)</li>
 *      <li>void divide(N)</li>
 * </ul>
 * Methods available:
 * <ul>
 *      <li>{@link #add(N)} - Adds two variables.</li>
 *      <li>{@link #subtract(N)} - Subtracts two variables.</li>
 *      <li>{@link #multiply(N)} - Multiplies two variables.</li>
 *      <li>{@link #divide(N)} - Divides two variables.</li>
 *      <li>{@link #clear()} - Clears class attributes.</li>
 *      <li>{@link #updateDisplay()} - Displays what mathematical operation happened and the results.</li>
 * </ul>
 *
 * @author Brandon Berger, ...
 * @version 0.7
 * @since 2025.04.07
 * @see <a href="https://github.com/JRBerger123/Calculator-App">GitHub Repository</a>
 * @see <a href="https://github.com/JRBerger123">Brandon Berger's GitHub</a>
 */
public class Calculator<N extends Number> implements BasicMath<N> {
    /**
     * Represents the previous value of the calculator.
     */
    double previousValue = 0.0;

    /**
     * Represents the current value of the calculator.
     * This value is updated after each operation.
     */
    double currentValue = 0.0;

    /**
     * Represents the new input value of the calculator.
     * This value is used for calculations.
     */
    double inputValue = 0.0;

    /**
     * Represents the operator used for the last operation.
     */
    char operator = '+';

    /**
     * Adds the input value to the previous value.
     * @param a the input value to be added
     */
    @Override
    public void add(N a) {
        this.operator = '+';

        try {
            this.currentValue = this.previousValue + a.doubleValue();
            updateDisplay();
        }
        catch (Exception e) {
            // Handles any exceptions that may occur
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Subtracts the input value from the previous value.
     * @param a the input value to be subtracted
     */
    @Override
    public void subtract(N a) {
        this.operator = '-';

        try {
            this.currentValue = this.previousValue - a.doubleValue();
            updateDisplay();
        }
        catch (Exception e) {
            // Handles any exceptions that may occur
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Multiplies the input value with the previous value.
     * @param a the input value to be multiplied
     */
    @Override
    public void multiply(N a) {
        this.operator = '*';
        
        try {
            this.currentValue = this.previousValue * a.doubleValue();
            updateDisplay();
        }
        catch (Exception e) {
            // Handles any exceptions that may occur
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Divides the previous value by the input value.
     * @param a the input value to divide by
     */
    @Override
    public void divide(N a) {
        this.operator = '/';

        try {
            this.currentValue = this.previousValue / a.doubleValue();
            updateDisplay();
        } 
        catch (ArithmeticException e) {
            // Handles division by zero
            System.out.println("Error: " + e.getMessage());
        } 
        catch (Exception e) {
            // Handles any other exceptions that may occur
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Clears the calculator's previous and current values, input value, and operator.
     */
    public void clear() {
        previousValue = 0.0;
        currentValue = 0.0;
        inputValue = 0.0;
        operator = '+';
    }

    /**
     * Updates the display with the current operation and result.
     * This method is called after each operation to show the result.
     */
    public void updateDisplay() {
        System.out.println(previousValue + " " + operator + " " + inputValue + " = " + currentValue);
    }
}