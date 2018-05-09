package battle;

import monster.Monster;
import monster.Team;
import monster.Zombie;
import org.junit.Assert;
import org.junit.Test;

public class TeamTest {
    @Test
    public void addOneMonsterToTeamTest(){
        //given
        Team teamA = new Team();
        Monster zombie1 = new Zombie(10,10,15,10.0);

        //when
        teamA.addMonster(zombie1);

        //then
        Assert.assertEquals(1,teamA.getSizeTeam());
        Assert.assertTrue(teamA.isTeamIsExist());
        Assert.assertEquals(zombie1,teamA.getMonster(zombie1.getId()));
    }

    @Test
    public void addMonstersToTeamTest(){
        //given
        Team teamA = new Team();
        Monster zombie1 = new Zombie(10,10,15,10.0);
        Monster zombie2 = new Zombie(10,10,15,10.0);
        Monster zombie3 = new Zombie(10,10,15,10.0);

        //when
        teamA.addMonster(zombie1);
        teamA.addMonster(zombie2);
        teamA.addMonster(zombie3);

        //then
        Assert.assertEquals(3,teamA.getSizeTeam());
        Assert.assertTrue(teamA.isTeamIsExist());
        Assert.assertEquals(zombie1,teamA.getMonsters().get(0));
        Assert.assertEquals(zombie2,teamA.getMonsters().get(1));
        Assert.assertEquals(zombie3,teamA.getMonster(zombie3.getId()));
    }

    @Test
    public void removeFromTeamTest(){
        //given
        Team teamA = new Team();
        Monster zombie1 = new Zombie(10,10,15,10.0);
        Monster zombie2 = new Zombie(10,10,15,10.0);
        Monster zombie3 = new Zombie(10,10,15,10.0);
        teamA.addMonster(zombie1);
        teamA.addMonster(zombie2);
        teamA.addMonster(zombie3);

        //when
        teamA.removeMonster(zombie2);

        //then
        Assert.assertEquals(2,teamA.getSizeTeam());
        Assert.assertTrue(teamA.isTeamIsExist());
        Assert.assertEquals(zombie1,teamA.getMonster(zombie1.getId()));
        Assert.assertNotEquals(zombie2,teamA.getMonster(zombie2.getId()));

    }

    @Test
    public void removeLastMonsterFromTeamTest(){
        //given
        Team teamA = new Team();
        Monster zombie1 = new Zombie(10,10,15,10.0);
        Monster zombie2 = new Zombie(10,10,15,10.0);
        Monster zombie3 = new Zombie(10,10,15,10.0);
        teamA.addMonster(zombie1);
        teamA.addMonster(zombie2);
        teamA.addMonster(zombie3);

        //when
        teamA.removeMonster(zombie2);
        teamA.removeMonster(zombie3);
        teamA.removeMonster(zombie1);

        //then
        Assert.assertEquals(0,teamA.getSizeTeam());
        Assert.assertFalse(teamA.isTeamIsExist());
        Assert.assertNotEquals(zombie1,teamA.getMonster(zombie1.getId()));
        Assert.assertNotEquals(zombie2,teamA.getMonster(zombie2.getId()));
    }
    @Test
    public void removeMonsterFromWrongTeam(){
        //given
        Team teamA = new Team();
        Monster zombie1 = new Zombie(10,10,15,10.0);
        Monster zombie2 = new Zombie(10,10,15,10.0);
        Monster zombie3 = new Zombie(10,10,15,10.0);

        Team teamB = new Team();
        Monster zombie4 = new Zombie(10,10,15,10.0);
        Monster zombie5 = new Zombie(10,10,15,10.0);

        teamA.addMonster(zombie1);
        teamA.addMonster(zombie2);
        teamA.addMonster(zombie3);
        teamB.addMonster(zombie4);
        teamB.addMonster(zombie5);

        //then


        //when
        Assert.assertFalse(teamA.removeMonster(zombie4));
        Assert.assertEquals(3,teamA.getSizeTeam());
        Assert.assertEquals(2,teamB.getSizeTeam());

        Assert.assertFalse(teamB.removeMonster(zombie1));
        Assert.assertEquals(3,teamA.getSizeTeam());
        Assert.assertEquals(2,teamB.getSizeTeam());

        Assert.assertTrue(teamA.removeMonster(zombie1));
        Assert.assertEquals(2,teamA.getSizeTeam());
        Assert.assertEquals(2,teamB.getSizeTeam());
    }

}
