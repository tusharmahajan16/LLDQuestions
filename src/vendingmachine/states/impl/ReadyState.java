package vendingmachine.states.impl;

import vendingmachine.Coin;
import vendingmachine.VendingMachine;
import vendingmachine.states.VendingMachineState;

public class ReadyState implements VendingMachineState {
    private final VendingMachine machine;
    public ReadyState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCash(Coin coin) {
        machine.addCollectedCash(coin);
    }

    @Override
    public void selectProduct(int code) throws Exception {
        throw new Exception("Cannot select product in ready state");
    }

    @Override
    public void cancelTransaction() throws Exception {
        throw new Exception("Cannot cancel transaction in ready state");
    }

    @Override
    public int dispenseChange(int change) throws Exception {
        throw new Exception("Cannot dispense change in ready state");
    }

    @Override
    public void dispenseProduct(int code) throws Exception {
        throw new Exception("Cannot dispense product in ready state");
    }
}
