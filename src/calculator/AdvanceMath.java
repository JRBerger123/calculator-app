package calculator;

/**
        * The {@link AdvanceMath} interface defines basic mathematical operations.
        * It is a generic interface that can work with any subclass of {@code Number}.
        * <p>
        * The {@link AdvanceMath} interface defines the following methods:
        * <ul>
        *      <li>{@link #sqrt()} - Defines a sqrt method.</li>
        *      <li>{@link #pow(N)} - Defines a pow method.</li>
        * </ul>
        *
        * @author Brandon Berger, Michael Szigethy
        * @version 1.0
        * @since 2025.04.07
        * @see <a href="https://github.com/JRBerger123/Calculator-App">GitHub Repository</a>
        * @see <a href="https://github.com/JRBerger123">Brandon Berger's GitHub</a>
        * @see <a href="https://github.com/Miz-Bl">Micahel Szigethy's GitHub</a>
        */
public interface AdvanceMath {

    /**
     * square roots the input value.
     */
    void sqrt();

    /**
     *  Uses input value as an exponent value.
     * @param a is the exponent
     * @param <N> the type of number (e.g., Integer, Double) that this method will work with
     */
    <N extends Number> void pow(N a);
}
