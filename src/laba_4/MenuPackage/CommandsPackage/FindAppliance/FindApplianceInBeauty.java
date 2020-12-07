package laba_4.MenuPackage.CommandsPackage.FindAppliance;

import laba_4.MenuPackage.CommandsPackage.Command;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.Beauty;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.HomeApplianceElement;

import java.util.ArrayList;

public class FindApplianceInBeauty implements Command {
    private ArrayList<HomeApplianceElement> appliances;
    private FindAppliance findAppliance;
    private ArrayList<HomeApplianceElement> beauty;


    FindApplianceInBeauty(ArrayList<HomeApplianceElement> appliances, FindAppliance findAppliance) {
        this.appliances = appliances;
        this.findAppliance = findAppliance;

        beauty=new ArrayList<>();
        for (HomeApplianceElement it : appliances) {
            if(it instanceof Beauty){
                beauty.add(it);
            }
        }

    }

    public void execute() {
        findAppliance.FindInRange(beauty);
    }
}
