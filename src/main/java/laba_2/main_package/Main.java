package laba_2.main_package;

import laba_2.train_package.Train;


import java.util.*;


public class Main {

    private static ArrayList<Train> trains = new ArrayList<Train>();

    public static void main(String[] args) {
        Create_Array();
        Train.trains=trains;
        Train.destinationSort("lviv");
        Train.destinationAndPlacesSort("lviv",15);
        Train.destinationAndTimeSort("lviv","12:30:15");

    }
/**
 * with this method you can fill in the information
 * */
    public static void Create_Array(){
        Scanner in=new Scanner(System.in);
        String line;
        while (true){
            Train obj = new Train();
            System.out.println("Do you want to continue? yes-1/no-0");
            if(Integer.parseInt(in.nextLine())==1){

                System.out.println("Train 1:");
                System.out.print("Enter train_num:");
                obj.SetTrainNum(Integer.parseInt(in.nextLine()));

                System.out.print("Enter destination:");
                obj.SetDestination(in.nextLine());

                System.out.print("Enter departure time:");
                obj.SetDepartureTime(in.nextLine());

                System.out.print("Enter general places:");

                obj.SetGenaralPlaces(Integer.parseInt(in.nextLine()));


                System.out.print("Enter plackart places:");


                obj.SetPlackartPlaces(Integer.parseInt(in.nextLine()));


                System.out.print("Enter compartment places:");

                obj.SetCompartmentPlaces(Integer.parseInt(in.nextLine()));


                System.out.print("Enter luks places:");


                obj.SetLuksPlaces(Integer.parseInt(in.nextLine()));

                trains.add(obj);
            }
            else{
                break;
            }
        }
    }

}
