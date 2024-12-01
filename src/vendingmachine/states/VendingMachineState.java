package vendingmachine.states;

import vendingmachine.Coin;

public interface VendingMachineState {
     void insertCash(Coin coin) throws Exception;
     void selectProduct(int code) throws Exception;
     void cancelTransaction() throws Exception;
     int dispenseChange(int change) throws Exception;
     void dispenseProduct(int code) throws Exception;
}
