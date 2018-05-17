package battle;

import monster.Monster;
import monster.Team;


import static java.util.stream.Collectors.toList;

public class FigthTeamVsTeam {
    public static boolean fightTeamVsTeamToWin(Team teamA,Team teamB){
        boolean whoWon=false;

        while(teamA.getSizeTeam()>0 && teamB.getSizeTeam()>0){
            singleAttackTeamVsTeam(teamA,teamB);
        }
        if(teamA.isTeamIsExist()&&(!teamB.isTeamIsExist())){
            whoWon=true;
        }else if(teamB.isTeamIsExist()&&(!teamA.isTeamIsExist())){
            whoWon=false;
        }

        return whoWon;
    }
    public static boolean singleAttackTeamVsTeam(Team teamA,Team teamB){
        FigthTeamVsTeam figthTeamVsTeam = new FigthTeamVsTeam();
        int sizeTeamA=teamA.getSizeTeam();
        int sizeTeamB=teamB.getSizeTeam();
        if(sizeTeamA>sizeTeamB){
            return figthTeamVsTeam.singleAttackInNotEvenFigth(teamA,teamB,true);
        }else if(sizeTeamA<sizeTeamB){
            return figthTeamVsTeam.singleAttackInNotEvenFigth(teamA,teamB,false);
        }else{
            return figthTeamVsTeam.singleAttackInEvenFigth(teamA,teamB);
        }
    }
    public boolean singleAttackInEvenFigth(Team teamA, Team teamB ){
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
//    public boolean singleAttackInNotEvenFigth(Team teamA, Team teamB, boolean whichTeamIsBigger) {
//        boolean someonedied=false;
//    }

    //problem z subListą, już poprawiony ale teraz nie usuwa w funkcji singleAttackInEvenFigth
    public boolean singleAttackInNotEvenFigth(Team teamA, Team teamB, boolean whichTeamIsBigger) {
        boolean someonedied=false;
        Team biggerTeam = whichTeamIsBigger?teamA:teamB;
        Team smallerTeam = whichTeamIsBigger?teamB:teamA;
        int sizeTeam=smallerTeam.getSizeTeam();
        //subList klonujacy, lepszy niz to nizej
//        Team partOfBiggerTeam = new Team(biggerTeam.getMonsters().stream().collect(toList()).subList(0,sizeTeam));
//        Team restOfBiggerTeam = new Team(biggerTeam.getMonsters().stream().collect(toList()).subList(sizeTeam,biggerTeam.getSizeTeam()));

        Team partOfBiggerTeam = new Team(biggerTeam.getMonsters().subList(0,sizeTeam));
        Team restOfBiggerTeam = new Team(biggerTeam.getMonsters().subList(sizeTeam,biggerTeam.getSizeTeam()));

        someonedied = singleAttackInEvenFigth(partOfBiggerTeam, smallerTeam) || someonedied;

        if(smallerTeam.getSizeTeam()==0){
            return someonedied;
        }
        for (int i = 0; i < restOfBiggerTeam.getSizeTeam(); i++) {
            boolean isDied = SingleAttack.singleAttackInFewOnOne(restOfBiggerTeam.getMonsters().get(i),smallerTeam.getMonsters().get(0));
            if(!isDied){
                smallerTeam.removeMonster(smallerTeam.getMonsters().get(0));
                someonedied=true;
            }
            if(smallerTeam.getSizeTeam()==0){
                break;
            }
        }

        return someonedied;
    }

}
