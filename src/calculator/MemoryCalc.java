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
public class MemoryCalc extends Calculator {
    /**
     * Represents the memory value stored for the memory key funciton.
     */
    private double memoryValue = 0.0;

    /**
     * Default constructor for the {@code MemoryCalc} class.
     * <p>Initializes an instance of the {@code MemoryCalc} class.</p>
     */
    public MemoryCalc() {
        super(); // Call the constructor of the parent class (Calculator)
        memoryClear();
    }

    /**
     * Displays the current memory value.
     */
    public void displayMemoryValue() {
        if (memoryValue == 0.0) {
            System.out.println("Memory not set");
            return;
        }
        System.out.println("Memory Value: " + getMemoryValue());
    }

    /**
     * Clears the memory value.
     */
    @SuppressWarnings("unused")
    public final void memoryClear() {
        this.memoryValue = 0.0;
    }

    /**
     * Adds the current value to the memory value.
     */
    @SuppressWarnings({"unchecked", "unused"}) // Suppress unchecked cast warning for Number to N as memoryValue is of type double, a valid Number type.
    public <N extends Number> void memoryAdd() {
        if (memoryValue == 0.0) {
            System.out.println("Memory not set");
            return;
        }
        add((N)(Number) this.memoryValue);
    }

    /**
     * Subtracts the current value from the memory value.
     */
    @SuppressWarnings({"unchecked", "unused"}) // Suppress unchecked cast warning for Number to N as memoryValue is of type double, a valid Number type.
    public <N extends Number> void memorySubtract() {
        if (memoryValue == 0.0) {
            System.out.println("Memory not set");
            return;
        }
        subtract((N)(Number) this.memoryValue);
    }

    /**
     * Returns the current memory value.
     * @return a double of the current memory value
     */
    protected double getMemoryValue() {
        return this.memoryValue;
    }

    /**
     * Sets the memory value to the current value.
     */
    @SuppressWarnings("unused") // Suppress unused warning for setMemoryValue method
    public void setMemoryValue() {
        this.memoryValue = this.currentValue;
    }
}
