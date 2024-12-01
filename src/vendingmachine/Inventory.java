package vendingmachine;

import java.util.HashMap;

public class Inventory {
    private HashMap<Integer, ItemShelf> shelves;
    int shelfCount = 0;

    public Inventory(int shelfCount) {
        shelves = new HashMap<>();
        this.shelfCount = shelfCount;
        initialiseInventory();
    }

    public void initialiseInventory() {
        int startCode = 101;
        for (int i = 0; i < shelfCount; i++) {
            ItemShelf itemShelf = new ItemShelf();
            itemShelf.setQuantity(0);
            shelves.put(startCode, itemShelf);
            startCode++;
        }
    }

    public void addItemInShelf(Item item, int code, int quantity) throws Exception {
            if (shelves.containsKey(code)) {
                ItemShelf itemShelf = shelves.get(code);
                if (itemShelf.isSoldOut()) {
                    itemShelf.setItem(item);
                    itemShelf.setQuantity(quantity);
                    shelves.put(code, itemShelf);
                } else {
                    throw new Exception("Shelf is not empty, new items cannot be added");
                }
            }
    }

    public Item getItem(int code) {
        if(shelves.containsKey(code) && !shelves.get(code).isSoldOut()) {
            return shelves.get(code).getItem();
        }
        return null;
    }

    public void dispenseItem(int code) {
        if(shelves.containsKey(code) && !shelves.get(code).isSoldOut()) {
            shelves.get(code).setQuantity(shelves.get(code).getQuantity() - 1);
        }

    }

    public HashMap<Integer, ItemShelf> getItemShelves() {
        return shelves;
    }
}

