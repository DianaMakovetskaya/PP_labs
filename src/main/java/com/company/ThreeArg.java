package com.company;
/**
 * task 3
 * @author Diana Makovetska*/
public class ThreeArg {
    public ThreeArg(String[] args)
    {
        try
        {
            System.out.println("Arguments are: " + args[0] + " " + args[1] + " " + args[2]);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            //System.out.println("Too few arguments!");
        }
    }
}
