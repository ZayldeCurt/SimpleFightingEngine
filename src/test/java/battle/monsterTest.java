package battle;


import monster.Monster;
import monster.Soldier;
import monster.Vampire;
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

    @Test
    public void VampireTestBite(){
        //Given
        Monster vampire = new Vampire(10,10,10,10.0);
        Monster victim = new Soldier(10,5,5,10.0);
        double expectLife = 11.0;
        double expectedLifeOfVictim = 5;

        //When
        SingleAttack.singleAttackInFightOneOnOne(vampire,victim);

        //Then
        Assert.assertEquals((int)(expectLife*100),(int)(vampire.getHealth()*100));
        Assert.assertEquals((int)(expectedLifeOfVictim*100),(int)(victim.getHealth()*100));
    }
    @Test
    public void VampireTestBite2(){
        //Given
        Monster vampire = new Vampire(10,10,10,10.0);
        Monster victim = new Soldier(10,5,5,10.0);
        double expectLife = 11.5;
        double expectedLifeOfVictim = 0;

        //When
        SingleAttack.singleAttackInFightOneOnOne(vampire,victim);
        SingleAttack.singleAttackInFightOneOnOne(vampire,victim);

        //Then
        Assert.assertEquals((int)(expectLife*100),(int)(vampire.getHealth()*100));
        Assert.assertEquals((int)(expectedLifeOfVictim*100),(int)(victim.getHealth()*100));
        Assert.assertFalse(victim.isAlive());
    }
    @Test
    public void VampireTestNotBite(){
        //Given
        Monster vampire = new Vampire(10,10,10,10.0);
        Monster victim = new Soldier(10,10,10,10.0);
        double expectLife = 10;
        double expectedLifeOfVictim = 10;

        //When
        SingleAttack.singleAttackInFightOneOnOne(vampire,victim);

        //Then
        Assert.assertEquals((int)(expectLife*100),(int)(vampire.getHealth()*100));
        Assert.assertEquals((int)(expectedLifeOfVictim*100),(int)(victim.getHealth()*100));
        Assert.assertTrue(victim.isAlive());
    }

}
