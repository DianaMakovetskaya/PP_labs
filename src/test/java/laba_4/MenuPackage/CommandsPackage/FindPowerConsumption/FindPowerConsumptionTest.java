package laba_4.MenuPackage.CommandsPackage.FindPowerConsumption;

import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.Beauty;
import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.HomeApplianceElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FindPowerConsumptionTest {
    FindPowerConsumption obj;
    ArrayList<HomeApplianceElement> list;
    @BeforeEach
    void setUp() {
        obj=new FindPowerConsumption();
        list=new ArrayList<>();
        Beauty one=new Beauty("lala",2.14,3000,3);
        //встановили час
        one.setTime(130);
        list.add(one);

        Beauty second=new Beauty("nana",2.14,2000,7);
        second.setTime(330);
        list.add(second);

    }

    @Test
    void calculateForOne() {
        double expected=390000;
        //обраховуємо споживану енергію для одного ел
        double actual=obj.calculateForOne(1,list);
        assertEquals(expected,actual);
    }

    @Test
    void calculateForAll() {
        int expected=130;
        //обраховуємо споживану енергію для всіх ел
        int actual=obj.calculateForAll(list);
        assertEquals(expected,actual);
    }
}