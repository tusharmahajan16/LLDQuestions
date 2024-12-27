package zerodha_buyandsell;

public class OrderValidator {
    boolean validateOrder(String userId, Order order) {
        UserSystem userSystem = UserSystem.getInstance();
        User user = userSystem.getUser(userId);
        if (order.getTransactionType().name().equals(Common.TXN_TYPE.BUY.name())) {
            return user.getFunds() >= order.getTotalPrice();
        } else {
            Order userStocks = user.getAvailableStocks(order.getStock().getName());
            return userStocks.getQuantity() >= order.getQuantity();
        }
    }
}
