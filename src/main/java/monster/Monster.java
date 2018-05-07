package monster;

public abstract class Monster {

    private int basicSpeed;
    private int basicDefensce;
    private int basicAttack;
    private double Health;

    protected Monster(int basicSpeed, int basicDefensce, int basicAttack, double Health) {
        this.basicSpeed = basicSpeed;
        this.basicDefensce = basicDefensce;
        this.basicAttack = basicAttack;
        this.Health = Health;
    }


    public abstract double attack(Monster monster);
    public abstract int run();
    public abstract int defense();

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







}
