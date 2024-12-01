package vendingmachine.states.impl;

import vendingmachine.Coin;
import vendingmachine.Item;
import vendingmachine.VendingMachine;
import vendingmachine.states.VendingMachineState;

public class SelectState implements VendingMachineState {
    private final VendingMachine machine;
    public SelectState(VendingMachine machine,int code) throws Exception {
        this.machine = machine;
        selectProduct(code);
    }

    @Override
    public void insertCash(Coin coin) throws Exception {
        throw new Exception("Cannot insert cash in select product state");
    }

    @Override
    public void selectProduct(int code) throws Exception {
        Item item = machine.getInventory().getItem(code);
        if (item != null) {
            if(item.getPrice()<= machine.getCollectedCash())
            {
                int change = item.getPrice()-machine.getCollectedCash();
                machine.setState(new DispenseState(machine,code,change));
            }
            else {
                System.out.println("You have not enough money to collect this item");
                cancelTransaction();
                throw new Exception("Insufficient Money to Buy Product");
            }
        }
        else {
            cancelTransaction();
            throw new Exception("Item not found");
        }
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Cancel transaction refunding full money");
        machine.setState(new ReadyState(machine));
        machine.setCollectedCash(0);
    }

    @Override
    public int dispenseChange(int change) throws Exception {
        throw new Exception("Cannot dispense change in dispense product state");
    }

    @Override
    public void dispenseProduct(int code) throws Exception {
        throw new Exception("Cannot dispense product in select product state");
    }
}
