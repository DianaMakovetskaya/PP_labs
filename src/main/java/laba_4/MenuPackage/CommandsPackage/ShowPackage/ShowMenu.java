package laba_4.MenuPackage.CommandsPackage.ShowPackage;

import laba_4.MenuPackage.CommandsPackage.AddElementPackage.AddElement;
import laba_4.MenuPackage.CommandsPackage.Command;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.HomeApplianceElement;

import java.util.ArrayList;

public class ShowMenu implements Command {
    private ArrayList<HomeApplianceElement> appliances;
    private Show show;
    public ShowMenu(ArrayList<HomeApplianceElement> appliances) {
        show =  new Show();

        this.appliances = appliances;
    }

    public void execute() {
        show.openShow(appliances);
    }
}
