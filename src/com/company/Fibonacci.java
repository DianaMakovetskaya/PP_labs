package com.company;
/**
 * task 4
 * @author Diana Makovetska*/
public  class Fibonacci {
    static private int FirstEl,SecondEl;

    static void SetElements(int first,int second){
        FirstEl=first;
        SecondEl=second;
    }
    int GetFirst(){return FirstEl;}
    int GetSecond(){return SecondEl;}


    /**
     * The method that creates a fibonacci row and then calls BiggestNum method.
     * @param setSize - the amount of fibonacci nums.
     */
    public void FibonacciRow(int setSize)
    {
        int [] fibonacciArr = new int [setSize];

        try
        {
            fibonacciArr[0] = FirstEl;
            fibonacciArr[1] = SecondEl;
            System.out.print(fibonacciArr[0]+" "+fibonacciArr[1]+" ");

            for (int i = 2; i < fibonacciArr.length; i++)
            {
                fibonacciArr[i] = fibonacciArr[i - 1] + fibonacciArr[i - 2];
                System.out.print(fibonacciArr[i] + " ");
            }

            System.out.println();
            BiggestNum(fibonacciArr);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("The biggest odd number is " + SecondEl + ". 100% of odd nums.");
        }
    }

    /**
     * The help method for Fibonacci method. The method finds the biggest even and odd fibonacci num.
     * @param fibonacciArr - the array of fibonacci nums.
     */
    private void BiggestNum(int[] fibonacciArr)
    {
        boolean bigOdd = false, bigEven = false;
        int maxEven = 0, maxOdd = 0;
        int countEven = 0;

        for (int i = fibonacciArr.length - 1; i!=-1; i--)
        {
            if ((fibonacciArr[i] & 1) == 0)
            {

                countEven++;
            }

        }

        double evenPart = ((double) countEven / fibonacciArr.length * 100);

        System.out.println("The percentage is " + evenPart + "% of even nums and " + (100 - evenPart) + "% of odd nums.");
    }



}
