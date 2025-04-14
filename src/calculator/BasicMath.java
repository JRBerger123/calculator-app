package calculator;

/**
 * The {@link BasicMath} interface defines basic mathematical operations.
 * It is a generic interface that can work with any subclass of {@code Number}.
 * <p>
 * The {@link BasicMath} interface defines the following methods:
 * <ul>
 *      <li>{@link #add(N)} - defines a method for adding a new number to a previous double field in the {@link Calculator} class</li>
 *      <li>{@link #subtract(N)} - defines a method for subtracting a new number from a previous double field in the {@link Calculator} class</li>
 *      <li>{@link #multiply(N)} - defines a method for multiplying a new number with a previous double field in the {@link Calculator} class</li>
 *      <li>{@link #divide(N)} - defines a method for dividing a new number by a previous double field in the {@link Calculator} class</li>
 * </ul>
 * </p>
 * 
 * @author Brandon Berger, Michahel Szigethy
 * @version 1.0
 * @since 2025.04.07
 * @see <a href="https://github.com/JRBerger123/Calculator-App">GitHub Repository</a>
 * @see <a href="https://github.com/JRBerger123">Brandon Berger's GitHub</a>
 * @see <a href="https://github.com/Miz-Bl">Micahel Szigethy's GitHub</a>
 */
public interface BasicMath {
    /**
     * Adds the input value to the previous value.
     * @param a the input value to be added
     * @param <N> N is the type of number (e.g., Integer, Double) that this method will work with
     */
    <N extends Number> void add(N a);

    /**
     * Subtracts the input value from the previous value.
     * @param a the input value to be subtracted
     * @param <N> N is the type of number (e.g., Integer, Double) that this method will work with
     */
    <N extends Number> void subtract(N a);

    /**
     * Multiplies the input value with the previous value.
     * @param a the input value to be multiplied
     * @param <N> N is the type of number (e.g., Integer, Double) that this method will work with
     */
    <N extends Number> void multiply(N a);

    /**
     * Divides the previous value by the input value.
     * @param a the input value to be divided
     * @param <N> N is the type of number (e.g., Integer, Double) that this method will work with
     */
    <N extends Number> void divide(N a);
}
