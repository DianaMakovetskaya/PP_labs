package laba_4.MenuPackage.CommandsPackage.SortPackage;

import laba_4.MenuPackage.CommandsPackage.Command;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.HomeApplianceElement;
import laba_4.MenuPackage.CommandsPackage.PlugIn.PlugIn;

import java.util.ArrayList;

public class SortMenu implements Command {
    private ArrayList<HomeApplianceElement> appliances;
    private Sort sort;
    public SortMenu(ArrayList<HomeApplianceElement> appliances) {
        sort =  new Sort();

        this.appliances = appliances;
    }
    public void execute(){sort.openSort(appliances);}
}
