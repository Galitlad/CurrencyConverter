package converter;
import java.io.Serializable;
/**
 * class ILS coin type, extedns class Coin implements Serializable.
 */
public class ILS extends Coin implements Serializable{

    /**
     * @param value is value of ILS is final.
     */
    private final double value = 0.28;


    /**
     *  from an abstract method from class Coin
     * @return double value.
     */
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

