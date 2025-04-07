package calculator;

import java.util.Scanner;

public class Calculator<N extends Number> implements BasicMath<N> {
    double previosValue = 0.0;
    double currentValue = 0.0;
    double inputValue = 0.0;
    char operator = '+';

    public void multiply(N a, N b) {
        return a.doubleValue() * b.doubleValue();
    }

    public void Clear() {
        previosValue = 0.0;
        currentValue = 0.0;
        inputValue = 0.0;
        operator = '+';
    }

    public void subtract(N a, N b) {
        return a.doubleValue() - b.doubleValue();
    }


}