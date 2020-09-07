package converter;

import java.io.Serializable;

/**
 * class USD coin type, extedns class Coin implements Serializable.
 */

public class USD extends Coin implements Serializable{

    /**
     * @param value is value of USD is final.
     */
    private final double value = 3.52;

    @Override
    public double getValue() {
        return value;
    }

    /**
     *method from Interface ICalculate get double
     *@param input
     *@return
     * calculate input*getValue.
     */
    @Override
    public double calculate(double input) {
        return input * getValue();
    }

}

