package vendingmachine;

import java.util.HashMap;

public class VendingMachineShop {
    VendingMachine machine;

    public VendingMachineShop() {
        machine = new VendingMachine();
        fillVendingMachine();
        displayVendingMachine();
    }

    public void fillVendingMachine() {
        HashMap<Integer,ItemShelf> shelves = machine.getInventory().getItemShelves();
        for (HashMap.Entry<Integer,ItemShelf> entry : shelves.entrySet()) {
            Item item = new Item();
            if (entry.getKey() < 103) {
                item.setItemType(ItemType.COKE);
                item.setPrice(ItemType.COKE.getPrice());
            }
            if (entry.getKey() >= 103 && entry.getKey() < 106) {
                item.setItemType(ItemType.PEPSI);
                item.setPrice(ItemType.PEPSI.getPrice());
            }
            if (entry.getKey() >= 106 && entry.getKey() <= 110) {
                item.setItemType(ItemType.SODA);
                item.setPrice(ItemType.SODA.getPrice());
            }
            entry.getValue().setItem(item);
            entry.getValue().setQuantity(10);
        }
    }

    public void displayVendingMachine() {
        HashMap<Integer,ItemShelf> shelves = machine.getInventory().getItemShelves();
        for (HashMap.Entry<Integer,ItemShelf> entry: shelves.entrySet()) {
            System.out.println(STR."Item Code: \{entry.getKey()}| Item: \{entry.getValue().getItem().getItemType().name()}| Price: \{entry.getValue().getItem().getPrice()}| Quantity: \{entry.getValue().getQuantity()}");
        }
    }

    public VendingMachine getMachine() {
        return machine;
    }
}
