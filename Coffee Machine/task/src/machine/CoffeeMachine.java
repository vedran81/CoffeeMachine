package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Write how many ml of water the coffee machine has:");
        int waterAvail = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milkAvail = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beansAvail = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cupsWanted = scanner.nextInt();

        int waterForCup = 200;
        int milkForCup = 50;
        int beansForCup = 15;

        int cupsByWater = waterAvail / waterForCup;
        int cupsByMilk = milkAvail / milkForCup;
        int cupsByBeans = beansAvail / beansForCup;


        int cupsCanMake = Math.min(cupsByWater, cupsByMilk);
        cupsCanMake = Math.min(cupsCanMake, cupsByBeans);

        if (cupsCanMake >= cupsWanted) {
            int cupsMore = cupsCanMake - cupsWanted;
            System.out.print("Yes, I can make that amount of coffee");
            if (cupsMore > 0) System.out.println(" (and even " + cupsMore + " more than that)");
        }
        else System.out.println("No, I can make only " + cupsCanMake + " cup(s) of coffee");
    }

}