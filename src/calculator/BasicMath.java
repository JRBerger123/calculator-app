package calculator;

public interface BasicMath <N extends Number> {
    void add(N a);
    void subtract(N a);
    void multiply(N a);
    void divide(N a);
}
