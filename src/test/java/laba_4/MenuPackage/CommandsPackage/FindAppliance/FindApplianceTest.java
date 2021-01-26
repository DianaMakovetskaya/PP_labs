package laba_4.MenuPackage.CommandsPackage.FindAppliance;

import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.HomeApplianceElement;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.Kitchen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindApplianceTest {
    private ArrayList<HomeApplianceElement> allAppliances;
    private ArrayList<HomeApplianceElement> findAppliances;
    private FindAppliance obj;

    @BeforeEach
    void setUp() {
        allAppliances =new ArrayList<>();
        findAppliances =new ArrayList<>();
        obj=new FindAppliance();

        allAppliances.add(new Kitchen("smth1", 3.15, 1000, 3));
        allAppliances.add(new Kitchen("smth2", 2.15, 9000, 10));
        allAppliances.add(new Kitchen("smth3", 4.15, 2000, 5));
        allAppliances.add(new Kitchen("smth4", 10.15, 9000, 7));

    }

    @Test
    void test(){
        findAppliances =obj.find(allAppliances);
        String expected="smth1";
        String actual=findAppliances.get(0).getName();
        assertEquals(expected,actual);
    }

    @AfterEach
    void tearDown() {
        allAppliances.removeAll(allAppliances);
        findAppliances.removeAll(findAppliances);
    }
}