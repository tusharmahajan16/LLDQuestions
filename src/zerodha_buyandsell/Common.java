package zerodha_buyandsell;

public class Common {
    public enum EXCHANGE{
        NSE,
        BSE;
    }

    public enum TXN_TYPE{
        BUY,
        SELL;
    }

    public enum ORDER_TYPE{
        LIMIT,
        MARKET;
    }
}
