package laba_4.MenuPackage.CommandsPackage.PlugIn;

import laba_4.MenuPackage.CommandsPackage.Command;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.HomeApplianceElement;
import laba_4.MenuPackage.CommandsPackage.ShowPackage.ShowMenu;
import laba_4.MenuPackage.Menu.Remote;

import java.util.ArrayList;
import java.util.Scanner;

public class PlugIn {
    private Remote remote = new Remote();
    private Command showMenu;
    public void openPlugIn(ArrayList<HomeApplianceElement> appliances) {
        Scanner in=new Scanner(System.in);
        showMenu=new ShowMenu(appliances);
        int num;
        if(appliances.size() == 0) {
            System.out.println(" Your basket is empty.");
            return;
        }
        System.out.println("Please,choose what to plug in/off(end---0):");
        remote.setCommand(showMenu);
        remote.commandExecute();
        System.out.println("Your choose-->");
        while (true){
            num=in.nextInt();
            if(num==0){return;}
            if(appliances.get(num-1).getActive()){
                appliances.get(num-1).Stop();
            }else{
                appliances.get(num-1).setActive(true);

            }

        }

    }


}
