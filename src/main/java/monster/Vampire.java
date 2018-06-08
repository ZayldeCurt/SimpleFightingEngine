package monster;

public class Vampire extends Monster implements MonsterInterface {

    public Vampire(int basicSpeed, int basicDefensce, int basicAttack, double Health) {
        super(basicSpeed, basicDefensce, basicAttack, Health);
    }

    @Override
    public double attack(Monster monster) {
        double demage;
        int currentAttack;

        currentAttack = this.getBasicAttack();
        demage = currentAttack-monster.defense();

        if(demage>0 && monster.getBasicDefensce()<this.getBasicAttack()){
            this.bite(monster);
        }
        return demage<0 ? 0 : demage;
    }

    public void bite(Monster victim){
        double victimHealth = victim.getHealth();
        setHealth(this.getHealth()+(victimHealth/10));
    }



}
