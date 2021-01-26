package laba_4.MenuPackage.CommandsPackage.AddElementPackage;

import laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage.HomeApplianceElement;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;


import static org.junit.jupiter.api.Assertions.*;

class AddElementTest {
    AddElement addElement;
    ArrayList<HomeApplianceElement> list;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        addElement=new AddElement();
        list=new ArrayList<>();
    }

    @org.junit.jupiter.api.Test
    void openAddElement() {
        addElement.openAddElement(list);
        int expected=1;
        int actual=list.size();
        assertEquals(expected,actual);

    }
    @org.junit.jupiter.api.AfterEach
    void destroy(){
        list.removeAll(list);
    }

}