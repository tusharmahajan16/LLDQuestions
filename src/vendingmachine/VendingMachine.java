package vendingmachine;

import vendingmachine.states.VendingMachineState;
import vendingmachine.states.impl.ReadyState;
import vendingmachine.states.impl.SelectState;

public class VendingMachine {
    private int collectedCash;
    private VendingMachineState state;
    private final Inventory inventory;

    VendingMachine() {
        this.collectedCash = 0;
        this.state = new ReadyState(this);
        inventory = new Inventory(10);
    }

    public void addCollectedCash(Coin coin) {
        this.collectedCash += coin.getValue();
    }
    public int getCollectedCash() {
        return collectedCash;
    }

    public void setCollectedCash(int cash) {
        this.collectedCash = cash;
    }

    void selectProduct(int code) throws Exception {
        this.state = new SelectState(this,code);
    }

    void clickOnCancelButton() throws Exception {
        this.state.cancelTransaction();
    }

    public VendingMachineState getState() {
        return state;
    }

    public void setState(VendingMachineState state) {
        this.state = state;
    }

    public Inventory getInventory() {
        return inventory;
    }


}
