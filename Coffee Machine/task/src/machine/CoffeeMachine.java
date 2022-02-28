package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);

    // metode i propertiji za kasnije
    static int waterRemaining;
    static int milkRemaining;
    static int beansRemaining;
    static int cupsRemaining;
    static int cashCollected;


    // ovo ce sve ic u klasu coffeeType il nes da pojednostavnim fill i buy opcije
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


    static String takeMenuChoice() {
        System.out.println("\nWrite action (buy, fill, take, remaining, exit): ");
        return scanner.nextLine();
    }

    static void init() {
        waterRemaining = 400;
        milkRemaining = 540;
        beansRemaining = 120;
        cupsRemaining = 9;
        cashCollected = 550;
    }

    static void showReserves() {
        System.out.println("The coffee machine has:\n" +
                waterRemaining + " ml of water\n" +
                milkRemaining + " ml of milk\n" +
                beansRemaining + " g of coffee beans\n" +
                cupsRemaining + " disposable cups\n" +
                "$" + cashCollected + " of money");

    }

    static void buy() {
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

    static void fill() {
        System.out.println("Write how many ml of water you want to add: ");
        waterRemaining = waterRemaining + scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milkRemaining = milkRemaining + scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        beansRemaining = beansRemaining + scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        cupsRemaining = cupsRemaining + scanner.nextInt();
    }

    static void take() {
        System.out.println("I gave you $" + cashCollected);
        cashCollected = 0;
    }

    static void machineLoop() {
        String choice;
        do {
            choice = takeMenuChoice();
            if (choice.equals("buy")) buy();
            else if (choice.equals("fill")) fill();
            else if (choice.equals("take")) take();
            else if (choice.equals("remaining")) showReserves();
        /* else {
           invalid input message
        } */
        }
        while (!choice.equals("exit"));

    }

    public static void main(String[] args) {

        init();
        machineLoop();

    }

}