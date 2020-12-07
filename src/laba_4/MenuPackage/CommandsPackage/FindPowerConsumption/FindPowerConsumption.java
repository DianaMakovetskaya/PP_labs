package laba_4.MenuPackage.CommandsPackage.FindPowerConsumption;

import laba_4.MenuPackage.CommandsPackage.Command;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.HomeApplianceElement;
import laba_4.MenuPackage.CommandsPackage.ShowPackage.ShowMenu;
import laba_4.MenuPackage.Menu.Remote;

import java.util.ArrayList;
import java.util.Scanner;

public class FindPowerConsumption {
    private Remote remote = new Remote();
    private Command showMenu;

    public void openFindPower(ArrayList<HomeApplianceElement> appliances) {
        showMenu=new ShowMenu(appliances);

        int res=0;
        System.out.println("Do you want to know power consumption of one el or all? ");
        System.out.println("1- one");
        System.out.println("2- all");
        Scanner in=new Scanner(System.in);
        int choose=in.nextInt();
        switch (choose){
            case 1:
                remote.setCommand(showMenu);
                remote.commandExecute();
                System.out.print("Your choose: ");
                int num=in.nextInt();
                System.out.print("Power consumption: ");
                System.out.println(appliances.get(num-1).getPower()*appliances.get(num-1).getTime());
                break;
            case 2:
                for (HomeApplianceElement it:appliances){
                    res +=it.getPower()* it.getTime();
                }
                if(res==0){
                    System.out.println("Включіть деякі електроприлади в розетку.");
                    return;
                }
                System.out.println("Power consumption:"+res);
                break;
            default:break;
        }

    }

}
