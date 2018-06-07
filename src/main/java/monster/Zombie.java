package monster;

import java.util.Random;

public class Zombie extends Monster implements MonsterInterface  {

    private int partOfBody;
    private int chanceToDivision;

    public Zombie(int basicSpeed, int basicDefensce, int basicAttack, double Health, int partOfBody, int chanceToDivision) {
        super(basicSpeed, basicDefensce, basicAttack, Health);
        this.partOfBody = partOfBody;
        if(chanceToDivision>100){
            this.chanceToDivision=100;
        }else if(chanceToDivision<0){
            this.chanceToDivision=0;
        }else{
            this.chanceToDivision = chanceToDivision;
        }
    }

    @Override
    public int defense() {
        Random random = new Random();
        if(random.nextInt(100)<chanceToDivision){
            ripOut();
            if(this.partOfBody<=0){
                setBasicAttack(0);
            }else{
                double newAttack =(double)getBasicAttack()-(double)getBasicAttack()*(1.0/(partOfBody+1));
                setBasicAttack((int)Math.round(newAttack));
            }
        }
        return super.defense();
    }

    private void ripOut(){
        this.partOfBody--;
    }

    public int getPartOfBody() {
        return partOfBody;
    }
    public void setPartOfBody(int partOfBody) {
        this.partOfBody = partOfBody;
    }
    public int getChanceToDivision() {
        return chanceToDivision;
    }
    public void setChanceToDivision(int chanceToDivision) {
        this.chanceToDivision = chanceToDivision;
    }


}
