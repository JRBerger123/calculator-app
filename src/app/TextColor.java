package app;

/**
 * The {@link TextColor} enum provides ANSI escape codes for text color formatting in the console.
 * It allows for easy colorization of text output in the terminal.
 * 
 * Available colors include:
 * <ul>
 * <li>BLACK</li>
 * <li>RED</li>
 * <li>GREEN</li>
 * <li>YELLOW</li>
 * <li>BLUE</li>
 * <li>PURPLE</li>
 * <li>CYAN</li>
 * <li>WHITE</li>
 * </ul>
 * 
 * @author Brandon Berger, Michael Szigethy
 * @version 1.0
 * @since 2025.04.08
 * @see <a href="https://github.com/JRBerger123/Calculator-App">GitHub Repository</a>
 * @see <a href="https://github.com/JRBerger123">Brandon Berger's GitHub</a>
 * @see <a href="https://github.com/Miz-Bl">Micahel Szigethy's GitHub</a>
 */
public enum TextColor {
    // Regular colors
    RESET("\u001B[0m"),
    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    PURPLE("\u001B[35m"),
    CYAN("\u001B[36m"),
    WHITE("\u001B[37m");

    /**
     * The ANSI escape code for the text color.
     */
    private final String code;

    /**
     * Constructor for the {@link TextColor} enum.
     * <p>Each enum constant is associated with a specific ANSI escape code.</p>
     * @param code is the ANSI escape code for the text color.
     */
    TextColor(String code) {
        this.code = code;
    }

    /**
     * Returns the ANSI escape code associated with the enum constant.
     * @return the ANSI escape code as a string.
     */
    @Override
    public String toString() {
        return code;
    }

    /**
     * Colorizes the given text with the ANSI escape code of the enum constant.
     * <p>This method wraps the text with the color code and resets it to default after the text.</p>
     * @param text is the text to be colorized.
     * @return the colorized text as a string.
     */
    public String colorize(String text) {
        return this + text + RESET;
    }
}