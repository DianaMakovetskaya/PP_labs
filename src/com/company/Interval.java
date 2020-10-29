package com.company;
/**
 * task 4
 * @author Diana Makovetska*/
public class Interval {
    private int Start,End;
    private int bigEven = 0, bigOdd = 0;
    /**
     *   @param start - the min num.
     *   @param end - the max num.
     * */
    public Interval(int start,int end){
        this.Start=start;
        this.End=end;
    }
    /**
     * Finds the biggest odd and even num in range of start, end.
     */
    public void odd_and_even()
    {
        int sum = 0;

        System.out.println();

        for (int localEnd = End; localEnd >= Start; localEnd--)
        {
            if ((localEnd & 1) == 0)
            {
                System.out.print(localEnd + " ");
                sum += localEnd;


                if(bigEven == 0)
                {
                    bigEven = localEnd;
                }
            }
        }

        System.out.println();
        System.out.println("The sum of even numbers is - " + sum);

        sum = 0;
        for (int localStart = Start; localStart <= End; localStart++)
        {
            if ((localStart & 1) == 1)
            {
                System.out.print(localStart + " ");
                sum += localStart;
                bigOdd = localStart;
            }
        }

        System.out.println();
        System.out.println("The sum of odd numbers is - " + sum);
        System.out.println("Big even"+" "+bigEven);
        System.out.println("Big odd"+" "+bigOdd);
        Fibonacci.SetElements(bigEven,bigOdd);
    }
}
