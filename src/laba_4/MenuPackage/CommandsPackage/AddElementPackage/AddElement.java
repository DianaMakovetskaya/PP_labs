package laba_4.MenuPackage.CommandsPackage.AddElementPackage;

import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.Bathroom;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.Beauty;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.HomeApplianceElement;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.Kitchen;

import java.util.ArrayList;
import java.util.Scanner;

public class AddElement {
    Scanner in=new Scanner(System.in);
    public void openAddElement(ArrayList<HomeApplianceElement> appliances) {
        String name;

        double weight;
        int power;

        int quality;
        int choice;
        int continueInput=1;
        while(continueInput==1) {
            System.out.println("Enter name");
            name=in.nextLine();
            System.out.println("Enter power");
            power = Integer.parseInt(in.nextLine());
            System.out.println("Enter weight");
            weight = Double.parseDouble(in.nextLine());
            System.out.println("Enter quality");
            quality = Integer.parseInt(in.nextLine());
            System.out.println("Enter choise:" +
                    "                       1-Kitchen" +
                    "                       2-Bathroom" +
                    "                       3-Beauty");
            choice = Integer.parseInt(in.nextLine());



            switch (choice) {
                case 1: {
                    try {
                        appliances.add(new Kitchen(name, weight, power, quality));
                    }catch (Exception e){System.out.println(e);}
                    break;
                }
                case 2: {
                    appliances.add(new Bathroom(name, weight, power, quality));
                    break;
                }
                case 3: {
                    appliances.add(new Beauty(name, weight, power, quality));
                    break;
                }
            }
            System.out.println("Do you want to continue? yes-1/no-0");
            continueInput=Integer.parseInt(in.nextLine())==1? 1:0;
        }
    }
}
