package battle;

import monster.Monster;

public class SingleAttack {
    public static boolean[] singleAttackInFightOneOnOne(Monster monster1, Monster monster2){
        double demage1;
        double demage2;
        demage1=monster1.attack(monster2);
        demage2=monster2.attack(monster1);
        monster1.setHealth(monster1.getHealth()-demage2);
        monster2.setHealth(monster2.getHealth()-demage1);

        boolean[] whoDied = {monster1.isAlive(),monster2.isAlive()};
        return whoDied;
    }
    public static boolean singleAttackInFewOnOne(Monster attacker, Monster defender){

        double demage;
        demage=attacker.attack(defender)*1.1;
        defender.setHealth(defender.getHealth()-demage);

        return defender.isAlive();
    }

}
