package laba_2.train_package;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Train {
    private String destination;
    private int trainNum;
    private String departureTime;
    private int  generalPlacesNum,compartmentPlacesNum,plackartPlacesNum,luksPlacesNum;
    public static ArrayList<Train> trains;

    /**
     * constructor without parameters
     */
    public Train(){

    }

    /**
     * constructor with parameters
     */
    public Train(String destination,int trainNum, String departureTime,int generalPlacesNum,int compartmentPlacesNum,int plackartPlacesNum,int luksPlacesNum){
        this.destination=destination;
        this.trainNum=trainNum;
        this.departureTime=departureTime;
        this.generalPlacesNum=generalPlacesNum;
        this.compartmentPlacesNum=compartmentPlacesNum;
        this.plackartPlacesNum=plackartPlacesNum;
        this.luksPlacesNum=luksPlacesNum;
    }

    /**
     *Setters
     */
    public void SetDestination(String destination){
        this.destination=destination;
    };
    public void SetDepartureTime(String departureTime){
        this.departureTime=departureTime;
    };
    public void SetGenaralPlaces(int generalPlacesNum){
        this.generalPlacesNum=generalPlacesNum;
    };
    public void SetTrainNum(int train_num){
        this.trainNum=train_num;
    };
    public void SetLuksPlaces(int luksPlacesNum){
        this.luksPlacesNum=luksPlacesNum;
    };
    public void SetCompartmentPlaces(int compartmentPlacesNum){
        this.compartmentPlacesNum=compartmentPlacesNum;
    };
    public void SetPlackartPlaces(int plackartPlacesNum){
        this.plackartPlacesNum=plackartPlacesNum;
    };
    /**
     *Getters
     */
    public int GetGenaralPlaces(){
        return  generalPlacesNum;
    };
    public int GetTrainNum(){
        return trainNum;
    };
    public int GetLuksPlaces(){
        return luksPlacesNum;
    };
    public int GetCompartmentPlaces(){
        return compartmentPlacesNum;
    };
    public int GetPlackartPlaces(){
        return plackartPlacesNum;
    };
    public String GetDestination(){
        return destination;
    };
    public String GetDepartureTime(){
        return departureTime;
    }
/**
 *list of trains going to a given destination
 * @param destination- specified destination
 * */
    public static void destinationSort(String destination) {
        System.out.println("|-------------------------------------------------------------------------------------|");
        System.out.println("| Train num    | Destination| Departure | General,  | Plackart | Compartment | Luks   |");
        System.out.println("|              |            | time      | places    | places   | places      | places |");
        System.out.println("|-------------------------------------------------------------------------------------|");

        for (Train temporaryObj : trains) {
            if (temporaryObj.destination.equals(destination)) {
                System.out.printf("| %-12d | %-10s | %-9s | %-9d | %-8d | %-11d | %-6d |\n", temporaryObj.trainNum,
                        temporaryObj.destination,
                        temporaryObj.departureTime,
                        temporaryObj.generalPlacesNum,
                        temporaryObj.plackartPlacesNum,
                        temporaryObj.compartmentPlacesNum,
                        temporaryObj.luksPlacesNum);
            }
        }

        System.out.println("----------------------------------------------------------------------------------------");
    }

    /**
     *list of trains that go to a given destination and depart after a given hour
     * @param destination- specified destination
     * @param departureTime- specified departure time
     * */
    public static void destinationAndTimeSort(String destination,String departureTime) {
        System.out.println("|-------------------------------------------------------------------------------------|");
        System.out.println("| Train num    | Destination| Departure | General,  | Plackart | Compartment | Luks   |");
        System.out.println("|              |            | time      | places    | places   | places      | places |");
        System.out.println("|-------------------------------------------------------------------------------------|");

        for (Train temporaryObj : trains) {
            if (temporaryObj.destination.equals(destination)) {

                try {
                    DateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                    Date format1 = sdf.parse(departureTime);
                    Date format2 = sdf.parse(temporaryObj.departureTime);
                    sdf.format(format1);
                    sdf.format(format2);
                    if(format2.after(format1)){
                        System.out.printf("| %-12d | %-10s | %-9s | %-9d | %-8d | %-11d | %-6d |\n", temporaryObj.trainNum,
                                temporaryObj.destination,
                                temporaryObj.departureTime,
                                temporaryObj.generalPlacesNum,
                                temporaryObj.plackartPlacesNum,
                                temporaryObj.compartmentPlacesNum,
                                temporaryObj.luksPlacesNum);
                    }
                }catch (Exception e){

                }


            }
        }

        System.out.println("----------------------------------------------------------------------------------------");
    }
/**
 * a list of trains that depart for a given destination and have common seats.
 * @param destination-specified destination
 * @param generalPlacesNum- specified number of general places*/
    public static void destinationAndPlacesSort(String destination,int generalPlacesNum) {
        System.out.println("|-------------------------------------------------------------------------------------|");
        System.out.println("| Train num    | Destination| Departure | General,  | Plackart | Compartment | Luks   |");
        System.out.println("|              |            | time      | places    | places   | places      | places |");
        System.out.println("|-------------------------------------------------------------------------------------|");

        for (Train temporaryObj : trains) {
            if (temporaryObj.destination.equals(destination)&&temporaryObj.generalPlacesNum==generalPlacesNum) {
                System.out.printf("| %-12d | %-10s | %-9s | %-9d | %-8d | %-11d | %-6d |\n", temporaryObj.trainNum,
                        temporaryObj.destination,
                        temporaryObj.departureTime,
                        temporaryObj.generalPlacesNum,
                        temporaryObj.plackartPlacesNum,
                        temporaryObj.compartmentPlacesNum,
                        temporaryObj.luksPlacesNum);
            }
        }

        System.out.println("----------------------------------------------------------------------------------------");
    }
}
