package laba_4.MenuPackage.CommandsPackage.ShowPackage;

import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.HomeApplianceElement;

import java.util.ArrayList;

public class Show {
    public void openShow(ArrayList<HomeApplianceElement> appliances){
        if(appliances.size() == 0) {
            System.out.println(" Your basket is empty.");
            return;
        }

        for (HomeApplianceElement it : appliances) {
            System.out.println(" +-----------------------------------------------------------------------+");
            System.out.printf(" | %-3d | %-25s | %-12.3f | %-10.3f | %s |\n",
                    it.getQuality(),
                    it.getName(),
                    it.getPower(),
                    it.getWeight(),
                    it.getActive());
        }

        System.out.println(" +----------------------------------------------------------------------------+");
    }
}
