package com.company;

import java.util.Scanner;
/**
 * Task 1
 * @author Diana Makovetska
 * */
public class Main {
    /**
     * The main method
     * @param args - arguments from terminal
     */
    public static void main(String[] args) {
        // write your code here
        int start, end,size;

        System.out.println("Hello world");

        EmptyVariables obj=new EmptyVariables();
        obj.print();

        ThreeArg obj2=new ThreeArg(args);

        Scanner in=new Scanner(System.in);
        System.out.println("Enter interval:");
        start = in.nextInt();
        end = in.nextInt();

        Interval obj3=new Interval(start,end);
        obj3.odd_and_even();
        System.out.println("Enter size of fibonacci row:");
        size=in.nextInt();
        Fibonacci obj4=new Fibonacci();
        obj4.FibonacciRow(size);
    }
}
