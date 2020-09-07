package converter;

/**
 * class Coin implement ICalculate Interface
 * @author galit ladani
 * @version 1.0
 */


public abstract class Coin implements ICalculate {

    /**
     *  an abstract method
     * @return double value.
     */
    public abstract double getValue();

    /**
     * method frome Interface ICalculate get double
     * @param value
     * @return double value
     */
    public double calculate(double value) {
        return 0;
    }


}


