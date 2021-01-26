package laba_4.MenuPackage.Menu;


import laba_4.MenuPackage.CommandsPackage.AddElementPackage.AddElementMenu;
import laba_4.MenuPackage.CommandsPackage.Command;
import laba_4.MenuPackage.CommandsPackage.FindAppliance.FindApplianceMenu;
import laba_4.MenuPackage.CommandsPackage.FindPowerConsumption.FindPowerConsumptionMenu;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.Bathroom;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.Beauty;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.HomeApplianceElement;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.Kitchen;
import laba_4.MenuPackage.CommandsPackage.PlugIn.PlugInMenu;
import laba_4.MenuPackage.CommandsPackage.ShowPackage.ShowMenu;
import laba_4.MenuPackage.CommandsPackage.SortPackage.SortMenu;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Command findAppliance;
    private Command sortMenu;
    private Command plugIn;
    private Command findPowerConsumption;
    private Command addElementMenu;
    private Command showMenu;
    private ArrayList<HomeApplianceElement> list;

    private Remote remote = new Remote();
    private Reader reader;
    private Scanner in=new Scanner(System.in);

    public Menu() throws NullPointerException {
        String directory = "ApplianceInfo.txt";

        list = new ArrayList<>();
        try {
            reader = new FileReader(directory);
        } catch (FileNotFoundException e) {
            System.out.println(" File error!");
            return;
        }

        findAppliance = new FindApplianceMenu(list);
        sortMenu = new SortMenu(list);
        showMenu=new ShowMenu(list);
        findPowerConsumption = new FindPowerConsumptionMenu(list);
        addElementMenu = new AddElementMenu(list);
        plugIn=new PlugInMenu(list);
    }
    public void Start() {
        int choice;

        InputData();

        do {
            System.out.println("\n ----------- Menu ----------- *");
            System.out.println(" 1. Plug in Appliance           *");
            System.out.println(" 2. Show all Appliance          *");
            System.out.println(" 3. Find Applience              *");
            System.out.println(" 4. Sort                        *");
            System.out.println(" 5. Find power consumption      *");
            System.out.println(" 6. Add appliance to the home   *");
            System.out.println(" 7. Exit                        *");


            System.out.print(" Choose number => ");
            try {
                choice = in.nextInt();
            }
            catch (java.util.InputMismatchException e) {
                choice = 0;
                in.next();
            }

            MakeChoice(choice);
        } while(choice != 7);
    }

    private void MakeChoice(int choice) {
        switch (choice) {
            case 1: {
                remote.setCommand(plugIn);

                break;
            }
            case 2:{
                remote.setCommand(showMenu);
                break;
            }
            case 3: {
                remote.setCommand(findAppliance);
                break;
            }
            case 4: {
                remote.setCommand(sortMenu);
                break;
            }
            case 5: {
                remote.setCommand(findPowerConsumption);
                break;
            }
            case 6: {
                remote.setCommand(addElementMenu);
                break;
            }
            case 7: {
               return;
            }

            default: {
                System.out.println("Wrong number!");
                return;
            }
        }

        if(choice > 0 && choice < 7) {
            remote.commandExecute();
        }

    }

    private void InputData() {
        try {
            BufferedReader br = new BufferedReader(reader);

            String name;

            double weight;
            int power;

            int quality;
            int choice;

            while((name = br.readLine()) != null) {
                power = Integer.parseInt(br.readLine());
                weight = Double.parseDouble(br.readLine());
                quality = Integer.parseInt(br.readLine());
                choice = Integer.parseInt(br.readLine());



                switch (choice) {
                    case 1: {
                        try {
                            list.add(new Kitchen(name, weight, power, quality));
                        }catch (Exception e){System.out.println(e);}
                        break;
                    }
                    case 2: {
                        list.add(new Bathroom(name, weight, power, quality));
                        break;
                    }
                    case 3: {
                        list.add(new Beauty(name, weight, power, quality));
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
