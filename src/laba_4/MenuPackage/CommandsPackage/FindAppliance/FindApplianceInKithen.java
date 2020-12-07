package laba_4.MenuPackage.CommandsPackage.FindAppliance;

import laba_4.MenuPackage.CommandsPackage.Command;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.HomeApplianceElement;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.Kitchen;

import java.util.ArrayList;

public class FindApplianceInKithen implements Command {

    private ArrayList<HomeApplianceElement> appliances;
    private FindAppliance findAppliance;
    private ArrayList<HomeApplianceElement> kitchen;


    FindApplianceInKithen(ArrayList<HomeApplianceElement> appliances, FindAppliance findAppliance) {
        this.appliances = appliances;
        this.findAppliance = findAppliance;

        kitchen=new ArrayList<>();
        for (HomeApplianceElement it : appliances) {
            if(it instanceof Kitchen){
                kitchen.add(it);
            }
        }
    }

    public void execute() {
        findAppliance.FindInRange(kitchen);
    }
}
