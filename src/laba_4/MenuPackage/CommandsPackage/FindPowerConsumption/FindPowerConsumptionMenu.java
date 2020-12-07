package laba_4.MenuPackage.CommandsPackage.FindPowerConsumption;

import laba_4.MenuPackage.CommandsPackage.Command;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.HomeApplianceElement;
import laba_4.MenuPackage.CommandsPackage.PlugIn.PlugIn;

import java.util.ArrayList;

public class FindPowerConsumptionMenu implements Command {
    private ArrayList<HomeApplianceElement> appliances;
    private FindPowerConsumption findPower;
    public FindPowerConsumptionMenu(ArrayList<HomeApplianceElement> appliances) {
        findPower =  new FindPowerConsumption();

        this.appliances = appliances;
    }
    public void execute(){findPower.openFindPower(appliances);}
}
