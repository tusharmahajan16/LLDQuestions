package zerodha_buyandsell;

public class OrderMgr {
    private static OrderMgr instance;
    OrderValidator orderValidator;

    private OrderMgr() {
        orderValidator = new OrderValidator();
    }

    public static OrderMgr getInstance() {
        if (instance == null) {
            synchronized (OrderMgr.class) {
                if (instance == null) {
                    instance = new OrderMgr();
                }
            }
        }
        return instance;
    }

    public void placeOrder(String userId, Order order) {
        if (orderValidator.validateOrder(userId, order)) {
            ExchangeConnector connector = new ExchangeConnector();
            if (connector.sendOrderToExchange(order)) {
                System.out.println("Order Placed Successfully");
            } else {
                System.out.println("Failed to send order to exchange");
            }
        } else {
            if (order.getTransactionType().equals(Common.TXN_TYPE.BUY)) {
                System.out.println("User don't have enough Funds");
            } else {
                System.out.println("User don't have enough Stocks of " + order.getStock().getName() + " to sell");
            }
        }
    }
}
