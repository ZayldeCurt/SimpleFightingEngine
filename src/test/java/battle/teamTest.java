package battle;

import monster.Monster;
import monster.Team;
import monster.Soldier;
import org.junit.Assert;
import org.junit.Test;

public class teamTest {
    @Test
    public void addOneMonsterToTeamTest(){
        //given
        Team teamA = new Team();
        Monster soldier1 = new Soldier(10,10,15,10.0);

        //when
        teamA.addMonster(soldier1);

        //then
        Assert.assertEquals(1,teamA.getSizeTeam());
        Assert.assertTrue(teamA.isTeamIsExist());
        Assert.assertEquals(soldier1,teamA.getMonster(soldier1.getId()));
    }

    @Test
    public void addMonstersToTeamTest(){
        //given
        Team teamA = new Team();
        Monster soldier1 = new Soldier(10,10,15,10.0);
        Monster soldier2 = new Soldier(10,10,15,10.0);
        Monster soldier3 = new Soldier(10,10,15,10.0);

        //when
        teamA.addMonster(soldier1);
        teamA.addMonster(soldier2);
        teamA.addMonster(soldier3);

        //then
        Assert.assertEquals(3,teamA.getSizeTeam());
        Assert.assertTrue(teamA.isTeamIsExist());
        Assert.assertEquals(soldier1,teamA.getMonsters().get(0));
        Assert.assertEquals(soldier2,teamA.getMonsters().get(1));
        Assert.assertEquals(soldier3,teamA.getMonster(soldier3.getId()));
    }

    @Test
    public void removeFromTeamTest(){
        //given
        Team teamA = new Team();
        Monster soldier1 = new Soldier(10,10,15,10.0);
        Monster soldier2 = new Soldier(10,10,15,10.0);
        Monster soldier3 = new Soldier(10,10,15,10.0);
        teamA.addMonster(soldier1);
        teamA.addMonster(soldier2);
        teamA.addMonster(soldier3);

        //when
        teamA.removeMonster(soldier2);

        //then
        Assert.assertEquals(2,teamA.getSizeTeam());
        Assert.assertTrue(teamA.isTeamIsExist());
        Assert.assertEquals(soldier1,teamA.getMonster(soldier1.getId()));
        Assert.assertNotEquals(soldier2,teamA.getMonster(soldier2.getId()));

    }

    @Test
    public void removeLastMonsterFromTeamTest(){
        //given
        Team teamA = new Team();
        Monster soldier1 = new Soldier(10,10,15,10.0);
        Monster soldier2 = new Soldier(10,10,15,10.0);
        Monster soldier3 = new Soldier(10,10,15,10.0);
        teamA.addMonster(soldier1);
        teamA.addMonster(soldier2);
        teamA.addMonster(soldier3);

        //when
        teamA.removeMonster(soldier2);
        teamA.removeMonster(soldier3);
        teamA.removeMonster(soldier1);

        //then
        Assert.assertEquals(0,teamA.getSizeTeam());
        Assert.assertFalse(teamA.isTeamIsExist());
        Assert.assertNotEquals(soldier1,teamA.getMonster(soldier1.getId()));
        Assert.assertNotEquals(soldier2,teamA.getMonster(soldier2.getId()));
    }
    @Test
    public void removeMonsterFromWrongTeam(){
        //given
        Team teamA = new Team();
        Monster soldier1 = new Soldier(10,10,15,10.0);
        Monster soldier2 = new Soldier(10,10,15,10.0);
        Monster soldier3 = new Soldier(10,10,15,10.0);

        Team teamB = new Team();
        Monster soldier4 = new Soldier(10,10,15,10.0);
        Monster soldier5 = new Soldier(10,10,15,10.0);

        teamA.addMonster(soldier1);
        teamA.addMonster(soldier2);
        teamA.addMonster(soldier3);
        teamB.addMonster(soldier4);
        teamB.addMonster(soldier5);

        //then
        //when
        Assert.assertFalse(teamA.removeMonster(soldier4));
        Assert.assertEquals(3,teamA.getSizeTeam());
        Assert.assertEquals(2,teamB.getSizeTeam());

        Assert.assertFalse(teamB.removeMonster(soldier1));
        Assert.assertEquals(3,teamA.getSizeTeam());
        Assert.assertEquals(2,teamB.getSizeTeam());

        Assert.assertTrue(teamA.removeMonster(soldier1));
        Assert.assertEquals(2,teamA.getSizeTeam());
        Assert.assertEquals(2,teamB.getSizeTeam());
    }

}
