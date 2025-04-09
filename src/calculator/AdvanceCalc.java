package calculator;

    public abstract class AdvanceCalc<N extends Number> extends MemoryCalc<N> implements AdvanceMath<N> {
        int precision = 0;

        /**
         * Default constructor for the {@code AdvanceCalc} class.
         *
         * <p>Initializes an instance of the {@code AdvanceCalc} class.
         */
        public AdvanceCalc() {

        }

        /**
         * Calculates the square root of the current input value.
         *
         * <p>The method also updates the display of the current state by calling
         * {@link #updateDisplay()} and sets {@code previousValue} to the result.</p>
         *
         * @throws IllegalArgumentException if {@code inputValue} is negative
         */
        @Override
        public void sqrt() {
            try {
                if (inputValue < 0) {
                    System.out.println("Cannot take square root of a negative number.");
                    return;
                }
                this.currentValue = Math.sqrt(inputValue);
                updateDisplay();
                this.previousValue = this.currentValue;
            }
            catch (Exception e) {
                System.out.println("Cannot take square root of a negative number.");
            }
        }

        /**
         *  Uses input value as an exponent value.
         * @param a is the exponent
         */
        @Override
        public void pow(N a){
            try {
                this.currentValue = Math.pow(this.inputValue, a.doubleValue());
                updateDisplay();
                this.previousValue = this.currentValue;
            }
            catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        /**
         * Sets the precision value for calculations.
         *
         * @param p the precision value to be set, as int
         */
        public void setPrecision(int p){
            this.precision = p;
            System.out.println("Precision set to " + precision);
        }

        /**
         * Displays the current value stored in memory.
         *
         * <p>Calls the parent class's {@code displayMemoryValue()}
         * method to handle the memory display functionality.</p>
         */
        @Override
        public void displayMemoryValue() {
            super.displayMemoryValue();
        }

        /**
         * Updates the display with the current operation and result.
         * This method is called after each operation to show the result.
         */
        @Override
        public void updateDisplay() {
            String format = "%." + precision + "f";

            String formattedPreviousValue = String.format(format, previousValue);
            String formattedCurrentValue = String.format(format, currentValue);
            String formattedInputValue = String.format(format, inputValue);

            System.out.println(formattedPreviousValue + " " + operator + " " + formattedInputValue + " = " + formattedCurrentValue);
        }
    }
