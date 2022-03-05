package machine;

import java.util.Scanner;

public class CoffeeMachine {
//    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        TheMachine machine = new TheMachine();

        machine.init();
        machine.machineLoop();

    }

}