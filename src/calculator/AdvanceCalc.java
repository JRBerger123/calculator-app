package calculator;

    public abstract class AdvanceCalc<N extends Number> implements AdvanceMath<N> extends MemoryCalc {
        int precision = 0;


        AdvanceCalc(){
        }

        /**
         * square roots the input value.
         */
        @Override
        void sqrt(){

        }

        /**
         *  Uses input value as an exponent value.
         * @param a is the exponent
         */
        @Override
        void pow(N a){



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
        public void updateDisplay() {
            System.out.println(previousValue + " " + operator + " " + inputValue + " = " + currentValue);
        }

    }
