package battle;

import monster.Monster;
import monster.Team;
import monster.Soldier;
import org.junit.Assert;
import org.junit.Test;

public class figthTeamVsTeamTest {
    @Test
    public void singleAttackInEvenFigthTestOneIsNotDead(){
        //given
        FigthTeamVsTeam figthTeamVsTeam = new FigthTeamVsTeam();
        Team teamA = new Team();
        Monster soldier1 = new Soldier(1,10,15,1.0);
        Monster soldier2 = new Soldier(1,10,15,10.0);
        teamA.addMonster(soldier1);
        teamA.addMonster(soldier2);

        Team teamB = new Team();
        Monster soldier4 = new Soldier(1,10,15,5.0);
        Monster soldier5 = new Soldier(1,10,15,5.0);
        teamB.addMonster(soldier4);
        teamB.addMonster(soldier5);

        //when
        boolean result = figthTeamVsTeam.singleAttackInEvenFigth(teamA,teamB);

        //then
        Assert.assertTrue(result);
        Assert.assertEquals(1,teamA.getSizeTeam());
        Assert.assertEquals(0,teamB.getSizeTeam());
        Assert.assertEquals(soldier2,teamA.getMonsters().get(0));
    }
    @Test
    public void singleAttackInEvenFigthTestNoneIsDead() {
        //given
        FigthTeamVsTeam figthTeamVsTeam = new FigthTeamVsTeam();
        Team teamA = new Team();
        Monster soldier1 = new Soldier(1,10,15,10.0);
        Monster soldier2 = new Soldier(1,10,15,10.0);
        teamA.addMonster(soldier1);
        teamA.addMonster(soldier2);

        Team teamB = new Team();
        Monster soldier4 = new Soldier(1,10,15,10.0);
        Monster soldier5 = new Soldier(1,10,15,10.0);
        teamB.addMonster(soldier4);
        teamB.addMonster(soldier5);

        //when
        boolean result = figthTeamVsTeam.singleAttackInEvenFigth(teamA,teamB);

        //then
        Assert.assertFalse(result);
        Assert.assertEquals(2,teamA.getSizeTeam());
        Assert.assertEquals(2,teamB.getSizeTeam());
        Assert.assertEquals(soldier2,teamA.getMonster(soldier2.getId()));
        Assert.assertEquals(soldier1,teamA.getMonsters().get(0));
    }
    @Test
    public void singleAttackInEvenFigthTestEveryOneIsDead() {
        //given
        FigthTeamVsTeam figthTeamVsTeam = new FigthTeamVsTeam();
        Team teamA = new Team();
        Monster soldier1 = new Soldier(1,10,15,1.0);
        Monster soldier2 = new Soldier(1,10,15,2.0);
        teamA.addMonster(soldier1);
        teamA.addMonster(soldier2);

        Team teamB = new Team();
        Monster soldier4 = new Soldier(1,10,15,5.0);
        Monster soldier5 = new Soldier(1,10,15,4.0);
        teamB.addMonster(soldier4);
        teamB.addMonster(soldier5);

        //when
        boolean result = figthTeamVsTeam.singleAttackInEvenFigth(teamA,teamB);

        //then
        Assert.assertTrue(result);
        Assert.assertEquals(0,teamA.getSizeTeam());
        Assert.assertEquals(0,teamB.getSizeTeam());
        Assert.assertNotEquals(soldier2,teamA.getMonster(soldier2.getId()));
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
        Monster soldier1 = new Soldier(1,10,15,10.0);
        Monster soldier2 = new Soldier(1,10,15,15.0);
        teamA.addMonster(soldier1);
        teamA.addMonster(soldier2);

        Team teamB = new Team();
        Monster soldier4 = new Soldier(1,10,15,15.0);
        Monster soldier5 = new Soldier(1,10,15,15.0);
        teamB.addMonster(soldier4);
        teamB.addMonster(soldier5);

        //when
        boolean result1 = figthTeamVsTeam.singleAttackInEvenFigth(teamA,teamB);
        boolean result2 = figthTeamVsTeam.singleAttackInEvenFigth(teamA,teamB);

        //then
        Assert.assertFalse(result1);
        Assert.assertTrue(result2);

        Assert.assertEquals(1,teamA.getSizeTeam());
        Assert.assertEquals(2,teamB.getSizeTeam());
        Assert.assertEquals(soldier2,teamA.getMonster(soldier2.getId()));
        Assert.assertEquals(soldier2,teamA.getMonsters().get(0));

    }
    @Test
    public void singleAttackInNotEvenFigthWithTreeArgumentTestNoneIsDead(){
        //given
        FigthTeamVsTeam figthTeamVsTeam = new FigthTeamVsTeam();
        Team teamA = new Team();
        Monster soldier1 = new Soldier(1,10,15,10.0);
        Monster soldier2 = new Soldier(1,10,15,10.0);
        Monster soldier3 = new Soldier(1,10,15,10.0);
        Monster soldier4 = new Soldier(1,10,15,10.0);
        teamA.addMonster(soldier1);
        teamA.addMonster(soldier2);
        teamA.addMonster(soldier3);
        teamA.addMonster(soldier4);

        Team teamB = new Team();
        Monster soldier5 = new Soldier(1,10,15,25.0);
        Monster soldier6 = new Soldier(1,10,15,10.0);
        teamB.addMonster(soldier5);
        teamB.addMonster(soldier6);

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
        Monster soldier1 = new Soldier(1,10,15,10.0);
        Monster soldier2 = new Soldier(1,10,15,10.0);
        Monster soldier3 = new Soldier(1,10,15,10.0);
        Monster soldier4 = new Soldier(1,10,15,10.0);
        Monster soldier5 = new Soldier(1,10,15,10.0);
        teamA.addMonster(soldier1);
        teamA.addMonster(soldier2);
        teamA.addMonster(soldier3);
        teamA.addMonster(soldier4);
        teamA.addMonster(soldier5);

        Team teamB = new Team();
        Monster soldier1B = new Soldier(1,10,15,100.0);
        teamB.addMonster(soldier1B);

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
        Monster soldier1 = new Soldier(1,10,15,10.0);
        Monster soldier2 = new Soldier(1,10,15,10.0);
        Monster soldier3 = new Soldier(1,10,15,10.0);
        Monster soldier4 = new Soldier(1,10,15,10.0);
        Monster soldier5 = new Soldier(1,10,15,10.0);
        teamA.addMonster(soldier1);
        teamA.addMonster(soldier2);
        teamA.addMonster(soldier3);
        teamA.addMonster(soldier4);
        teamA.addMonster(soldier5);

        Team teamB = new Team();
        Monster soldier1B = new Soldier(1,10,15,10.0);
        Monster soldier2B = new Soldier(1,10,15,10.0);
        teamB.addMonster(soldier1B);
        teamB.addMonster(soldier2B);

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
        Monster soldier1 = new Soldier(1,10,15,10.0);
        Monster soldier2 = new Soldier(1,10,15,10.0);
        Monster soldier3 = new Soldier(1,10,15,10.0);
        Monster soldier4 = new Soldier(1,10,15,10.0);
        Monster soldier5 = new Soldier(1,10,15,10.0);
        teamA.addMonster(soldier1);
        teamA.addMonster(soldier2);
        teamA.addMonster(soldier3);
        teamA.addMonster(soldier4);
        teamA.addMonster(soldier5);

        Team teamB = new Team();
        Monster soldier1B = new Soldier(1,10,15,10.0);
        Monster soldier2B = new Soldier(1,10,15,17.0);
        teamB.addMonster(soldier1B);
        teamB.addMonster(soldier2B);

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
        Monster soldier1 = new Soldier(1,10,15,10.0);
        Monster soldier2 = new Soldier(1,10,15,10.0);
        teamA.addMonster(soldier1);
        teamA.addMonster(soldier2);

        Team teamB = new Team();
        Monster soldier1B = new Soldier(1,10,15,5.0);
        Monster soldier2B = new Soldier(1,10,15,17.0);
        teamB.addMonster(soldier1B);
        teamB.addMonster(soldier2B);

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
        Monster soldier1 = new Soldier(1,10,15,30.0);
        Monster soldier2 = new Soldier(1,10,15,30.0);
        teamA.addMonster(soldier1);
        teamA.addMonster(soldier2);

        Team teamB = new Team();
        Monster soldier1B = new Soldier(1,10,15,5.0);
        Monster soldier2B = new Soldier(1,10,15,30.0);
        teamB.addMonster(soldier1B);
        teamB.addMonster(soldier2B);

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
        Monster soldier1 = new Soldier(1,10,15,30.0);
        Monster soldier2 = new Soldier(1,10,15,10.0);
        teamA.addMonster(soldier1);
        teamA.addMonster(soldier2);

        Team teamB = new Team();
        Monster soldier1B = new Soldier(1,10,15,30.0);
        Monster soldier2B = new Soldier(1,10,15,30.0);
        teamB.addMonster(soldier1B);
        teamB.addMonster(soldier2B);

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


    @Test
    public void fightTeamVsTeamToWinTestWonTeamA1_0(){
        //given
        Team teamA = new Team();
        Monster soldier1 = new Soldier(1,10,15,10.0);
        Monster soldier2 = new Soldier(1,10,15,30.0);
        teamA.addMonster(soldier1);
        teamA.addMonster(soldier2);

        Team teamB = new Team();
        Monster soldier1B = new Soldier(1,10,15,30.0);
        Monster soldier2B = new Soldier(1,10,15,5.0);
        teamB.addMonster(soldier1B);
        teamB.addMonster(soldier2B);

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
        Monster soldier1 = new Soldier(1,10,15,1.0);
        Monster soldier2 = new Soldier(1,10,15,10.0);
        teamA.addMonster(soldier1);
        teamA.addMonster(soldier2);

        Team teamB = new Team();
        Monster soldier1B = new Soldier(1,10,15,10.0);
        teamB.addMonster(soldier1B);

        boolean expectedResult = true;
        int expectedSizeTeamA = 1;
        int expectedSizeTeamB = 0;

        //when
        boolean result = figthTeamVsTeam.singleAttackInNotEvenFigth(teamA,teamB,true);

        //then
        Assert.assertEquals(expectedResult,result);
        Assert.assertEquals(expectedSizeTeamA,teamA.getSizeTeam());
        Assert.assertEquals(expectedSizeTeamB,teamB.getSizeTeam());

    }

    @Test
    public void fightTeamVsTeamToWinTestLitleGroupVsGoliatWonGroup(){
        //given
        FigthTeamVsTeam figthTeamVsTeam = new FigthTeamVsTeam();
        Team teamA = new Team();
        Monster soldier1 = new Soldier(1,10,15,1.0);
        Monster soldier2 = new Soldier(1,10,15,1.0);
        Monster soldier3 = new Soldier(1,10,15,1.0);
        Monster soldier1a = new Soldier(1,10,15,1.0);
        Monster soldier2a = new Soldier(1,10,15,1.0);
        Monster soldier3a = new Soldier(1,10,15,1.0);

        teamA.addMonster(soldier1);
        teamA.addMonster(soldier2);
        teamA.addMonster(soldier3);
        teamA.addMonster(soldier1a);
        teamA.addMonster(soldier2a);
        teamA.addMonster(soldier3a);

        Team teamB = new Team();
        Monster soldier1B = new Soldier(1,10,15,100.0);
        teamB.addMonster(soldier1B);

        boolean expectedResult = true;
        int expectedSizeTeamA = 1;
        int expectedSizeTeamB = 0;

        //when
        boolean result = figthTeamVsTeam.fightTeamVsTeamToWin(teamA,teamB);
        //then
        Assert.assertEquals(expectedResult,result);
        Assert.assertEquals(expectedSizeTeamA,teamA.getSizeTeam());
        Assert.assertEquals(expectedSizeTeamB,teamB.getSizeTeam());

    }
    @Test
    public void fightTeamVsTeamToWinTestGroupVsGoliatWonGroup(){
        //given
        FigthTeamVsTeam figthTeamVsTeam = new FigthTeamVsTeam();
        Team teamA = new Team();
        Monster soldier1 = new Soldier(1,10,15,1.0);
        Monster soldier2 = new Soldier(1,10,15,1.0);
        Monster soldier3 = new Soldier(1,10,15,1.0);
        Monster soldier4 = new Soldier(1,10,15,1.0);
        Monster soldier5 = new Soldier(1,10,15,1.0);
        Monster soldier1a = new Soldier(1,10,15,1.0);
        Monster soldier2a = new Soldier(1,10,15,1.0);
        Monster soldier3a = new Soldier(1,10,15,1.0);
        Monster soldier4a = new Soldier(1,10,15,1.0);
        Monster soldier5a = new Soldier(1,10,15,1.0);

        teamA.addMonster(soldier1);
        teamA.addMonster(soldier2);
        teamA.addMonster(soldier3);
        teamA.addMonster(soldier4);
        teamA.addMonster(soldier5);
        teamA.addMonster(soldier1a);
        teamA.addMonster(soldier2a);
        teamA.addMonster(soldier3a);
        teamA.addMonster(soldier4a);
        teamA.addMonster(soldier5a);

        Team teamB = new Team();
        Monster soldier1B = new Soldier(1,10,15,100.0);
        teamB.addMonster(soldier1B);

        boolean expectedResult = true;
        int expectedSizeTeamA = 8;
        int expectedSizeTeamB = 0;

        //when
        boolean result = figthTeamVsTeam.fightTeamVsTeamToWin(teamA,teamB);

        //then
        Assert.assertEquals(expectedResult,result);
        Assert.assertEquals(expectedSizeTeamA,teamA.getSizeTeam());
        Assert.assertEquals(expectedSizeTeamB,teamB.getSizeTeam());

    }
}
