package zerodha_buyandsell;

public class Order {
    Common.TXN_TYPE transactionType;
    Stock stock;
    int quantity;
    double totalPrice;
    Common.ORDER_TYPE orderType;

    Order(Common.TXN_TYPE transactionType, Stock stock, int quantity, Common.ORDER_TYPE orderType) {
        this.transactionType = transactionType;
        this.stock = stock;
        this.quantity = quantity;
        this.orderType = orderType;
        this.totalPrice = stock.getPrice() * quantity;
    }

    public Common.TXN_TYPE getTransactionType() {
        return transactionType;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    public Stock getStock() {
        return stock;
    }

    public int getQuantity() {
        return quantity;
    }
}

