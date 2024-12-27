package zerodha_buyandsell;

public class Zerodha {
    public static void main(String[] args) {
        User user1 = new User("Tushar");
        user1.setFunds(300);
        UserSystem userSystem = UserSystem.getInstance();
        userSystem.addUser(user1.getName(), user1);
        Stock stock = new Stock("Trent", 100, Common.EXCHANGE.NSE);
        Order order = new Order(Common.TXN_TYPE.BUY, stock, 3, Common.ORDER_TYPE.MARKET);
        OrderMgr orderMgr = OrderMgr.getInstance();
        orderMgr.placeOrder(user1.getName(), order);

    }
}
