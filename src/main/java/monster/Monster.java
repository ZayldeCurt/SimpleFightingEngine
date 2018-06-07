package monster;

import java.util.Objects;

public abstract class Monster {

    private int basicSpeed;
    private int basicDefensce;
    private int basicAttack;
    private double Health;
    private static int mainId=0;
    private int id;


    protected Monster(int basicSpeed, int basicDefensce, int basicAttack, double Health) {
        this.basicSpeed = basicSpeed;
        this.basicDefensce = basicDefensce;
        this.basicAttack = basicAttack;
        this.Health = Health;
        this.id=mainId++;
    }

    public int getId() {
        return id;
    }

    public int run() {
        return 1;
    }

    public int defense() {
        return getBasicDefensce();
    }

    public double attack(Monster monster){
        double demage;
        int currentAttack;

        currentAttack = this.getBasicAttack();
        demage = currentAttack-monster.defense();
        return demage<0 ? 0 : demage;
    }

    public boolean isAlive() {
        if(Health >0){
            return true;
        }
        else{
            return false;
        }
    }



    public int getBasicSpeed() {
        return basicSpeed;
    }
    public void setBasicSpeed(int basicSpeed) {
        this.basicSpeed = basicSpeed;
    }
    public int getBasicDefensce() {
        return basicDefensce;
    }
    public void setBasicDefensce(int basicDefensce) {
        this.basicDefensce = basicDefensce;
    }
    public int getBasicAttack() {
        return basicAttack;
    }
    public void setBasicAttack(int basicAttack) {
        this.basicAttack = basicAttack;
    }
    public double getHealth() {
        return Health;
    }
    public void setHealth(double health) {
        this.Health = health;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monster monster = (Monster) o;
        return id == monster.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
