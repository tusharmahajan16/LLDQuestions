package vendingmachine.states.impl;

import vendingmachine.Coin;
import vendingmachine.VendingMachine;
import vendingmachine.states.VendingMachineState;

public class DispenseState implements VendingMachineState {
    private final VendingMachine machine;
    public DispenseState(VendingMachine machine, int code, int change) {
        this.machine = machine;
        dispenseChange(change);
        dispenseProduct(code);

    }

    @Override
    public void insertCash(Coin coin) throws Exception {
        throw new Exception("Cannot insert cash in dispense product state");
    }

    @Override
    public void selectProduct(int code) throws Exception {
        throw new Exception("Cannot select product in dispense product state");
    }

    @Override
    public void cancelTransaction() throws Exception {
        throw new Exception("Cannot cancel transaction in dispense product state");
    }

    @Override
    public int dispenseChange(int change) {
        System.out.println(STR."Change returned in coin dispense tray\{change}");
        machine.setCollectedCash(0);
        return change;
    }

    @Override
    public void dispenseProduct(int code) {
        System.out.println(STR."Dispense Product :\{machine.getInventory().getItem(code).getItemType().name()}");
        machine.getInventory().dispenseItem(code);
        machine.setState(new ReadyState(machine));
    }
}
