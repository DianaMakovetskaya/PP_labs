package laba_4.MenuPackage.CommandsPackage.FindAppliance;

import laba_4.MenuPackage.CommandsPackage.Command;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.HomeApplianceElement;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.Kitchen;

import java.util.ArrayList;

public class FindApplianceMenu implements Command {
    private ArrayList<HomeApplianceElement> appliances;
    private FindAppliance findAppliance;

    public  FindApplianceMenu(ArrayList<HomeApplianceElement> appliances){
        findAppliance=new FindAppliance();
        this.appliances=appliances;
    }



    public void execute(){
        findAppliance.openFindEquipment(appliances);
    }


}
