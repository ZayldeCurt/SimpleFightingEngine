package battle;

import monster.Monster;
import monster.Team;

public class figthTeamVsTeam {

    public static boolean singleAttackInEvenFigth(Team teamA, Team teamB ){
        boolean someonedied=false;
        int teamASize = teamA.getSizeTeam();
        boolean[][] tableOfDead = new boolean[teamASize][2];
        for (int i = 0; i <  teamASize; i++) {
            tableOfDead[i][0]=true;
            tableOfDead[i][1]=true;
            Monster monsterA=teamA.getMonsters().get(i);
            Monster monsterB=teamB.getMonsters().get(i);
            boolean[] isWhoDied = SingleAttack.singleAttackInFightOneOnOne(monsterA,monsterB);
            if(!isWhoDied[0]){
//                teamA.removeMonster(monsterA);
                tableOfDead[i][0]=false;
                someonedied=true;
            }
            if(!isWhoDied[1]){
//                teamB.removeMonster(monsterB);
                tableOfDead[i][1]=false;
                someonedied=true;
            }
        }
        for (int i = 0,j=0; i < teamA.getSizeTeam(); i++,j++) {
            boolean res = !tableOfDead[j][0];
            if (res) {
                teamA.removeMonster(teamA.getMonsters().get(i));
                i--;
            }
        }
        for(int i = 0, j = 0; i < teamB.getSizeTeam(); i++,j++){
            boolean res = !tableOfDead[j][1];
            if(res){
                teamB.removeMonster(teamB.getMonsters().get(i));
                i--;
            }
        }
        return someonedied;
    }
    public static boolean singleAttackInNotEvenFigth(Team teamA,Team teamB){
        boolean someonedied=false;
        boolean whichTeamIsBigger = teamA.getSizeTeam()>teamB.getSizeTeam();

        someonedied = singleAttackInNotEvenFigth(teamA,teamB,whichTeamIsBigger);

        return someonedied;
    }

    private static boolean singleAttackInNotEvenFigth(Team teamA, Team teamB, boolean whichTeamIsBigger) {
        boolean someonedied=false;
        Team biggerTeam = whichTeamIsBigger?teamA:teamB;
        Team smallerTeam = whichTeamIsBigger?teamB:teamA;
        int sizeTeam=smallerTeam.getSizeTeam();
        Team partOfBiggerTeam = new Team(biggerTeam.getMonsters().subList(0,sizeTeam));
        Team restOfBiggerTeam = new Team(biggerTeam.getMonsters().subList(sizeTeam+1,biggerTeam.getSizeTeam()));

        someonedied = singleAttackInEvenFigth(partOfBiggerTeam, smallerTeam) || someonedied;

        for (int i = 0; i < restOfBiggerTeam.getSizeTeam(); i++) {
            boolean isDied = SingleAttack.singleAttackInFewOnOne(restOfBiggerTeam.getMonsters().get(i),smallerTeam.getMonsters().get(0));
            if(isDied){
                smallerTeam.removeMonster(smallerTeam.getMonsters().get(0));
                someonedied=true;
            }
        }

        //TODO napisać testy

        return someonedied;
    }


}
