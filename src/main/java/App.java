import monster.Monster;
import monster.Team;
import monster.Zombie;

public class App {

    public static void main(String[] args) {

//        Monster zombie1 = new Zombie(10,10,15,10.0);
//        Monster zombie2 = new Zombie(10,10,12,10.0);
//        boolean[] whoDied = SingleAttack.singleAttackInFightOneOnOne(zombie1,zombie2);

        Team teamA = new Team();
        Monster zombie1 = new Zombie(10,10,15,10.0);
        Monster zombie2 = new Zombie(10,10,15,10.0);
        Monster zombie3 = new Zombie(10,10,15,10.0);
        teamA.addMonster(zombie1);
        teamA.addMonster(zombie2);
        teamA.addMonster(zombie3);

        Team teamB = new Team();
        Monster zombie4 = new Zombie(10,10,12,10.0);
        Monster zombie5 = new Zombie(10,10,12,10.0);
        Monster zombie6 = new Zombie(10,10,12,10.0);
        teamB.addMonster(zombie4);
        teamB.addMonster(zombie5);
        teamB.addMonster(zombie6);

        teamA.removeMonster(zombie1);

        System.out.println("");
    }


}
