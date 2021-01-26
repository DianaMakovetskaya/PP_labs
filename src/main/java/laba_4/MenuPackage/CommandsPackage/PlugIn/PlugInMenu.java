package laba_4.MenuPackage.CommandsPackage.PlugIn;

import laba_4.MenuPackage.CommandsPackage.Command;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.HomeApplianceElement;

import java.util.ArrayList;

public class PlugInMenu implements Command {
    private ArrayList<HomeApplianceElement> appliances;
    private PlugIn plugIn;
    public PlugInMenu(ArrayList<HomeApplianceElement> appliances) {
        plugIn =  new PlugIn();//Receiver

        this.appliances = appliances;
    }

    public void execute(){plugIn.openPlugIn(appliances);}//викликається пвений метод
}
