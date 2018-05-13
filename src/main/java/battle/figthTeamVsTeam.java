package battle;

import monster.Monster;
import monster.Team;

public class figthTeamVsTeam {

    public boolean singleAttackInEvenFigth(Team teamA, Team teamB ){
        boolean someonedied=false;
        for (int i = 0; i < teamA.getSizeTeam(); i++) {
            Monster monsterA=teamA.getMonster(i);
            Monster monsterB=teamB.getMonster(i);
            boolean[] isWhoDied = SingleAttack.singleAttackInFightOneOnOne(monsterA,monsterB);
            if(isWhoDied[0]){
                teamA.removeMonster(monsterA);
                someonedied=true;
            }
            if(isWhoDied[1]){
                teamB.removeMonster(monsterB);
                someonedied=true;
            }
        }
        return someonedied;
    }
    public boolean singleAttackInNotEvenFigth(Team teamA,Team teamB){
        boolean someonedied=false;
        boolean whichTeamIsBigger = teamA.getSizeTeam()>teamB.getSizeTeam();

        someonedied = whichTeamIsBigger? singleAttackInEvenFigthForBiggerTeam(teamA,teamB) : singleAttackInEvenFigthForBiggerTeam(teamB,teamA);

        return someonedied;
    }

    private boolean singleAttackInEvenFigthForBiggerTeam(Team biggerTeam, Team smallerTeam) {
        int sizeTeam=smallerTeam.getSizeTeam();
        Team partOfBiggerTeam = new Team(biggerTeam.getMonsters().subList(0,sizeTeam));

        //TODO something
        return false;
    }

}
