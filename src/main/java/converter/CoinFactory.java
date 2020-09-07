package converter;

/**
 * class CoinFactory
 * @author galit ladani
 * @version 1.0
 */

public class CoinFactory {
    /**
     * method get coins instances (usd, ils, euro) from Coins enum.
     * @param coin
     * @return
     */
    static Coin getCoinInstance(Coins coin) {

        switch (coin) {

            case ILS -> {
                return new ILS();
            }
            case USD -> {
                return new USD();
            }

            case EUR ->{
                return new EUR();
            }

        }
        return null;
    }
}

