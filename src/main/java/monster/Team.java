package monster;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Team {
    private List<Monster> monsters;
    private int sizeTeam;
    private boolean teamIsExist;


    public Team() {
        this.sizeTeam = 0;
        this.teamIsExist = false;
        monsters = new ArrayList<>();
    }

    public Team(List<Monster> monsters) {
        this.monsters = monsters;
        this.sizeTeam = monsters.size();
        if(this.sizeTeam!=0){
            this.teamIsExist = true;
        }

    }

    public void addMonster(Monster monster){
        this.monsters.add(monster);
        this.sizeTeam++;
        this.teamIsExist = true;
    }
    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
        this.sizeTeam = monsters.size();
        this.teamIsExist = true;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }
    public Monster getMonster(final int index){
        if(!teamIsExist){
            return null;
        }
        Monster monster = null;
        try{
            monster = monsters.stream().filter(x->x.getId()==index).findFirst().get();
        }catch(NoSuchElementException exception){
            return null;
        }
        return monster;
    }
    public int getSizeTeam() {
        return sizeTeam;
    }

    public boolean isTeamIsExist() {
        return teamIsExist;
    }

    public boolean removeMonster(Monster monster) {
        boolean result = monsters.remove(monster);
        if(result) {
            this.sizeTeam--;
            if (sizeTeam <= 0) {
                this.teamIsExist = false;
            }
        }
        return result;
    }

    public void removeMonster(boolean[] tableOfDead) {
        for (int i = 0,j=0; i < this.getSizeTeam(); i++,j++) {
            boolean res = !tableOfDead[j];
            if (res) {
                this.removeMonster(this.getMonsters().get(i));
                i--;
            }
        }
    }

    public void removeMonster() {

        for (int i = 0; i < this.sizeTeam; i++) {
            boolean result=false;
            if(!this.monsters.get(i).isAlive()){
                result=this.removeMonster(this.monsters.get(i));
                if(result){
                    i--;
                }
            }
        }
    }
}
