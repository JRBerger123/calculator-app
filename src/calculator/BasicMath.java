package calculator;

/**
 * The {@code BasicMath} interface defines basic mathematical operations.
 * It is a generic interface that can work with any subclass of {@code Number}.
 * <p>
 * The {@code BasicMath} interface defines the following methods:
 * <ul>
 *      <li>void add(N)</li>
 *      <li>void subtract(N)</li>
 *      <li>void multiply(N)</li>
 *      <li>void divide(N)</li>
 * </ul>
 *
 * @param <N> the type of number (e.g., Integer, Double) that this interface will work with
 * 
 * @author Brandon Berger, ...
 * @version 1.0
 * @since 2025.04.07
 * @see <a href="https://github.com/JRBerger123/Calculator-App">GitHub Repository</a>
 * @see <a href="https://github.com/JRBerger123">Brandon Berger's GitHub</a>
 */
public interface BasicMath <N extends Number> {
    /**
     * Adds the input value to the previous value.
     * @param a the input value to be added
     */
    void add(N a);

    /**
     * Subtracts the input value from the previous value.
     * @param a the input value to be subtracted
     */
    void subtract(N a);

    /**
     * Multiplies the input value with the previous value.
     * @param a the input value to be multiplied
     */
    void multiply(N a);

    /**
     * Divides the previous value by the input value.
     * @param a the input value to be divided
     */
    void divide(N a);
}
