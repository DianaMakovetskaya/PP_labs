package laba_3.Arenas;

import laba_3.droids.Droids;

import java.util.ArrayList;

public class Arena {
    public static boolean active;

    public void SetActive( boolean status){
        active=status;
    }

    public boolean GetActive(){
        return active;
    }
    public static void boom(ArrayList<Droids> fightingDroids,int round,int randomRound){
        if(active==true){
            int random_number1;
            if(round==randomRound){
                if(fightingDroids.size()==2){
                    random_number1 = 0 + (int) (Math.random() * 2);
                    fightingDroids.get(random_number1).setHealth(0);
                    System.out.println("*BOOM*"+fightingDroids.get(random_number1).getName()+"  DIED(((");
                }else{
                    System.out.println(randomRound);
                    random_number1 = 0 + (int) (Math.random() * 2);
                    fightingDroids.get(random_number1).setHealth(0);
                    fightingDroids.get(random_number1+3).setHealth(0);
                    fightingDroids.get(random_number1).setIsAbleToMove(false);
                    fightingDroids.get(random_number1+3).setIsAbleToMove(false);
                    System.out.println("*BOOM*"+fightingDroids.get(random_number1).getName() + "and "+ fightingDroids.get(random_number1+3).getName() +"  DIED(((");
                }
                active=false;
            }
        }else{
            System.out.println("OOOPSS");
        }
    }
}
