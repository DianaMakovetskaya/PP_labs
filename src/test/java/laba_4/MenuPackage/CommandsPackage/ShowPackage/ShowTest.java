package laba_4.MenuPackage.CommandsPackage.ShowPackage;

import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.Bathroom;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.Beauty;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.HomeApplianceElement;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.Kitchen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ShowTest {
    ArrayList<HomeApplianceElement> list;
    Show show;

    @BeforeEach
    void setUp() {
        show=new Show();
        list=new ArrayList<>();
        list.add(new Kitchen("smth1", 3.15, 1000, 3));
        list.add(new Beauty("smth3", 4.15, 2000, 5));
        list.add(new Bathroom("smth2", 2.15, 9000, 10));
        list.add(new Kitchen("smth4", 10.15, 11000, 7));
    }

    @AfterEach
    void tearDown() {
        list.removeAll(list);
    }

    @Test
    void openShow() {
        show.openShow(list);
    }
}