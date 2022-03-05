package machine;

import java.util.Scanner;

public class TheMachine {
    private Scanner scanner = new Scanner(System.in);

    private int waterRemaining;
    private int milkRemaining;
    private int beansRemaining;
    private int cupsRemaining;
    private int cashCollected;

    public int getWaterRemaining() {
        return waterRemaining;
    }

    public void setWaterRemaining(int waterRemaining) {
        this.waterRemaining = waterRemaining;
    }

    public int getMilkRemaining() {
        return milkRemaining;
    }

    public void setMilkRemaining(int milkRemaining) {
        this.milkRemaining = milkRemaining;
    }

    public int getBeansRemaining() {
        return beansRemaining;
    }

    public void setBeansRemaining(int beansRemaining) {
        this.beansRemaining = beansRemaining;
    }

    public int getCupsRemaining() {
        return cupsRemaining;
    }

    public void setCupsRemaining(int cupsRemaining) {
        this.cupsRemaining = cupsRemaining;
    }

    public int getCashCollected() {
        return cashCollected;
    }

    public void setCashCollected(int cashCollected) {
        this.cashCollected = cashCollected;
    }

    final static int espWaterNeeded = 250;
    final static int espMilkNeeded = 0;
    final static int espBeansNeeded = 16;
    final static int espCost = 4;

    final static int latteWaterNeeded = 350;
    final static int latteMilkNeeded = 75;
    final static int latteBeansNeeded = 20;
    final static int latteCost = 7;

    final static int capuWaterNeeded = 200;
    final static int capuMilkNeeded = 100;
    final static int capuBeansNeeded = 12;
    final static int capuCost = 6;

    public String takeMenuChoice() {
        System.out.println("\nWrite action (buy, fill, take, remaining, exit): ");
        return scanner.nextLine();

    }

    public void showReserves() {
        System.out.println("The coffee machine has:\n" +
                waterRemaining + " ml of water\n" +
                milkRemaining + " ml of milk\n" +
                beansRemaining + " g of coffee beans\n" +
                cupsRemaining + " disposable cups\n" +
                "$" + cashCollected + " of money");

    }

    public void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String choiceStr = scanner.next();

        if (!choiceStr.equals("back")) {
            int choice = Integer.parseInt(choiceStr);
            boolean hasEnough = true;
            if (choice == 1) {
                if (waterRemaining < espWaterNeeded) {
                    hasEnough = false;
                    System.out.println("Sorry, not enough water!");
                }
                if (milkRemaining < espMilkNeeded) {
                    hasEnough = false;
                    System.out.println("Sorry, not enough milk!");
                }
                if (beansRemaining < espBeansNeeded) {
                    hasEnough = false;
                    System.out.println("Sorry, not enough coffee!");
                }
                if (hasEnough) {
                    waterRemaining = waterRemaining - espWaterNeeded;
                    milkRemaining = milkRemaining - espMilkNeeded;
                    beansRemaining = beansRemaining - espBeansNeeded;
                    cashCollected = cashCollected + espCost;
                }
            }
            if (choice == 2) {
                if (waterRemaining < latteWaterNeeded) {
                    hasEnough = false;
                    System.out.println("Sorry, not enough water!");
                }
                if (milkRemaining < latteMilkNeeded) {
                    hasEnough = false;
                    System.out.println("Sorry, not enough milk!");
                }
                if (beansRemaining < latteBeansNeeded) {
                    hasEnough = false;
                    System.out.println("Sorry, not enough coffee!");
                }
                if (hasEnough) {
                    waterRemaining = waterRemaining - latteWaterNeeded;
                    milkRemaining = milkRemaining - latteMilkNeeded;
                    beansRemaining = beansRemaining - latteBeansNeeded;
                    cashCollected = cashCollected + latteCost;
                }
            }
            if (choice == 3) {
                if (waterRemaining < capuWaterNeeded) {
                    hasEnough = false;
                    System.out.println("Sorry, not enough water!");
                }
                if (milkRemaining < capuMilkNeeded) {
                    hasEnough = false;
                    System.out.println("Sorry, not enough milk!");
                }
                if (beansRemaining < capuBeansNeeded) {
                    hasEnough = false;
                    System.out.println("Sorry, not enough coffee!");
                }
                if (hasEnough) {
                    waterRemaining = waterRemaining - capuWaterNeeded;
                    milkRemaining = milkRemaining - capuMilkNeeded;
                    beansRemaining = beansRemaining - capuBeansNeeded;
                    cashCollected = cashCollected + capuCost;
                }
            }
            if (hasEnough) {
                cupsRemaining = cupsRemaining - 1;
                System.out.println("I have enough resources, making you a coffee!");
            }
        }
    }

    public void fill() {
        System.out.println("Write how many ml of water you want to add: ");
        waterRemaining = waterRemaining + scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milkRemaining = milkRemaining + scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        beansRemaining = beansRemaining + scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        cupsRemaining = cupsRemaining + scanner.nextInt();
    }

    public void take() {
        System.out.println("I gave you $" + cashCollected);
        cashCollected = 0;
    }

    public void machineLoop() {
        String choice;
        do {
            choice = takeMenuChoice();
            switch (choice) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    showReserves();
                    break;
            }
        /* else {
           invalid input message
        } */
        }
        while (!choice.equals("exit"));

    }

    public void init() {
        setWaterRemaining(400);
        setMilkRemaining(540);
        setBeansRemaining(120);
        setCupsRemaining(9);
        setCashCollected(550);
    }

}
