package battle;

import monster.Monster;
import monster.Team;
import monster.Zombie;
import org.junit.Assert;
import org.junit.Test;

public class figthTeamVsTeamTest {
    @Test
    public void singleAttackInEvenFigthTestOneIsNotDead(){
        //given
        FigthTeamVsTeam figthTeamVsTeam = new FigthTeamVsTeam();
        Team teamA = new Team();
        Monster zombie1 = new Zombie(1,10,15,1.0);
        Monster zombie2 = new Zombie(1,10,15,10.0);
        teamA.addMonster(zombie1);
        teamA.addMonster(zombie2);

        Team teamB = new Team();
        Monster zombie4 = new Zombie(1,10,15,5.0);
        Monster zombie5 = new Zombie(1,10,15,5.0);
        teamB.addMonster(zombie4);
        teamB.addMonster(zombie5);

        //when
        boolean result = figthTeamVsTeam.singleAttackInEvenFigth(teamA,teamB);

        //then
        Assert.assertTrue(result);
        Assert.assertEquals(1,teamA.getSizeTeam());
        Assert.assertEquals(0,teamB.getSizeTeam());
        Assert.assertEquals(zombie2,teamA.getMonsters().get(0));
    }
    @Test
    public void singleAttackInEvenFigthTestNoneIsDead() {
        //given
        FigthTeamVsTeam figthTeamVsTeam = new FigthTeamVsTeam();
        Team teamA = new Team();
        Monster zombie1 = new Zombie(1,10,15,10.0);
        Monster zombie2 = new Zombie(1,10,15,10.0);
        teamA.addMonster(zombie1);
        teamA.addMonster(zombie2);

        Team teamB = new Team();
        Monster zombie4 = new Zombie(1,10,15,10.0);
        Monster zombie5 = new Zombie(1,10,15,10.0);
        teamB.addMonster(zombie4);
        teamB.addMonster(zombie5);

        //when
        boolean result = figthTeamVsTeam.singleAttackInEvenFigth(teamA,teamB);

        //then
        Assert.assertFalse(result);
        Assert.assertEquals(2,teamA.getSizeTeam());
        Assert.assertEquals(2,teamB.getSizeTeam());
        Assert.assertEquals(zombie2,teamA.getMonster(zombie2.getId()));
        Assert.assertEquals(zombie1,teamA.getMonsters().get(0));
    }
    @Test
    public void singleAttackInEvenFigthTestEveryOneIsDead() {
        //given
        FigthTeamVsTeam figthTeamVsTeam = new FigthTeamVsTeam();
        Team teamA = new Team();
        Monster zombie1 = new Zombie(1,10,15,1.0);
        Monster zombie2 = new Zombie(1,10,15,2.0);
        teamA.addMonster(zombie1);
        teamA.addMonster(zombie2);

        Team teamB = new Team();
        Monster zombie4 = new Zombie(1,10,15,5.0);
        Monster zombie5 = new Zombie(1,10,15,4.0);
        teamB.addMonster(zombie4);
        teamB.addMonster(zombie5);

        //when
        boolean result = figthTeamVsTeam.singleAttackInEvenFigth(teamA,teamB);

        //then
        Assert.assertTrue(result);
        Assert.assertEquals(0,teamA.getSizeTeam());
        Assert.assertEquals(0,teamB.getSizeTeam());
        Assert.assertNotEquals(zombie2,teamA.getMonster(zombie2.getId()));
        boolean tryAssert=false;
        try{
            Monster monster =teamA.getMonsters().get(0);
        }catch (IndexOutOfBoundsException e){
            tryAssert=true;
        }
        Assert.assertTrue(tryAssert);
    }
    @Test
    public void singleAttackInEvenFigthTestOneIsDeadInSecondIteration() {
        //given
        FigthTeamVsTeam figthTeamVsTeam = new FigthTeamVsTeam();
        Team teamA = new Team();
        Monster zombie1 = new Zombie(1,10,15,10.0);
        Monster zombie2 = new Zombie(1,10,15,15.0);
        teamA.addMonster(zombie1);
        teamA.addMonster(zombie2);

        Team teamB = new Team();
        Monster zombie4 = new Zombie(1,10,15,15.0);
        Monster zombie5 = new Zombie(1,10,15,15.0);
        teamB.addMonster(zombie4);
        teamB.addMonster(zombie5);

        //when
        boolean result1 = figthTeamVsTeam.singleAttackInEvenFigth(teamA,teamB);
        boolean result2 = figthTeamVsTeam.singleAttackInEvenFigth(teamA,teamB);

        //then
        Assert.assertFalse(result1);
        Assert.assertTrue(result2);

        Assert.assertEquals(1,teamA.getSizeTeam());
        Assert.assertEquals(2,teamB.getSizeTeam());
        Assert.assertEquals(zombie2,teamA.getMonster(zombie2.getId()));
        Assert.assertEquals(zombie2,teamA.getMonsters().get(0));

    }
    @Test
    public void singleAttackInNotEvenFigthWithTreeArgumentTestNoneIsDead(){
        //given
        FigthTeamVsTeam figthTeamVsTeam = new FigthTeamVsTeam();
        Team teamA = new Team();
        Monster zombie1 = new Zombie(1,10,15,10.0);
        Monster zombie2 = new Zombie(1,10,15,10.0);
        Monster zombie3 = new Zombie(1,10,15,10.0);
        Monster zombie4 = new Zombie(1,10,15,10.0);
        teamA.addMonster(zombie1);
        teamA.addMonster(zombie2);
        teamA.addMonster(zombie3);
        teamA.addMonster(zombie4);

        Team teamB = new Team();
        Monster zombie5 = new Zombie(1,10,15,25.0);
        Monster zombie6 = new Zombie(1,10,15,10.0);
        teamB.addMonster(zombie5);
        teamB.addMonster(zombie6);

        boolean expectedResult = false;
        int sizeTeamA = teamA.getSizeTeam();
        int sizeTeamB = teamB.getSizeTeam();
        //when
        boolean result = figthTeamVsTeam.singleAttackInNotEvenFigth(teamA,teamB,true);

        //then
        Assert.assertEquals(expectedResult,result);
        Assert.assertEquals(sizeTeamA,teamA.getSizeTeam());
        Assert.assertEquals(sizeTeamB,teamB.getSizeTeam());
    }
    @Test
    public void singleAttackInNotEvenFigthWithTreeArgumentTestNoneIsDeadv2(){
        //given
        FigthTeamVsTeam figthTeamVsTeam = new FigthTeamVsTeam();
        Team teamA = new Team();
        Monster zombie1 = new Zombie(1,10,15,10.0);
        Monster zombie2 = new Zombie(1,10,15,10.0);
        Monster zombie3 = new Zombie(1,10,15,10.0);
        Monster zombie4 = new Zombie(1,10,15,10.0);
        Monster zombie5 = new Zombie(1,10,15,10.0);
        teamA.addMonster(zombie1);
        teamA.addMonster(zombie2);
        teamA.addMonster(zombie3);
        teamA.addMonster(zombie4);
        teamA.addMonster(zombie5);

        Team teamB = new Team();
        Monster zombie1B = new Zombie(1,10,15,100.0);
        teamB.addMonster(zombie1B);

        boolean expectedResult = false;
        int expectedSizeTeamA = 5;
        int expectedSizeTeamB = 1;
        //when
        boolean result = figthTeamVsTeam.singleAttackInNotEvenFigth(teamA,teamB,true);

        //then
        Assert.assertEquals(expectedResult,result);
        Assert.assertEquals(expectedSizeTeamA,teamA.getSizeTeam());
        Assert.assertEquals(expectedSizeTeamB,teamB.getSizeTeam());
    }
    @Test
    public void singleAttackInNotEvenFigthWithTreeArgumentTestInTeamBEveryIsDead(){
        //given
        FigthTeamVsTeam figthTeamVsTeam = new FigthTeamVsTeam();
        Team teamA = new Team();
        Monster zombie1 = new Zombie(1,10,15,10.0);
        Monster zombie2 = new Zombie(1,10,15,10.0);
        Monster zombie3 = new Zombie(1,10,15,10.0);
        Monster zombie4 = new Zombie(1,10,15,10.0);
        Monster zombie5 = new Zombie(1,10,15,10.0);
        teamA.addMonster(zombie1);
        teamA.addMonster(zombie2);
        teamA.addMonster(zombie3);
        teamA.addMonster(zombie4);
        teamA.addMonster(zombie5);

        Team teamB = new Team();
        Monster zombie1B = new Zombie(1,10,15,10.0);
        Monster zombie2B = new Zombie(1,10,15,10.0);
        teamB.addMonster(zombie1B);
        teamB.addMonster(zombie2B);

        boolean expectedResult = true;
        int expectedSizeTeamA = 5;
        int expectedSizeTeamB = 0;
        //when
        boolean result = figthTeamVsTeam.singleAttackInNotEvenFigth(teamA,teamB,true);

        //then
        Assert.assertEquals(expectedResult,result);
        Assert.assertEquals(expectedSizeTeamA,teamA.getSizeTeam());
        Assert.assertEquals(expectedSizeTeamB,teamB.getSizeTeam());
    }

    @Test
    public void singleAttackTeamVsTeamInNotEvenTeamInTeamBOneIsAlive(){
        //given
        Team teamA = new Team();
        Monster zombie1 = new Zombie(1,10,15,10.0);
        Monster zombie2 = new Zombie(1,10,15,10.0);
        Monster zombie3 = new Zombie(1,10,15,10.0);
        Monster zombie4 = new Zombie(1,10,15,10.0);
        Monster zombie5 = new Zombie(1,10,15,10.0);
        teamA.addMonster(zombie1);
        teamA.addMonster(zombie2);
        teamA.addMonster(zombie3);
        teamA.addMonster(zombie4);
        teamA.addMonster(zombie5);

        Team teamB = new Team();
        Monster zombie1B = new Zombie(1,10,15,10.0);
        Monster zombie2B = new Zombie(1,10,15,17.0);
        teamB.addMonster(zombie1B);
        teamB.addMonster(zombie2B);

        boolean expectedResult = true;
        int expectedSizeTeamA = 5;
        int expectedSizeTeamB = 1;

        //when
        boolean result = FigthTeamVsTeam.singleAttackTeamVsTeam(teamA,teamB);

        //then
        Assert.assertEquals(expectedResult,result);
        Assert.assertEquals(expectedSizeTeamA,teamA.getSizeTeam());
        Assert.assertEquals(expectedSizeTeamB,teamB.getSizeTeam());

    }
    @Test
    public void singleAttackTeamVsTeamInEvenTeamInTeamBOneIsAlive(){
        //given
        Team teamA = new Team();
        Monster zombie1 = new Zombie(1,10,15,10.0);
        Monster zombie2 = new Zombie(1,10,15,10.0);
        teamA.addMonster(zombie1);
        teamA.addMonster(zombie2);

        Team teamB = new Team();
        Monster zombie1B = new Zombie(1,10,15,5.0);
        Monster zombie2B = new Zombie(1,10,15,17.0);
        teamB.addMonster(zombie1B);
        teamB.addMonster(zombie2B);

        boolean expectedResult = true;
        int expectedSizeTeamA = 2;
        int expectedSizeTeamB = 1;

        //when
        boolean result = FigthTeamVsTeam.singleAttackTeamVsTeam(teamA,teamB);

        //then
        Assert.assertEquals(expectedResult,result);
        Assert.assertEquals(expectedSizeTeamA,teamA.getSizeTeam());
        Assert.assertEquals(expectedSizeTeamB,teamB.getSizeTeam());

    }


    @Test
    public void fightTeamVsTeamToWinTestWonTeamA(){
        //given
        Team teamA = new Team();
        Monster zombie1 = new Zombie(1,10,15,30.0);
        Monster zombie2 = new Zombie(1,10,15,30.0);
        teamA.addMonster(zombie1);
        teamA.addMonster(zombie2);

        Team teamB = new Team();
        Monster zombie1B = new Zombie(1,10,15,5.0);
        Monster zombie2B = new Zombie(1,10,15,30.0);
        teamB.addMonster(zombie1B);
        teamB.addMonster(zombie2B);

        boolean expectedResult = true;
        int expectedSizeTeamA = 2;
        int expectedSizeTeamB = 0;

        //when
        boolean result = FigthTeamVsTeam.fightTeamVsTeamToWin(teamA,teamB);

        //then
        Assert.assertEquals(expectedResult,result);
        Assert.assertEquals(expectedSizeTeamA,teamA.getSizeTeam());
        Assert.assertEquals(expectedSizeTeamB,teamB.getSizeTeam());
    }
    @Test
    public void fightTeamVsTeamToWinTestWonTeamB(){
        //given
        Team teamA = new Team();
        Monster zombie1 = new Zombie(1,10,15,30.0);
        Monster zombie2 = new Zombie(1,10,15,10.0);
        teamA.addMonster(zombie1);
        teamA.addMonster(zombie2);

        Team teamB = new Team();
        Monster zombie1B = new Zombie(1,10,15,30.0);
        Monster zombie2B = new Zombie(1,10,15,30.0);
        teamB.addMonster(zombie1B);
        teamB.addMonster(zombie2B);

        boolean expectedResult = false;
        int expectedSizeTeamA = 0;
        int expectedSizeTeamB = 2;

        //when
        boolean result = FigthTeamVsTeam.fightTeamVsTeamToWin(teamA,teamB);

        //then
        Assert.assertEquals(expectedResult,result);
        Assert.assertEquals(expectedSizeTeamA,teamA.getSizeTeam());
        Assert.assertEquals(expectedSizeTeamB,teamB.getSizeTeam());
    }

    //problem z sublista w dwoch testach niżej
    @Test
    public void fightTeamVsTeamToWinTestWonTeamA1_0(){
        //given
        Team teamA = new Team();
        Monster zombie1 = new Zombie(1,10,15,10.0);
        Monster zombie2 = new Zombie(1,10,15,30.0);
        teamA.addMonster(zombie1);
        teamA.addMonster(zombie2);

        Team teamB = new Team();
        Monster zombie1B = new Zombie(1,10,15,30.0);
        Monster zombie2B = new Zombie(1,10,15,5.0);
        teamB.addMonster(zombie1B);
        teamB.addMonster(zombie2B);

        boolean expectedResult = true;
        int expectedSizeTeamA = 1;
        int expectedSizeTeamB = 0;

        //when
        boolean result = FigthTeamVsTeam.fightTeamVsTeamToWin(teamA,teamB);

        //then
        Assert.assertEquals(expectedResult,result);
        Assert.assertEquals(expectedSizeTeamA,teamA.getSizeTeam());
        Assert.assertEquals(expectedSizeTeamB,teamB.getSizeTeam());
    }
    @Test
    public void singleAttackInNotEvenFigthWithTreeArgumentTestInBiggerTeamOneIsKilled(){
        //given
        FigthTeamVsTeam figthTeamVsTeam = new FigthTeamVsTeam();
        Team teamA = new Team();
        Monster zombie1 = new Zombie(1,10,15,1.0);
        Monster zombie2 = new Zombie(1,10,15,10.0);
        teamA.addMonster(zombie1);
        teamA.addMonster(zombie2);

        Team teamB = new Team();
        Monster zombie1B = new Zombie(1,10,15,10.0);
        teamB.addMonster(zombie1B);

        boolean expectedResult = true;
        int expectedSizeTeamA = 1;
        int expectedSizeTeamB = 1;

        //when
        boolean result = figthTeamVsTeam.singleAttackInNotEvenFigth(teamA,teamB,true);

        //then
        Assert.assertEquals(expectedResult,result);
        Assert.assertEquals(expectedSizeTeamA,teamA.getSizeTeam());
        Assert.assertEquals(expectedSizeTeamB,teamB.getSizeTeam());

    }
}
