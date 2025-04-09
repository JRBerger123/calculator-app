package calculator;

    public abstract class AdvanceCalc<N extends Number> extends MemoryCalc<N> implements AdvanceMath<N> {
        int precision = 0;


        public AdvanceCalc() {

        }

        /**
         * square roots the input value.
         */
        @Override
        public void sqrt() {
            try {
                if (inputValue.doubleValue() < 0) {
                    System.out.println("Cannot take square root of a negative number.");
                    return;
                }
                currentValue = Math.sqrt(inputValue.doubleValue());
                updateDisplay();
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
            }
            catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        public void setPrecision(int p){
            this.precision = p;
            System.out.println("Precision set to " + precision);
        }

        public void displayMemoryValue(){
            super.diplayMemoryValue();
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
