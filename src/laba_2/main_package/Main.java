package laba_2.main_package;

import laba_2.train_package.Train;


import java.util.*;


public class Main {

    private static ArrayList<Train> trains = new ArrayList<Train>();

    public static void main(String[] args) {
        Create_Array();
        Train.printElements(trains,"lviv");
        Train.printElements(trains,"lviv",15);
        Train.printElements(trains,"lviv","12:30:15");

    }

    public static void Create_Array(){
        Scanner in=new Scanner(System.in);
        String line;
        while (true){
            Train obj = new Train();
            System.out.println("Do you want to continue? yes-1/no-0");
            if(Integer.parseInt(in.nextLine())==1){

                System.out.println("Train 1:");
                System.out.print("Enter train_num:");
                obj.SetTrain_num(Integer.parseInt(in.nextLine()));

                System.out.print("Enter destination:");
                obj.SetDestination(in.nextLine());

                System.out.print("Enter departure time:");
                obj.SetDeparture_time(in.nextLine());

                System.out.print("Enter general places:");

                obj.SetGenaral_places(Integer.parseInt(in.nextLine()));


                System.out.print("Enter plackart places:");


                obj.SetPlackart_places(Integer.parseInt(in.nextLine()));


                System.out.print("Enter compartment places:");

                obj.SetCompartment_places(Integer.parseInt(in.nextLine()));


                System.out.print("Enter luks places:");


                obj.SetLuks_places(Integer.parseInt(in.nextLine()));

                trains.add(obj);
            }
            else{
                break;
            }
        }
    }

}
