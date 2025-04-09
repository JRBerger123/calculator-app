package app;

import calculator.Calculator;

public class TestBench {
    public TestBench() {
        Calculator<Integer> calculator = new Calculator<Integer>() {
            @Override
            public void add(Integer a) {
                super.add(a);
            }

            @Override
            public void subtract(Integer a) {
                super.subtract(a);
            }

            @Override
            public void multiply(Integer a) {
                super.multiply(a);
            }

            @Override
            public void divide(Integer a) {
                if (a != 0) {
                    super.divide(a);
                } else {
                    System.out.println("Cannot divide by zero.");
                }
            }
        };

        // Example usage:
        calculator.add(5);
        System.out.println("After adding 5: " + calculator.currentValue);

        calculator.subtract(2);
        System.out.println("After subtracting 2: " + calculator.currentValue);

        calculator.multiply(2);
        System.out.println("After multiplying by 2: " + calculator.currentValue);

        calculator.divide(2);
        System.out.println("After dividing by 2: " + calculator.currentValue);
    }

    public static void main(String[] args) {
        System.out.println("TestBench is running...");
        new TestBench();
    }
}