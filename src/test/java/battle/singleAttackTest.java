package battle;

import monster.Monster;
import monster.Soldier;
import org.junit.Assert;
import org.junit.Test;

public class singleAttackTest {
    @Test
    public void testSingleAttackInFightOneOnOne(){
        //given
        Monster soldier1 = new Soldier(10,10,15,1);
        Monster soldier2 = new Soldier(10,10,12,10.0);
        boolean[] expectWhoDied = {false,true};
        //when
        boolean[] result = SingleAttack.singleAttackInFightOneOnOne(soldier1,soldier2);

        //then
        Assert.assertEquals(expectWhoDied[0],result[0]);
        Assert.assertEquals(expectWhoDied[1],result[1]);
    }
    @Test
    public void testSingleAttackInFewOnOneWithKilling(){
        //given
        Monster attacker = new Soldier(10,10,15,10.0);
        Monster defender = new Soldier(10,10,10,1.0);
        boolean expectIsDied = false;

        //when
        boolean result = SingleAttack.singleAttackInFewOnOne(attacker,defender);


        //then
        Assert.assertEquals(expectIsDied,result);
    }
    @Test
    public void testSingleAttackInFewOnOneWithoutKilling(){
        //given
        Monster attacker = new Soldier(10,10,15,10.0);
        Monster defender = new Soldier(10,10,10,10.0);
        boolean expectIsDied = true;

        //when
        boolean result = SingleAttack.singleAttackInFewOnOne(attacker,defender);

        //then
        Assert.assertEquals(expectIsDied,result);
    }


}
