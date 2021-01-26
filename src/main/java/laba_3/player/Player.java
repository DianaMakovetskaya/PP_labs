package laba_3.player;

import laba_3.droids.Droids;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String name;
    private static int countOfDroids;

    public final ArrayList<Droids> droidStation = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public Player() {
        try {
            FileReader reader = new FileReader("InfoPlayer.txt");
            BufferedReader br = new BufferedReader(reader);

            String line;
            int value;

            name = br.readLine();

            while((line = br.readLine()) != null ) {
                Droids droid = new Droids();

                droid.setName(line);

                value = Integer.parseInt(br.readLine());
                droid.setHealth(value);

                value = Integer.parseInt(br.readLine());
                droid.setDamage(value);

                value = Integer.parseInt(br.readLine());
                droid.setTypeOfUltimatePower(value);

                droidStation.add(droid);
            }
        } catch (FileNotFoundException e) {
            Scanner in = new Scanner(System.in);

            System.out.print(" Enter your name -> ");
            name = in.nextLine();
        } catch (IOException e) {
            System.out.println("Wrong data input!");
        }

        System.out.println(" Hello " + name + "! Good luck and have fun!");
        System.out.println();
    }

    public static int getCountOfDroids() {
        return countOfDroids;
    }

    public static void increaseCountOfDroids() {
        countOfDroids++;
    }
}
