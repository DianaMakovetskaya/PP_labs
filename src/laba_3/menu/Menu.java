package laba_3.menu;

import laba_3.Arenas.Arena;
import laba_3.Arenas.Arena2;
import laba_3.battle.Battle;
import laba_3.droids.Droids;
import laba_3.player.Player;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private int playerChoice;
    private Player player;
    private Battle battle;

    public Menu() {
        playerChoice = 0;
    }

    public void start() {

        //зчитуємо файл
        player = new Player();

        //вибираємо пункт з меню
        while((playerChoice = menuDisplay()) != 5) {
            System.out.println();
            switch (playerChoice) {
                case 1: {
                    // Start 1vs1 battle
                    battle1vs1Section();
                    break;
                } case 2: {
                    // Start 3vs3 battle
                    battle3vs3Section();
                    break;
                } case 3: {
                    // Get list of droids
                    showDroidsSection();
                    break;
                } case 4: {
                    // Create a Droid
                    createDroidSection();
                    break;
                } default: {
                    System.out.println("Wrong number! Try once more...");
                    System.out.println();
                }
            }
        }
    }

    private int menuDisplay() {
        System.out.println(" *-*-*-*-*-*-*-*-**-*--*-**-*-*-*-*");
        System.out.println(" *                                *");
        System.out.println(" *           Main menu            *");
        System.out.println(" *                                *");
        System.out.println(" *-*-*-*-*-*-*-*-**-*--*-**-*-*-*-*");
        System.out.println(" * 1. Solo battle 1 vs 1          *");
        System.out.println(" * 2. Team battle 3 vs 3          *");
        System.out.println(" * 3. Show Droids                 *");
        System.out.println(" * 4. Create Droid                *");
        System.out.println(" * 5. Exit                        *");
        System.out.println(" *-*-*-*-*-*-*-*-**-*--*-**-*-*-*-*");
        System.out.print(" ------------- Enter a number --> ");

        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    private void battle1vs1Section() {
        if(Player.getCountOfDroids() < 2) {
            System.out.println("You need at least 2 droids to play 1vs1 battle!");
            System.out.println("Create them using 4 button in the Main menu.");
            return;
        }

        System.out.println(" *-*-*-*-*-*-*-*-**-*--*-**-*-*-*-*");
        System.out.println(" *                                *");
        System.out.println(" *         Battle 1 vs 1          *");
        System.out.println(" *                                *");
        System.out.println(" *-*-*-*-*-*-*-*-**-*--*-**-*-*-*-*");
        System.out.println(" * Choose 2 droids to fight solo  *");
        System.out.println(" * battle 1 vs 1 from following   *");
        System.out.println(" * list:                          *");
        System.out.println(" *-*-*-*-*-*-*-*-**-*--*-**-*-*-*-*");

        //виводимо лист дройдів
        for (int i = 0; i < Player.getCountOfDroids(); i++) {
            System.out.println(" * " + (i+1) + ". " + player.droidStation.get(i));
        }


        Scanner in = new Scanner(System.in);


        System.out.print(" ------------- Enter 1 droid  --> ");
        int first = in.nextInt();
        System.out.print(" ------------- Enter 2 droid  --> ");
        int second = in.nextInt();

        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println(" *                                *");
        System.out.println(" *         Choose arena           *");
        System.out.println(" * 1.ISLAND OF STONES             *");
        System.out.println(" * 2.EVIL TOWER                   *");
        System.out.println(" * 3.FREEZING                     *");
        System.out.println(" *-*-*-*-*-*-*-*-**-*--*-**-*-*-*-*");
        System.out.print(" ------------- Enter arena  --> ");
        int chose=in.nextInt();
        switch (chose){
            case 1:
                Battle.ArenaNum=1;
                Arena.active=true;
                break;
            case 2:
                Battle.ArenaNum=2;
                break;

            case 3:
                Battle.ArenaNum=3;
                break;

        }

        System.out.println();

        switch (chose){
            case 1:
                System.out.println("                                                                           ISLAND OF STONES                                                                                                    ");
                System.out.println("[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]");
                break;
            case 2:
                System.out.println("                                                                              EVIL TOWER                                                                                                      ");
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                break;
            case 3:
                System.out.println("                                                                                FREEZING                                                                                                          ");
                System.out.println("***************************************************************************************************************************************************************************************************");
                break;

        }
        //отримуємо зі списку вибарних дройдів
        Droids firstDroid = player.droidStation.get(first - 1);
        Droids secondDroid = player.droidStation.get(second - 1);

        battle = new Battle(firstDroid, secondDroid);
        battle.start1vs1Battle();


    }

    private void battle3vs3Section() {
        if(Player.getCountOfDroids() < 6) {
            System.out.println("You need at least 6 droids to play 1vs1 battle!");
            System.out.println("Create them using 4 button in the Main menu.");
            return;
        }

        System.out.println(" *-*-*-*-*-*-*-*-**-*--*-**-*-*-*-*");
        System.out.println(" *                                *");
        System.out.println(" *         Battle 3 vs 3          *");
        System.out.println(" *                                *");
        System.out.println(" *-*-*-*-*-*-*-*-**-*--*-**-*-*-*-*");
        System.out.println(" * Choose 6 droids to fight solo  *");
        System.out.println(" * battle 1 vs 1 from following   *");
        System.out.println(" * list:                          *");
        System.out.println(" *-*-*-*-*-*-*-*-**-*--*-**-*-*-*-*");
        for (int i = 0; i < Player.getCountOfDroids(); i++) {
            System.out.println(" * " + (i+1) + ". " + player.droidStation.get(i));
        }
        System.out.println(" *-*-*-*-*-*-*-*-**-*--*-**-*-*-*-*");

        Scanner in = new Scanner(System.in);

        System.out.print(" ------------- Enter 1 droid  --> ");
        int first = in.nextInt();
        System.out.print(" ------------- Enter 2 droid  --> ");
        int second = in.nextInt();
        System.out.print(" ------------- Enter 3 droid  --> ");
        int third = in.nextInt();
        System.out.print(" ------------- Enter 4 droid  --> ");
        int forth = in.nextInt();
        System.out.print(" ------------- Enter 5 droid  --> ");
        int fifth = in.nextInt();
        System.out.print(" ------------- Enter 6 droid  --> ");
        int sixth = in.nextInt();

        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println(" *                                *");
        System.out.println(" *         Choose arena           *");
        System.out.println(" * 1.ISLAND OF STONES             *");
        System.out.println(" * 2.EVIL TOWER                   *");
        System.out.println(" * 3.FREEZING                     *");
        System.out.println(" *-*-*-*-*-*-*-*-**-*--*-**-*-*-*-*");
        System.out.print(" ------------- Enter arena  --> ");
        int chose=in.nextInt();
        switch (chose){
            case 1:
                Battle.ArenaNum=1;
                Arena.active=true;
                break;
            case 2:
                Battle.ArenaNum=2;
                break;

            case 3:
                Battle.ArenaNum=3;
                break;

        }

        System.out.println();
        System.out.println();
        Droids firstDroid = player.droidStation.get(first - 1);
        Droids secondDroid = player.droidStation.get(second - 1);
        Droids thirdDroid = player.droidStation.get(third - 1);
        Droids fourthDroid = player.droidStation.get(forth - 1);
        Droids fifthDroid = player.droidStation.get(fifth - 1);
        Droids sixthDroid = player.droidStation.get(sixth - 1);

        battle = new Battle(firstDroid, secondDroid, thirdDroid, fourthDroid, fifthDroid, sixthDroid);
        battle.start3vs3Battle();

    }

    private void showDroidsSection() {
        if(Player.getCountOfDroids() < 1) {
            System.out.println("You don't have droids yet!");
            System.out.println("Create them using 4 button in the Main menu.");
            return;
        }

        System.out.println(" *-*-*-*-*-*-*-*-**-*--*-**-*-*-*-*");
        System.out.println(" *                                *");
        System.out.println(" *          Show Droids           *");
        System.out.println(" *                                *");
        System.out.println(" *-*-*-*-*-*-*-*-**-*--*-**-*-*-*-*");

        for(Droids i:player.droidStation) {
            System.out.println(" * " + i);
        }
        System.out.println();
        System.out.println();
    }
    private void createDroidSection() {
        System.out.println(" *-*-*-*-*-*-*-*-**-*--*-**-*-*-*-*");
        System.out.println(" *                                *");
        System.out.println(" *          Create Droid          *");
        System.out.println(" *                                *");
        System.out.println(" *-*-*-*-*-*-*-*-**-*--*-**-*-*-*-*");
        System.out.println(" * Every droid must have          *");
        System.out.println(" * next attributes:               *");
        System.out.println(" * 1. Name                        *");
        System.out.println(" * 2. Amount of health            *");
        System.out.println(" * 3. Attack damage               *");
        System.out.println(" * 4. Ultimate power              *");
        System.out.println(" *-*-*-*-*-*-*-*-**-*--*-**-*-*-*-*");

        Droids droid = new Droids();

        //зчитуємо інфо inputAttributesForDroid() в і  заносимо в лист droidStation
        inputAttributesForDroid(droid);
        player.droidStation.add(droid);
    }

    private void inputAttributesForDroid(Droids droid) {
        Scanner in = new Scanner(System.in);

        System.out.print(" -------------- Enter the name -> ");
        droid.setName(in.nextLine());

        System.out.print(" -- Enter the amount of health -> ");
        droid.setHealth(in.nextInt());

        System.out.print(" ----- Enter the attack damage -> ");
        droid.setDamage(in.nextInt());

        System.out.println(" *-*-*-*-*-*-*-*-**-*--*-**-*-*-*-*");
        System.out.println(" * Choose one of possible ulties: *");
        System.out.println(" * 1. Critical hit 300%           *");
        System.out.println(" * 2. Heal for 200hp              *");
        System.out.println(" * 3. Accuracy + 50               *");
        System.out.println(" * 4. Evasion + 50                *");
        System.out.println(" * 5. Block 80% of damage         *");
        System.out.println(" * 6. Steal rage to up own damage *");
        System.out.println(" *-*-*-*-*-*-*-*-**-*--*-**-*-*-*-*");
        System.out.print(" ------------- Enter a number --> ");
        droid.setTypeOfUltimatePower(in.nextInt());
        System.out.println();
        System.out.println();
    }


}
