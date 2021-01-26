package laba_4.MenuPackage.CommandsPackage.FindAppliance;

import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.Bathroom;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.Beauty;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.HomeApplianceElement;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.Kitchen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FindApplianceInKithenTest {

    private ArrayList<HomeApplianceElement> appliances;
    private ArrayList<HomeApplianceElement> actual;
    private ArrayList<HomeApplianceElement> expected;


    private FindApplianceInKithen obj;
    private FindAppliance findAppliance;

    @BeforeEach
    void setUp() {
        appliances=new ArrayList<>();
        actual=new ArrayList<>();
        expected=new ArrayList<>();
        findAppliance = new FindAppliance();
        obj=new FindApplianceInKithen(appliances,findAppliance);

        appliances.add(new Kitchen("smth1", 1.1, 1000, 1));
        appliances.add(new Bathroom("smth2", 2.1, 2000, 2));
        appliances.add(new Beauty("smth3", 3.1, 3000, 3));
        appliances.add(new Bathroom("smth4", 4.1, 4000, 4));
        appliances.add(new Kitchen("smth5", 5.1, 5000, 5));

        expected.add(new Kitchen("smth1", 1.1, 1000, 1));
        expected.add(new Kitchen("smth5", 5.1, 5000, 5));
    }

    @AfterEach
    void tearDown() {
        appliances.removeAll(appliances);
        actual.removeAll(actual);
        expected.removeAll(expected);
    }

    @Test
    void makeKitchenList() {
        actual=obj.makeKitchenList(appliances);
        assertEquals(expected.get(1).getName(),actual.get(1).getName());
    }
}