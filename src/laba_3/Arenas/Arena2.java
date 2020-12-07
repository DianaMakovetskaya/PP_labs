package laba_3.Arenas;

import laba_3.droids.Droids;

import java.util.ArrayList;

public class Arena2 {
    public static int boom(Droids attacker,int attack, int round){
        if(attack>40 && round%2==0){
            System.out.println(attacker.getName() +" ATTACK -40");
            attack -=40;
        }
        return attack;
    }
}
