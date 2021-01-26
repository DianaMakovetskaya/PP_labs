package laba_3.Arenas;

import laba_3.battle.Battle;
import laba_3.droids.Droids;

import java.util.ArrayList;

public class Arena3 extends Battle{
    public static void boom(ArrayList<Droids> fightingDroids, int round) {
        if (round % 2 == 0) {// якщо так то рандомно заморожуємо одного гравця, і залежно від того вибираємо хто буде бити
            int random=0 + (int) (Math.random() * 2);
            if(fightingDroids.size()==2){
                fightingDroids.get(random).setIsAbleToMove(false);
                System.out.println(fightingDroids.get(random).getName()+"*FREEEZ*");
            }else{
                fightingDroids.get(random).setIsAbleToMove(false);
                fightingDroids.get(random+3).setIsAbleToMove(false);
                System.out.println(fightingDroids.get(random).getName()+"*FREEEZ*");
                System.out.println(fightingDroids.get(random+3).getName()+"*FREEEZ*");

            }
        }
    }
}
