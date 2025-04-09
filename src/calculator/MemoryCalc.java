package calculator;

/**
 * The {@code MemoryCalc} class extends the {@code Calculator} class and implements the {@code BasicMath} interface.
 * It provides additional functionality for memory operations.
 * <p>
 * Methods available:
 * <ul>
 *    <li>{@link #displayMemoryValue()} - Displays the current memory value.</li>
 *    <li>{@link #memoryClear()} - Clears the memory value.</li>
 *    <li>{@link #memoryAdd()} - Adds the current value to the memory value.</li>
 *    <li>{@link #memorySubtract()} - Subtracts the current value from the memory value.</li>
 *    <li>{@link #getMemoryValue()} - Returns the current memory value.</li>
 *    <li>{@link #setMemoryValue()} - Sets the memory value to the current value.</li>
 * </ul>
 * @param <N> the type of number (e.g., Integer, Double) that this class will work with
 * @author Brandon Berger, Michael Szigethy
 * @version 1.0
 * @since 2025.04.08
 * @see <a href="https://github.com/JRBerger123/Calculator-App">GitHub Repository</a>
 * @see <a href="https://github.com/JRBerger123">Brandon Berger's GitHub</a>
 * @see <a href="https://github.com/Miz-Bl">Micahel Szigethy's GitHub</a>
 */
public class MemoryCalc<N extends Number> extends Calculator<N> {
    double memoryValue = 0.0;

    /**
     * Displays the current memory value.
     */
    void displayMemoryValue() {
        System.out.println("Memory Value: " + getMemoryValue());
    }

    /**
     * Clears the memory value.
     */
    void memoryClear() {
        this.memoryValue = 0.0;
    }

    /**
     * Adds the current value to the memory value.
     */
    @SuppressWarnings("unchecked") // Suppress unchecked cast warning for Number to N as memoryValue is of type double, a valid Number type.
    void memoryAdd() {
        add((N)(Number) this.memoryValue);
    }

    /**
     * Subtracts the current value from the memory value.
     */
    @SuppressWarnings("unchecked") // Suppress unchecked cast warning for Number to N as memoryValue is of type double, a valid Number type.
    void memorySubtract() {
        subtract((N)(Number) this.memoryValue);
    }

    /**
     * Returns the current memory value.
     * @return a double of the current memory value
     */
    double getMemoryValue() {
        return this.memoryValue;
    }

    /**
     * Sets the memory value to the current value.
     */
    void setMemoryValue() {
        this.memoryValue = this.currentValue;
    }
}
