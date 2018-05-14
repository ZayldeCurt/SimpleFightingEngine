package battle;

import monster.Monster;
import monster.Team;
import monster.Zombie;
import battle.figthTeamVsTeam;
import org.junit.Assert;
import org.junit.Test;

public class figthTeamVsTeamTest {
    @Test
    public void singleAttackInEvenFigthTestOneIsNotDead(){
        //given
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

}
