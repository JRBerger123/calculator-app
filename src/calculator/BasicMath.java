package calculator;

public interface BasicMath <N extends Number> {
    N add(N a, N b);
    N subtract(N a, N b);
    N multiply(N a, N b);
    N divide(N a, N b);
}
