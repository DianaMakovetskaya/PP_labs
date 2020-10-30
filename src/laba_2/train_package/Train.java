package laba_2.train_package;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Train {
    private String destination;
    private int train_num;
    private String departure_time;
    private int  general_places_num,compartment_places_num,plackart_places_num,luks_places_num;

    public Train(){

    }
    public Train(String destination,int train_num, String departure_time,int general_places_num,int compartment_places_num,int plackart_places_num,int luks_places_num){
        this.destination=destination;
        this.train_num=train_num;
        this.departure_time=departure_time;
        this.general_places_num=general_places_num;
        this.compartment_places_num=compartment_places_num;
        this.plackart_places_num=plackart_places_num;
        this.luks_places_num=luks_places_num;
    }

    public void SetDestination(String destination){
        this.destination=destination;
    };
    public void SetDeparture_time(String departure_time){
        this.departure_time=departure_time;
    };
    public void SetGenaral_places(int general_places_num){
        this.general_places_num=general_places_num;
    };
    public void SetTrain_num(int train_num){
        this.train_num=train_num;
    };
    public void SetLuks_places(int luks_places_num){
        this.luks_places_num=luks_places_num;
    };
    public void SetCompartment_places(int compartment_places_num){
        this.compartment_places_num=compartment_places_num;
    };
    public void SetPlackart_places(int plackart_places_num){
        this.plackart_places_num=plackart_places_num;
    };

    public int GetGenaral_places(){
        return  general_places_num;
    };
    public int GetTrain_num(){
        return train_num;
    };
    public int GetLuks_places(){
        return luks_places_num;
    };
    public int GetCompartment_places(){
        return compartment_places_num;
    };
    public int GetPlackart_places(){
        return plackart_places_num;
    };
    public String GetDestination(){
        return destination;
    };
    public String GetDeparture_time(){
        return departure_time;
    }

    public static void printElements(ArrayList<Train> trains, String destination) {
        System.out.println("|-------------------------------------------------------------------------------------|");
        System.out.println("| Train num    | Destination| Departure | General,  | Plackart | Compartment | Luks   |");
        System.out.println("|              |            | time      | places    | places   | places      | places |");
        System.out.println("|-------------------------------------------------------------------------------------|");

        for (Train temporaryObj : trains) {
            if (temporaryObj.destination.equals(destination)) {
                System.out.printf("| %-12d | %-10s | %-9s | %-9d | %-8d | %-11d | %-6d |\n", temporaryObj.train_num,
                        temporaryObj.destination,
                        temporaryObj.departure_time,
                        temporaryObj.general_places_num,
                        temporaryObj.plackart_places_num,
                        temporaryObj.compartment_places_num,
                        temporaryObj.luks_places_num);
            }
        }

        System.out.println("----------------------------------------------------------------------------------------");
    }

    public static void printElements(ArrayList<Train> trains, String destination,String departure_time) {
        System.out.println("|-------------------------------------------------------------------------------------|");
        System.out.println("| Train num    | Destination| Departure | General,  | Plackart | Compartment | Luks   |");
        System.out.println("|              |            | time      | places    | places   | places      | places |");
        System.out.println("|-------------------------------------------------------------------------------------|");

        for (Train temporaryObj : trains) {
            if (temporaryObj.destination.equals(destination)) {

                try {
                    DateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                    Date format1 = sdf.parse(departure_time);
                    Date format2 = sdf.parse(temporaryObj.departure_time);
                    sdf.format(format1);
                    sdf.format(format2);
                    if(format2.after(format1)){
                        System.out.printf("| %-12d | %-10s | %-9s | %-9d | %-8d | %-11d | %-6d |\n", temporaryObj.train_num,
                                temporaryObj.destination,
                                temporaryObj.departure_time,
                                temporaryObj.general_places_num,
                                temporaryObj.plackart_places_num,
                                temporaryObj.compartment_places_num,
                                temporaryObj.luks_places_num);
                    }
                }catch (Exception e){

                }


            }
        }

        System.out.println("----------------------------------------------------------------------------------------");
    }

    public static void printElements(ArrayList<Train> trains, String destination,int general_places_num) {
        System.out.println("|-------------------------------------------------------------------------------------|");
        System.out.println("| Train num    | Destination| Departure | General,  | Plackart | Compartment | Luks   |");
        System.out.println("|              |            | time      | places    | places   | places      | places |");
        System.out.println("|-------------------------------------------------------------------------------------|");

        for (Train temporaryObj : trains) {
            if (temporaryObj.destination.equals(destination)&&temporaryObj.general_places_num==general_places_num) {
                System.out.printf("| %-12d | %-10s | %-9s | %-9d | %-8d | %-11d | %-6d |\n", temporaryObj.train_num,
                        temporaryObj.destination,
                        temporaryObj.departure_time,
                        temporaryObj.general_places_num,
                        temporaryObj.plackart_places_num,
                        temporaryObj.compartment_places_num,
                        temporaryObj.luks_places_num);
            }
        }

        System.out.println("----------------------------------------------------------------------------------------");
    }
}
