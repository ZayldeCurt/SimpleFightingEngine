import battle.SingleAttack;
import monster.Monster;
import monster.Zombie;

public class App {

    public static void main(String[] args) {
//        SimpleFight simpleFight = new SimpleFight();
//        Team teamRed = new Team();
//        Team teamBlue = new Team();
//        simpleFight.fight(teamBlue,teamRed);

        Monster zombie1 = new Zombie(10,10,15,10.0);
        Monster zombie2 = new Zombie(10,10,12,10.0);

        boolean[] whoDied = SingleAttack.singleAttackInFightOneOnOne(zombie1,zombie2);

        System.out.println("");
    }


}
