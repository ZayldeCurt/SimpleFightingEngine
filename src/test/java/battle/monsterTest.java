package battle;


import monster.Monster;
import monster.Soldier;
import monster.Zombie;
import org.junit.Assert;
import org.junit.Test;

public class monsterTest {

    @Test
    public void ZombieTestRipOut() {
        //given
        int partOfBody = 4;
        Monster zombie = new Zombie(10,10,10,100,partOfBody,100);
        Monster soldier = new Soldier(10,10,10,10);
        int expectPartOfBody = --partOfBody;
        int expectAttack = 8;

        //when
        SingleAttack.singleAttackInFightOneOnOne(zombie, soldier);
        Zombie transparentZombie = (Zombie)zombie;

        //then
        Assert.assertEquals(expectPartOfBody,transparentZombie.getPartOfBody());
        Assert.assertEquals(expectAttack,transparentZombie.getBasicAttack());
    }
    @Test
    public void ZombieTestRipOut2() {
        //given
        int partOfBody = 4;
        Monster zombie = new Zombie(10,10,10,100,partOfBody,100);
        Monster soldier = new Soldier(10,10,10,10);
        int expectPartOfBody = 1;
        int expectAttack = 3;

        //when
        SingleAttack.singleAttackInFightOneOnOne(zombie, soldier);
        SingleAttack.singleAttackInFightOneOnOne(zombie, soldier);
        SingleAttack.singleAttackInFightOneOnOne(zombie, soldier);
        Zombie transparentZombie = (Zombie)zombie;

        //then
        Assert.assertEquals(expectPartOfBody,transparentZombie.getPartOfBody());
        Assert.assertEquals(expectAttack,transparentZombie.getBasicAttack());
    }
    @Test
    public void ZombieTestRipOut3() {
        //given
        int partOfBody = 4;
        Monster zombie = new Zombie(10,10,10,100,partOfBody,100);
        Monster soldier = new Soldier(10,10,10,10);
        int expectPartOfBody = 0;
        int expectAttack = 0;

        //when
        SingleAttack.singleAttackInFightOneOnOne(zombie, soldier);
        SingleAttack.singleAttackInFightOneOnOne(zombie, soldier);
        SingleAttack.singleAttackInFightOneOnOne(zombie, soldier);
        SingleAttack.singleAttackInFightOneOnOne(zombie, soldier);
        Zombie transparentZombie = (Zombie)zombie;

        //then
        Assert.assertEquals(expectPartOfBody,transparentZombie.getPartOfBody());
        Assert.assertEquals(expectAttack,transparentZombie.getBasicAttack());
    }


}
