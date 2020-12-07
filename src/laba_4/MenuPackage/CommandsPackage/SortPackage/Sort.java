package laba_4.MenuPackage.CommandsPackage.SortPackage;

import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.HomeApplianceElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Sort {
    private Scanner in = new Scanner(System.in);
    private ArrayList<HomeApplianceElement> appliances;

    public void openSort(ArrayList<HomeApplianceElement> appliances) {

        System.out.println("\n ------------- Sort ------------- *");
        System.out.println(" 1. Sort by name                  *");
        System.out.println(" 2. Sort by power                 *");
        System.out.println(" 3. Sort by weight                *");
        System.out.println(" 4. Sort by quality               *");
        System.out.println(" 5. Change direction:" +
                (appliances.get(0).getSortPriority() > 0 ? " ascending   *" : " descending  *"));

        System.out.print(" Choose number => ");
        int choice;

        try {
            choice = in.nextInt();
        }
        catch (java.util.InputMismatchException e) {
            choice = 0;
            in.next();
        }

        this.appliances = appliances;
        MakeChoice(choice);
    }

    private void MakeChoice(int choice) {
        switch (choice) {
            case 1: {
                for(HomeApplianceElement it:appliances) {
                    if(it.getSortPriority() > 0) {
                        it.setSortPriority(1);
                    }
                    else {
                        it.setSortPriority(-1);
                    }
                }
                break;
            }
            case 2: {
                for(HomeApplianceElement it:appliances) {
                    if(it.getSortPriority() > 0) {
                        it.setSortPriority(2);
                    }
                    else {
                        it.setSortPriority(-2);
                    }
                }
                break;
            }
            case 3: {
                for(HomeApplianceElement it:appliances) {
                    if(it.getSortPriority() > 0) {
                        it.setSortPriority(3);
                    }
                    else {
                        it.setSortPriority(-3);
                    }
                }
                break;
            }
            case 4: {
                for(HomeApplianceElement it:appliances) {
                    if(it.getSortPriority() > 0) {
                        it.setSortPriority(4);
                    }
                    else {
                        it.setSortPriority(-4);
                    }
                }
                break;
            }
            case 5: {
                for(HomeApplianceElement it:appliances) {
                    it.setSortPriority(it.getSortPriority() * -1);
                }
                break;
            }
            default: {
                System.out.println("Wrong number!");
            }
        }

        if(choice > 0 && choice < 6) {
            Collections.sort(appliances);
        }
    }
}
