package vendingmachine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to the Vending Machine!");
        VendingMachineShop vendingMachineShop = new VendingMachineShop();
        VendingMachine vendingMachine = vendingMachineShop.getMachine();

        Scanner scanner = new Scanner(System.in);

        // Welcome message
        System.out.println("Available coins: PENNY (1), NICKEL (5), DIME (10), QUARTER (25)");
        while (true) {
            // Coin insertion
            while (true) {
                System.out.println("\nPlease enter a coin (Penny, Nickle, Dime, Quarter) or 'done' to stop inserting coins:");
                String coinInput = scanner.nextLine().trim().toUpperCase();

                if (coinInput.equals("DONE")) {
                    break;  // Stop the coin insertion process
                }

                Coin coin = null;

                switch (coinInput.toUpperCase()) {
                    case "PENNY":
                        coin = Coin.PENNY;
                        break;
                    case "NICKLE":
                        coin = Coin.NICKLE;
                        break;
                    case "DIME":
                        coin = Coin.DIME;
                        break;
                    case "QUARTER":
                        coin = Coin.QUARTER;
                        break;
                    default:
                        System.out.println("Invalid coin! Please enter Penny, Nickel, Dime, or Quarter.");
                        continue;
                }

                // Add the selected coin to the vending machine
                vendingMachine.addCollectedCash(coin);
                System.out.println(STR."You inserted: \{coin} | Current total: \{vendingMachine.getCollectedCash()}");
            }

            // Product selection
            System.out.println("\nPlease select a product by code from Displayed Inventory or 'exit' to quit:");
            String productInput = scanner.nextLine().trim();
            if (productInput.equalsIgnoreCase("EXIT")) {
                break;
            }

            try {
                int code = Integer.parseInt(productInput);
                vendingMachine.selectProduct(code);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
            vendingMachineShop.displayVendingMachine();
        }
        scanner.close();
        System.out.println("Thank you for using the vending machine. Goodbye!");
    }
}
