package laba_4.MenuPackage.CommandsPackage.FindPowerConsumption;

import laba_4.MainPackage.Main;
import laba_4.MenuPackage.CommandsPackage.Command;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.HomeApplianceElement;
import laba_4.MenuPackage.CommandsPackage.ShowPackage.ShowMenu;
import laba_4.MenuPackage.Menu.Remote;

import java.util.ArrayList;
import java.util.Scanner;

public class FindPowerConsumption {

    private Remote remote = new Remote();
    private Command showMenu;
    private ArrayList<HomeApplianceElement> appliances;

    public void openFindPower(ArrayList<HomeApplianceElement> appliances) {
        Main.LOGGER.info("Finding power consumption...");

        showMenu=new ShowMenu(appliances);
        this.appliances=appliances;
        int res=0;

        System.out.println("Do you want to know power consumption of one el or all? ");
        System.out.println("1- one");
        System.out.println("2- all");

        Scanner in=new Scanner(System.in);
        int choose=in.nextInt();

        switch (choose){
            case 1:
                //виводимо всі прилади
                remote.setCommand(showMenu);
                remote.commandExecute();

                //вибираємо певний прилад
                System.out.print("Your choose: ");
                int num=in.nextInt();
                System.out.print("Power consumption: ");
                //обраховуємо споживану електроенергію
                //System.out.println(appliances.get(num-1).getPower()*appliances.get(num-1).getTime());

                System.out.println((int)calculateForOne(num,appliances));
                break;

            case 2:
                //обраховуємо споживану електроенергію для всіх елементів
//                for (HomeApplianceElement it:appliances){
//                    res +=it.getPower()* it.getTime();
//                }
                res=calculateForAll(appliances);

                if(res==0){
                    System.out.println("Включіть деякі електроприлади в розетку.");
                    return;
                }

                System.out.println("Power consumption:"+res);
                break;

            default:break;
        }

    }

    public double calculateForOne(int num,ArrayList<HomeApplianceElement> arrayList){
       return arrayList.get(num-1).getPower()*arrayList.get(num-1).getTime();
    }

    public int calculateForAll(ArrayList<HomeApplianceElement> arrayList){
        int res=0;

        for (HomeApplianceElement it:arrayList) {
            res += it.getPower() * it.getTime();
        }
        return res;
    }


}
