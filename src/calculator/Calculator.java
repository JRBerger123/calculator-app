package calculator;

/**
 * The {@link Calculator} class represents a calculator object. <p>
 * The {@link Calculator} class implements the {@link BasicMath} interface and defines the following methods:
 * <ul>
 *      <li>void add(N)</li>
 *      <li>void subtract(N)</li>
 *      <li>void multiply(N)</li>
 *      <li>void divide(N)</li>
 * </ul>
 * Methods available:
 * <ul>
 *      <li>{@link #Calculator()} - Initializes an instance of the {@link Calculator} class.</li>
 *      <li>{@link #add(N)} - Adds a variable to {@link #previousValue} using double operation logic.</li>
 *      <li>{@link #subtract(N)} - Subtracts a variable to {@link #previousValue} using double operation logic.</li>
 *      <li>{@link #multiply(N)} - Multiplies a variable to {@link #previousValue} using double operation logic.</li>
 *      <li>{@link #divide(N)} - Divides a variable to {@link #previousValue} using double operation logic.</li>
 *      <li>{@link #clear()} - Clears class attributes.</li>
 *      <li>{@link #operatorHandler(double)} - Handles part of code for operations and updates the display.</li>
 *      <li>{@link #updateDisplay()} - Displays the mathematical operation and the results.</li>
 * </ul>
 *
 * @author Brandon Berger, Michahel Szigethy
 * @version 1.0
 * @since 2025.04.07
 * @see <a href="https://github.com/JRBerger123/Calculator-App">GitHub Repository</a>
 * @see <a href="https://github.com/JRBerger123">Brandon Berger's GitHub</a>
 * @see <a href="https://github.com/Miz-Bl">Micahel Szigethy's GitHub</a>
 */
public abstract class Calculator implements BasicMath {
    /**
     * Represents the previous value of the calculator.
     */
    protected double previousValue;

    /**
     * Represents the current value of the calculator.
     * This value is updated after each operation.
     */
    protected double currentValue;

    /**
     * Represents the new input value of the calculator.
     * This value is used for calculations.
     */
    protected double inputValue;

    /**
     * Represents the operator used for the operation.
     */
    protected char operator;

    /**
     * Default constructor for the {@link Calculator} class.
     * <p>Initializes an instance of the {@link Calculator} class.</p>
     */
    protected Calculator() {
        clear();
    }

    /**
     * Adds the input value to the previous value.
     * @param a the input value to be added
     * @param <N> N is the type of number (e.g., Integer, Double) that this method will work with
     */
    @Override
    public <N extends Number> void add(N a) {
        try {
            this.operator = '+';
            this.currentValue = this.previousValue + a.doubleValue();

            operatorHandler(a.doubleValue());
        }
        catch (Exception e) {
            // Handles any exceptions that may occur
            System.out.println("Error adding: " + e.getMessage() + "\n");
        }
    }

    /**
     * Subtracts the input value from the previous value.
     * @param a the input value to be subtracted
     * @param <N> N is the type of number (e.g., Integer, Double) that this method will work with
     */
    @Override
    public <N extends Number> void subtract(N a) {
        try {
            this.operator = '-';
            this.currentValue = this.previousValue - a.doubleValue();
            
            operatorHandler(a.doubleValue());
        }
        catch (Exception e) {
            // Handles any exceptions that may occur
            System.out.println("Error subtracting: " + e.getMessage() + "\n");
        }
    }

    /**
     * Multiplies the input value with the previous value.
     * @param a the input value to be multiplied
     * @param <N> N is the type of number (e.g., Integer, Double) that this method will work with
     */
    @Override
    public <N extends Number> void multiply(N a) {
        try {
            this.operator = '*';
            this.currentValue = this.previousValue * a.doubleValue();

            operatorHandler(a.doubleValue());
        }
        catch (Exception e) {
            // Handles any exceptions that may occur
            System.out.println("Error multiplying: " + e.getMessage() + "\n");
        }
    }

    /**
     * Divides the previous value by the input value.
     * @param a the input value to divide by
     * @param <N> N is the type of number (e.g., Integer, Double) that this method will work with
     */
    @Override
    public <N extends Number> void divide(N a) {
        try {
            this.operator = '/';

            // Check for division by zero
            // If the input value is zero, throw an ArithmeticException
            if (a.doubleValue() == 0) {
                throw new ArithmeticException();
            }

            this.currentValue = this.previousValue / a.doubleValue();
            operatorHandler(a.doubleValue());
        } 
        catch (ArithmeticException e) {
            // Handles division by zero
            System.out.println("Error, tried to divide by zero.\n");
        } 
        catch (Exception e) {
            // Handles any other exceptions that may occur
            System.out.println("Error dividing: " + e.getMessage() + "\n");
        }
    }

    /**
     * Clears the calculator's previous and current values, input value, and operator by setting default values to each.
     */
    public final void clear() {
        this.previousValue = 0.0;
        this.currentValue = 0.0;
        this.inputValue = 0.0;
        this.operator = '\0';
    }

    /**
     * Handles some of the operator logic and updates the display.
     * This method is called after each operation to show the result.
     * @param input the input value to be used in the operation
     * @throws Exception if an error occurs during the operation
     */
    private void operatorHandler(double input) throws Exception{
        try {
            this.inputValue = input;
            updateDisplay();
            this.previousValue = this.currentValue;
            System.out.println();
        } finally {}
    }

    /**
     * Updates the display with the current operation and result.
     * This method is called after each operation to show the result.
     */
    protected void updateDisplay() {
        if (this.operator != '\0') {
            System.out.println(String.format("%.2f %c %.2f = %.2f\n", this.previousValue, this.operator, this.inputValue, this.currentValue));
        } else {
            System.out.println("Cannot update display. No operation performed yet.\n");
        }
    }
}