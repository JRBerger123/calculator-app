package calculator;

import app.TextColor;

/**
 * The {@link MemoryCalc} class extends the {@link Calculator} class and implements the {@link BasicMath} interface.
 * It provides additional functionality for memory operations.
 * <p>
 * Methods available:
 * <ul>
 *    <li>{@link #MemoryCalc()} - Initializes an instance of the {@link MemoryCalc} class.</li>
 *    <li>{@link #displayMemoryValue()} - Displays the current memory value.</li>
 *    <li>{@link #memoryClear()} - Clears the memory value.</li>
 *    <li>{@link #memoryClear(boolean)} - Clears the memory value with optional user notification.</li>
 *    <li>{@link #memoryAdd(N)} - Adds the current value to the memory value.</li>
 *    <li>{@link #memorySubtract(N)} - Subtracts the current value from the memory value.</li>
 *    <li>{@link #getMemoryValue()} - Returns the current memory value.</li>
 *    <li>{@link #setMemoryValue()} - Sets the memory value to the current value.</li>
 * </ul>
 * </p>
 * 
 * @author Brandon Berger, Michael Szigethy
 * @version 1.0
 * @since 2025.04.08
 * @see <a href="https://github.com/JRBerger123/Calculator-App">GitHub Repository</a>
 * @see <a href="https://github.com/JRBerger123">Brandon Berger's GitHub</a>
 * @see <a href="https://github.com/Miz-Bl">Micahel Szigethy's GitHub</a>
 */
public class MemoryCalc extends Calculator {
    /**
     * Represents the memory value stored for the use of memory operations.
     */
    private double memoryValue = 0.0;

    /**
     * Default constructor for the {@link MemoryCalc} class.
     * <p>Initializes an instance of the {@link MemoryCalc} class.</p>
     */
    protected  MemoryCalc() {
        super(); // Call the constructor of the parent class (Calculator)
        memoryClear();
    }

    /**
     * Displays the current memory value. <p>
     */
    public void displayMemoryValue() {
        System.out.println(String.format("Memory Value: %.2f \n", getMemoryValue()));
    }

    /**
     * Clears the memory value without user notification.
     */
    public final void memoryClear() {
        memoryClear(false);
    }

    /**
     * Clears the memory value with overload that allows for user notification.
     */
    public final void memoryClear(boolean notifyUser) {
        this.memoryValue = 0.0;

        if (notifyUser) {
            System.out.println(TextColor.GREEN.colorize("Memory cleared.\n"));
        }
    }

    /**
     * Adds the given value to the memory value.
     * @param a the input value to be added to memory
     * @param <N> N is the type of the number to be added to memory
     */
    public <N extends Number> void memoryAdd(N a) {
        this.previousValue = this.memoryValue;
        add(a.doubleValue());
    }

    /**
     * Subtracts the given value from the memory value.
     * @param a the input value to be subtracted from memory
     * @param <N> N is the type of the number to be subtracted from memory
     */
    public <N extends Number> void memorySubtract(N a) {
        this.previousValue = this.memoryValue;
        subtract(a.doubleValue());
    }

    /**
     * Returns the current memory value.
     * @return a double of the current memory value
     */
    protected double getMemoryValue() {
        return this.memoryValue;
    }

    /**
     * Sets the memory value to the current value and prints it to the console.
     */
    public void setMemoryValue() {
        this.memoryValue = this.currentValue;
        displayMemoryValue();
    }
}
