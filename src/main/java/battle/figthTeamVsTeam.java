package battle;

import monster.Monster;
import monster.Team;

public class figthTeamVsTeam {

    public boolean singleAttackInEvenFigth(Team teamA, Team teamB ){
        for (int i = 0; i < teamA.getSizeTeam(); i++) {
            Monster monsterA=teamA.getMonster(i);
            Monster monsterB=teamB.getMonster(i);
            boolean[] isWhoDied = SingleAttack.singleAttackInFightOneOnOne(monsterA,monsterB);
            if(isWhoDied[0]){
                teamA.removeMonster(monsterA);
            }
            if(isWhoDied[1]){
                teamB.removeMonster(monsterB);
            }
        }
        return false;
    }

}
