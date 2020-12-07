package laba_3.IsPossibleToContinue;

import laba_3.battle.Battle;
import laba_3.droids.Droids;

import java.util.ArrayList;

public class IsPossibleToContinue {
    public boolean isPossibleToContinueFight(ArrayList<Droids> fightingDroids) {
        int countOfDeadDroids = 0;
        int arrayIterator = 0;
        int teamLastMember;
        int wholeTeamDead;
        //перевіряє учасника/учасників 1 команди
        for(teamLastMember = fightingDroids.size() / 2, wholeTeamDead = teamLastMember; arrayIterator < teamLastMember; arrayIterator++) {
            if(fightingDroids.get(arrayIterator).getHealth() <= 0) {
                countOfDeadDroids++;
            }
        }
        //якщо всі вмерли, то програвша команда -1, виходимо з ф-її. Якщо живі, то перевіряємо з другої команди
        if(countOfDeadDroids == wholeTeamDead){
            Battle.enlimatedTeam = 1;
            return false;
        }
        //перевіряємо з другої команди
        for (teamLastMember *= 2, countOfDeadDroids = 0; arrayIterator < teamLastMember; arrayIterator++) {
            if(fightingDroids.get(arrayIterator).getHealth() <= 0) {
                countOfDeadDroids++;
            }
        }

        //якщо з другої команди всі вмерли, то програвша команда-2
        if(countOfDeadDroids == wholeTeamDead){
            Battle.enlimatedTeam = 2;
            return false;
        }

        return true;
    }

    public boolean canTeamMakeTurn(int teamNum,ArrayList<Droids> fightingDroids) {//перевярє чи команда може битись
        int countOfUnableDroids = 0;
        int teamFirstMember = 0;
        int teamLastMember = fightingDroids.size() / 2;

        //якщо це є 2 команда, то переприсвоюємо першого та останнього гравця. Якщо ж це 1 команда, то пропускаємо if
        if(teamNum == 1) {
            teamFirstMember = fightingDroids.size() / 2;
            teamLastMember = teamFirstMember + fightingDroids.size() / 2;
        }

        while(teamFirstMember < teamLastMember) {
            if(fightingDroids.get(teamFirstMember).getIsAbleToMove() == false) {
                countOfUnableDroids++;
            }

            teamFirstMember++;
        }

        return countOfUnableDroids != fightingDroids.size() / 2;
    }
}
