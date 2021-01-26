package laba_4.MenuPackage.CommandsPackage.FindAppliance;

import laba_4.MainPackage.Main;
import laba_4.MenuPackage.CommandsPackage.Command;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.Bathroom;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.Beauty;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.HomeApplianceElement;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.Kitchen;
import laba_4.MenuPackage.Menu.Remote;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class FindAppliance {
    private Command findApplianceInKitchen;
    private Command findApplianceInBathroom;
    private Command findApplianceInBeauty;
    private FindAppliance findAppliance;
    Logger LOGGER;
    private ArrayList<HomeApplianceElement> appliances;


    private Scanner in = new Scanner(System.in);
    private Remote remote = new Remote();

    public void openFindEquipment(ArrayList<HomeApplianceElement> appliances) {
        Main.LOGGER.info("Find appliances...");

        findAppliance = new FindAppliance();
        this.appliances = appliances;
        LOGGER = Logger.getLogger(Main.class.getName());

        findApplianceInBathroom = new FindApplianceInBathroom(appliances, findAppliance);
        findApplianceInBeauty = new FindApplianceInBeauty(appliances, findAppliance);
        findApplianceInKitchen = new FindApplianceInKithen(appliances, findAppliance);

        System.out.println("\n -------- Find Equipment ------- *");
        System.out.println(" 1. Find equipment from kitchen    *");
        System.out.println(" 2. Find equipment from bath       *");
        System.out.println(" 3. Find equipment from beauty     *");
        System.out.println(" 4. Return to menu                 *");

//вибираємо якого типу прилад сортувати
        System.out.print(" Choose number => ");
        int choice;
        try {
            choice = in.nextInt();
        } catch (java.util.InputMismatchException e) {
            Main.sendMail.send(e.toString());
            choice = 0;
            in.next();
        }

        MakeChoice(choice);
    }

    //встановлюємо команду
    private void MakeChoice(int choice) {
        switch (choice) {
            case 1: {
                remote.setCommand(findApplianceInKitchen);
                break;
            }
            case 2: {
                remote.setCommand(findApplianceInBathroom);
                break;
            }
            case 3: {
                remote.setCommand(findApplianceInBeauty);
                break;
            }
            case 4: {
                return;
            }
            default: {
                System.out.println("Wrong number!");
            }
        }

        remote.commandExecute();
    }


    public void FindInRange(ArrayList<HomeApplianceElement> array) {
        ArrayList<HomeApplianceElement> list=find(array);
        for(HomeApplianceElement it: list){
            System.out.println(" +----------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.printf(" | %-25s | %-12.3f | %-10.3f |\n",
                    it.getName(),
                    it.getPower(),
                    it.getWeight());
        }
        //вибираємо за чим шукати
    }

    public ArrayList<HomeApplianceElement> find(ArrayList<HomeApplianceElement> array){
        ArrayList<HomeApplianceElement> newList=new ArrayList<>();
        System.out.println("Find by: 1- power" +
                "                    2- weight" +
                "                    3- quality");
        int choose = in.nextInt();
        //вводимо діапазон
        System.out.print(" Input the power range => ");
        double min;
        double max;

        min = in.nextDouble();
        max = in.nextDouble();

        boolean flag;
        for (HomeApplianceElement it : array) {
            flag = false;
            switch (choose) {
                case 1:
                    if (it.getPower() >= min & it.getPower() <= max) {//шукаємо за power
                        flag = true;
                    }
                    break;
                case 2:
                    if (it.getWeight() >= min & it.getWeight() <= max) {//шукаємо за weight
                        flag = true;
                    }
                    break;
                case 3:
                    if (it.getQuality() >= min & it.getQuality() <= max) { //шукаємо за quality
                        flag = true;
                    }
                    break;
            }
            if (flag==true) {
                newList.add(it);
            }

        }
        return newList;
    }

}



