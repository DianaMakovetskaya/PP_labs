package laba_3.droids;

import laba_3.player.Player;

import java.util.ArrayList;

public class Droids {
    private String name;
    private int health;
    private int damage;

    private int rage;
    private int typeOfUltimatePower;
    private int status;

    private int roundToStopUlty;
    private boolean isAbleToMove;

    public Droids() {
        //кожен раз коли створюється новий дроїд, викликається конструктор і в ньому increaseCountOfDroids ++
        Player.increaseCountOfDroids();
        isAbleToMove = true;
    }

    public Droids(Droids droid) {
        this.name = droid.name;
        this.health = droid.health;
        this.damage = droid.damage;
        this.typeOfUltimatePower = droid.typeOfUltimatePower;
        this.isAbleToMove = droid.isAbleToMove;
    }

    public void gettingHealed(int amountOfHeal) {
        this.health += amountOfHeal;
    }

    public void decreasingHealth(int amountOfDamage) {
        if(this.health - amountOfDamage >= 0) {
            this.health -= amountOfDamage;
        } else {
            this.health = 0;
        }
    }

    public void decreaseRage(int amountOfDecrease) {
        if((this.rage - amountOfDecrease) > 0) {
            this.rage -= amountOfDecrease;
        } else {
            this.rage = 0;
        }
    }

    public void increaseRage(int amountOfIncrease) {
        if((this.rage + amountOfIncrease) <= 100) {
            this.rage += amountOfIncrease;
        } else {
            this.rage = 100;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRage() {
        return rage;
    }

    public void setRage(int rage) {
        this.rage = rage;
    }

    public int getTypeOfUltimatePower() {
        return typeOfUltimatePower;
    }

    public void setTypeOfUltimatePower(int typeOfUltimatePower) {
        this.typeOfUltimatePower = typeOfUltimatePower;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }



    public boolean getIsAbleToMove() {
        return isAbleToMove;
    }

    public void setIsAbleToMove(boolean ableToMove) {
        isAbleToMove = ableToMove;
    }


    public static void showDroidsInfo(ArrayList<Droids> fightingDroids,int roundCount) {
        System.out.println("                                                                               Round " + roundCount + ".");

        for (int i = 0, droidAmountInTeam = fightingDroids.size()/2; i < droidAmountInTeam; i++) {
            System.out.println("                                                 " + (i+1) + ". " + fightingDroids.get(i).getName() + " - " +
                    fightingDroids.get(i).getHealth() + "hp, " +
                    fightingDroids.get(i).getRage() + "r.p." +
                    (fightingDroids.get(i).getIsAbleToMove() ? " ":". Unable to move.") +
                    "   ---   " + (i+1) + ". " + fightingDroids.get(i + droidAmountInTeam).getName() + " - " +
                    fightingDroids.get(i + droidAmountInTeam).getHealth() + "hp, " +
                    fightingDroids.get(i + droidAmountInTeam).getRage() + "r.p." +
                    (fightingDroids.get(i + droidAmountInTeam).getIsAbleToMove() ? "                 ":". Unable to move."));

        }

    }


















    @Override
    public String toString() {
        return  "Name= " + name +
                ", health= " + health +
                ", damage= " + damage +
                ", ultimate power №" + typeOfUltimatePower;
    }
}
