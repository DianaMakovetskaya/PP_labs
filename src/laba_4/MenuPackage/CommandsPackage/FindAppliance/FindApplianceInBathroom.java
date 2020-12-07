package laba_4.MenuPackage.CommandsPackage.FindAppliance;

import laba_4.MenuPackage.CommandsPackage.Command;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.Bathroom;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.HomeApplianceElement;

import java.util.ArrayList;

public class FindApplianceInBathroom implements Command {
    private ArrayList<HomeApplianceElement> appliances;
    private FindAppliance findAppliance;
    private ArrayList<HomeApplianceElement> bathroom;


    FindApplianceInBathroom(ArrayList<HomeApplianceElement> appliances, FindAppliance findAppliance) {
        this.appliances = appliances;
        this.findAppliance = findAppliance;

        bathroom=new ArrayList<>();
        for (HomeApplianceElement it : this.appliances) {
            if(it instanceof Bathroom){
                bathroom.add(it);
            }
        }
    }

    public void execute() {
        findAppliance.FindInRange(bathroom);
    }
}
