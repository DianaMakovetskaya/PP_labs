package laba_4.MenuPackage.CommandsPackage.AddElementPackage;

import laba_4.MenuPackage.CommandsPackage.Command;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.HomeApplianceElement;
import laba_4.MenuPackage.CommandsPackage.SortPackage.Sort;

import java.util.ArrayList;

public class AddElementMenu implements Command {
    private ArrayList<HomeApplianceElement> appliances;
    private AddElement addElement;
    public AddElementMenu(ArrayList<HomeApplianceElement> appliances) {
        addElement =  new AddElement();

        this.appliances = appliances;
    }
    public void execute() {
        addElement.openAddElement(appliances);
    }
}
