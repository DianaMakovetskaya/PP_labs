package laba_3.battle;

import laba_3.Arenas.Arena;
import laba_3.Arenas.Arena2;
import laba_3.Arenas.Arena3;
import laba_3.IsPossibleToContinue.IsPossibleToContinue;
import laba_3.droids.Droids;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Battle {

    private int roundCount;
    private Random random = new Random();
    private ArrayList<Droids> fightingDroids = new ArrayList<>();

    private int indexOfAttacker;
    private int indexOfDefender;
    public static int enlimatedTeam;
    IsPossibleToContinue isPossibleToContinue =new IsPossibleToContinue();
    public static int ArenaNum=0;


    public Battle(Droids ... droid) {
        roundCount = 1;

        for (Droids droidIterator : droid) {
            Droids fighter = new Droids(droidIterator);
            fightingDroids.add(fighter);
        }
    }

    public void start1vs1Battle() {
        int random = 0 + (int) (Math.random() * 7);

        while (isPossibleToContinue.isPossibleToContinueFight(fightingDroids)) {
            Droids.showDroidsInfo(fightingDroids,roundCount);

            CheckArena(random);
            if(fightingDroids.get(0).getIsAbleToMove()==false){
                makeTurn(fightingDroids.get(1), fightingDroids.get(0));
            }else if(fightingDroids.get(1).getIsAbleToMove()==false){
                makeTurn(fightingDroids.get(0), fightingDroids.get(1));
            }else{
                isPossibleToContinue.isPossibleToContinueFight(fightingDroids);
                makeTurn(fightingDroids.get(0), fightingDroids.get(1));
                System.out.println(" *");

                if(!isPossibleToContinue.isPossibleToContinueFight(fightingDroids)) {
                    break;
                }

                makeTurn(fightingDroids.get(1), fightingDroids.get(0));
                System.out.println();
            }
            roundCount++;
            fightingDroids.get(0).setIsAbleToMove(true);
            fightingDroids.get(1).setIsAbleToMove(true);

        }

        if(enlimatedTeam == 2) {
            System.out.println("ᕦ(ò_óˇ)ᕤ "+fightingDroids.get(0).getName() + " IS STILL ALIVE, YOU WON!");
        } else {
            System.out.println(fightingDroids.get(1).getName() + " IS STRONGER, YOU LOST!");
        }
        System.out.println();

    }

    public void start3vs3Battle() {
        int randomRound=0 + (int) (Math.random() * 3);
        while(isPossibleToContinue.isPossibleToContinueFight(fightingDroids)) {

            for (int i = 0; i < 3; i++) {

                CheckArena(randomRound);
                Droids.showDroidsInfo(fightingDroids,roundCount);
                playerTurn(0);


                makeTurn(fightingDroids.get(indexOfAttacker), fightingDroids.get(indexOfDefender));//,битва учасника 1 команди з учасником 2 ком.
                fightingDroids.get(indexOfAttacker).setIsAbleToMove(false);//нападник більше не може приймати участь

                System.out.println();

                if(!isPossibleToContinue.isPossibleToContinueFight(fightingDroids)) {
                    break;
                }
                opponentTurn(1);

                makeTurn(fightingDroids.get(indexOfAttacker), fightingDroids.get(indexOfDefender));
                fightingDroids.get(indexOfAttacker).setIsAbleToMove(false);
                System.out.println();
                //зробити арену 3 не активною після того як вона спрацювала, а потім після roundCount++ зробити активною
            }

            roundCount++;
            //переходимо на наступний раунд та робити всіх able to move
            for (Droids iterator:fightingDroids) {
                if(iterator.getHealth() > 0) {
                    iterator.setIsAbleToMove(true);
                }
            }
        }

        if(enlimatedTeam == 2) {//якщо програвша команда -2, то ви виграли
            System.out.println(" *_-_ YOU WON! _-_*");
        } else {
            System.out.println(" *_-_ YOU LOST _-_* ");
        }
        System.out.println();

    }

    public void   CheckArena(int random){
        switch (ArenaNum){
            case 1:

                Arena.boom(fightingDroids,roundCount,random);
                break;
            case 3:
                Arena3.boom(fightingDroids,roundCount);
                break;
        }
    }

    public void makeTurn(Droids attacker, Droids defender) {//наносимо удар
        int attack = random.nextInt(attacker.getDamage() + 1);
        int accuracyChance = random.nextInt(100);
        int evasionChance = random.nextInt(40);
        //дивимось чи достатньо злості щоб, використати додаткову силу, якщо так тоді збільшуємо attack, якщо не достатньо повертаємо не змінене attack
        attack = checkForUlty(attacker, defender, attack);

        //якщо рандомно вибрана точність >90 або статус=1 тоді наносимо шкоду +30
        if(attacker.getStatus() == 1 | accuracyChance > 90) {
            System.out.println(" * CRIT *");
            attack += 30;
        }

        if(ArenaNum==2 && attack>40 && roundCount%2==0){
            attack=Arena2.boom(attacker,attack,roundCount);
        }

        if(isPossibleToHit(attacker, defender, accuracyChance, evasionChance)) {// якщо є можливість вдарити
            makeHit(attacker, defender, attack);
            //якщо здоров'я < 0, то він здох
            if(defender.getHealth() <= 0) {
                defender.setIsAbleToMove(false);
            }
        } else {//// якщо нема можливість вдарити
            System.out.println(" (ಥ﹏ಥ)" + attacker.getName() + " misses.");
        }
    }

    private int checkForUlty(Droids attacker, Droids defender, int attack) {
        if(attacker.getRage() >= 100) {
            switch(attacker.getTypeOfUltimatePower()) {
                case 1: {
                    attack *= 3;
                    break;
                }
                case 2: {
                    attacker.gettingHealed(150);
                    break;
                }
                case 3: {
                    attacker.setStatus(1);//accuracy+50
                    break;
                }
                case 4: {
                    attacker.setStatus(2);//Evasion + 50
                    break;
                }
                case 5: {
                    attacker.setStatus(3);// Block 80% of damage
                    break;
                }
                case 6: {
                    defender.decreaseRage(40);
                    attack += 40;
                    break;
                }
            }

            System.out.println(" * (ノಠ益ಠ)ノ" + attacker.getName() + " uses ulty №" + attacker.getTypeOfUltimatePower());
            attacker.setRage(0);
        }

        return attack;
    }



    private boolean isPossibleToHit(Droids attacker, Droids defender, int accuracyChance, int evasionChance) {
        if(attacker.getStatus() == 1){
            return true;
        } else if(defender.getStatus() == 2) {
            return false;
        } else return accuracyChance >= evasionChance;
    }

    private void makeHit(Droids attacker, Droids defender, int attack) {
        //якщо захисник має третій статус, тобто 5 силу, то урон який він отримкє зменшується на 20 %
        if(defender.getStatus() == 3) {
            attack = (int)(attack * 0.2);
            defender.setStatus(0);
        }
        //знімаємо здоров'я
        defender.decreasingHealth(attack);

        //повищуємо злість в захисника
            defender.increaseRage((int)((double)attack/10 + 10));

        //повищуємо злість в нападника
            attacker.increaseRage(10);
        System.out.println("(ಠ‿ಠ) ▄︻̷̿┻̿═━一 ⊙﹏⊙");

        System.out.println(" *" + attacker.getName() + " deals " + attack + "dmg to " + defender.getName() + "!");
    }

    private void playerTurn(int turn) {
        if(isPossibleToContinue.canTeamMakeTurn(turn,fightingDroids)) {
            Scanner in = new Scanner(System.in);

            System.out.print(" Choose attacking droid from 1 team -> ");
            indexOfAttacker = in.nextInt() - 1;

            while (fightingDroids.get(indexOfAttacker).getIsAbleToMove() == false) {
                System.out.print(" Unable to use this droid. Try once more -> ");
                indexOfAttacker = in.nextInt() - 1;
            }

            System.out.print(" Choose defending droid from 2 team -> ");
            indexOfDefender = in.nextInt() - 1 + 3;

            while (fightingDroids.get(indexOfAttacker).getHealth() <= 0) {
                System.out.print(" The droid is dead. Try once more -> ");
                indexOfDefender = in.nextInt() - 1 + 3;
            }
        }
    }

    private void opponentTurn(int turn){
        if(isPossibleToContinue.canTeamMakeTurn(turn,fightingDroids)) {

            Scanner in = new Scanner(System.in);

            System.out.print(" Choose attacking droid from 2 team -> ");
            indexOfAttacker = in.nextInt() - 1 + 3;

            while (fightingDroids.get(indexOfAttacker).getIsAbleToMove() == false) {
                System.out.print(" Unable to use this droid. Try once more -> ");
                indexOfAttacker = in.nextInt() - 1 + 3;
            }

            System.out.print(" Choose defending droid from 1 team-> ");
            indexOfDefender = in.nextInt() - 1;

            while (fightingDroids.get(indexOfAttacker).getHealth() <= 0) {
                System.out.print(" The droid is dead. Try once more -> ");
                indexOfDefender = in.nextInt() - 1;
            }
        }
    }


}
