package calculator;

/**
        * The {@code AdvanceMath} interface defines basic mathematical operations.
        * It is a generic interface that can work with any subclass of {@code Number}.
        * <p>
        * The {@code AdvanceMath} interface defines the following methods:
        * <ul>
        *      <li>void sqrt()</li>
        *      <li>void pow(N)</li>
        * </ul>
        *
        * @param <N> the type of number (e.g., Integer, Double) that this interface will work with
        *
        * @author Brandon Berger, Michael Szigethy
        * @version 1.0
        * @since 2025.04.07
        * @see <a href="https://github.com/JRBerger123/Calculator-App">GitHub Repository</a>
        * @see <a href="https://github.com/JRBerger123">Brandon Berger's GitHub</a>
        * @see <a href="https://github.com/Miz-Bl">Micahel Szigethy's GitHub</a>
        */
public interface AdvanceMath <N extends Number> {

    /**
     * square roots the input value.
     */
    void sqrt();

    /**
     *  Uses input value as an exponent value.
     * @param a is the exponent
     */
    void pow(N a);
}
