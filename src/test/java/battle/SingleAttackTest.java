package battle;

import monster.Monster;
import monster.Zombie;
import org.junit.Assert;
import org.junit.Test;

public class SingleAttackTest {
    @Test
    public void testSingleAttackInFightOneOnOne(){
        //given
        Monster zombie1 = new Zombie(10,10,15,1);
        Monster zombie2 = new Zombie(10,10,12,10.0);
        boolean[] expectWhoDied = {false,true};
        //when
        boolean[] result = SingleAttack.singleAttackInFightOneOnOne(zombie1,zombie2);

        //then
        Assert.assertEquals(expectWhoDied[0],result[0]);
        Assert.assertEquals(expectWhoDied[1],result[1]);
    }

    //TODO dorobić testSingleAttackInFewOnOne

}
