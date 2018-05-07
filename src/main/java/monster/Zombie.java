package monster;

public class Zombie extends Monster implements MonsterInterface  {
    public Zombie(int basicSpeed, int basicDefensce, int basicAttack, double Health) {
        super(basicSpeed, basicDefensce, basicAttack, Health);
    }

    public double attack(Monster monster) {
        double demage;
        int currentAttack;

        currentAttack = this.getBasicAttack();
        demage = currentAttack-monster.defense();
        return demage<0 ? 0 : demage;
    }

    public int run() {
        return 1;
    }

    public int defense() {
        return getBasicDefensce();
    }

//    public boolean isAlive() {
//        return true;
//    }


}
