package machine;

import java.util.Scanner;

public class CoffeeMachine {
//    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {


        TheMachine machine = new TheMachine();

        machine.init();
        machine.setWaterRemaining(400);
        machine.setMilkRemaining(540);
        machine.setBeansRemaining(120);
        machine.setCupsRemaining(9);
        machine.setCashCollected(550);

        machine.recipe[0].setName("espresso");
        machine.recipe[0].setWaterNeeded(250);
        machine.recipe[0].setMilkNeeded(0);
        machine.recipe[0].setBeansNeeded(16);
        machine.recipe[0].setCost(4);

        machine.recipe[1].setName("latte");
        machine.recipe[1].setWaterNeeded(350);
        machine.recipe[1].setMilkNeeded(75);
        machine.recipe[1].setBeansNeeded(20);
        machine.recipe[1].setCost(7);

        machine.recipe[2].setName("cappuccino");
        machine.recipe[2].setWaterNeeded(200);
        machine.recipe[2].setMilkNeeded(100);
        machine.recipe[2].setBeansNeeded(12);
        machine.recipe[2].setCost(6);

        machine.machineLoop();

    }

}