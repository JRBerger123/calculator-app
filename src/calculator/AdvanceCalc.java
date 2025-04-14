package calculator;

/**
 * The {@link AdvanceCalc} class extends the {@link MemoryCalc} class and implements the {@link AdvanceMath} interface.
 * It provides additional functionality for advanced mathematical operations.
 * <p>
 * Methods available:
 * <ul>
 *   <li>{@link #sqrt()} - Calculates the square root of the current input value.</li>
 *   <li>{@link #pow(N)} - Raises the current input value to the power of the given exponent.</li>
 *   <li>{@link #setPrecision(int)} - Sets the precision for calculations.</li>
 *   <li>{@link #displayMemoryValue()} - Displays the current memory value.</li>
 *   <li>{@link #updateDisplay()} - Updates the display with the current operation and result.</li>
 * </ul>
 * <p>
 * 
 * @author Brandon Berger, Michael Szigethy
 * @version 1.0
 * @since 2025.04.08
 * @see <a href="https://github.com/JRBerger123/Calculator-App">GitHub Repository</a>
 * @see <a href="https://github.com/JRBerger123">Brandon Berger's GitHub</a>
 * @see <a href="https://github.com/Miz-Bl">Micahel Szigethy's GitHub</a>
 */
public abstract class AdvanceCalc extends MemoryCalc implements AdvanceMath {
    /**
     * Represents the precision to be shown in each calculation.
     * <p>Default value is 0, which means no decimal places.</p>
     */
    int precision = 0;

    /**
     * Default constructor for the {@link AdvanceCalc} class.
     *
     * <p>Initializes the fields for an instance of the {@link AdvanceCalc} class.
     */
    public AdvanceCalc() {
        super(); // Call the constructor of the parent class (MemoryCalc)
        this.precision = 0; // Default precision is set to 0 decimal places
    }

    /**
     * Calculates the square root of the current input value.
     *
     * <p>The method also updates the display of the current state by calling
     * {@link #updateDisplay()} and sets {@link Calculator#previousValue previousValue} to the result.</p>
     */
    @Override
    public void sqrt() {
        try {
            this.operator = '\u221A';
            if (inputValue < 0) {
                System.out.println("Error: cannot take square root of a negative number.");
                return;
            }
            this.currentValue = Math.sqrt(inputValue);
            updateDisplay();
            this.previousValue = this.currentValue;
        }
        catch (Exception e) {
            System.out.println("Cannot take square root of a negative number.");
        }
    }

    /**
     *  Uses input value as an exponent value.
     * 
     * @param a is the exponent
     * @param <N> N is the type of number (e.g., Integer, Double) that this method will work with
     */
    @Override
    public <N extends Number> void pow(N a){
        try {
            this.operator = '^';
            this.currentValue = Math.pow(this.inputValue, a.doubleValue());
            updateDisplay();
            this.previousValue = this.currentValue;
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Sets the precision value for calculations.
     *
     * @param p the precision value to be set, as int
     */
    public void setPrecision(int p){
        this.precision = p;
        System.out.println("Precision set to " + this.precision + " decimal places.");
    }

    /**
     * Displays the current value stored in memory.
     *
     * <p>Calls the parent class's {@link MemoryCalc#displayMemoryValue() displayMemoryValue()}
     * method to handle the memory display functionality.</p>
     */
    @Override
    public void displayMemoryValue() {
        super.displayMemoryValue();
    }

    /**
     * Updates the display with the current operation and result.
     * This method is called after each operation to show the result.
     */
    @Override
    public void updateDisplay() {
        if (this.operator != '\0') {
            String format = "%." + precision + "f";
            System.out.println(String.format(format + " %s " + format + " = " + format, this.previousValue, this.operator, this.inputValue, this.currentValue));
        } else {
            System.out.println("No operation performed yet.");
        }
    }
}
