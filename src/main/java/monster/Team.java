package monster;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Team {
    private List<Monster> monsters;
    private int sizeTema;
    private boolean teamIsExist;


    public Team() {
        this.sizeTema = 0;
        this.teamIsExist = false;
        monsters = new ArrayList<>();
    }

    public void addMonster(Monster monster){
        this.monsters.add(monster);
        this.sizeTema++;
        this.teamIsExist = true;
    }
    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
        this.sizeTema = monsters.size();
        this.teamIsExist = true;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }
    public Monster getMonster(int index){
        if(!teamIsExist){
            return null;
        }
        Monster monster = monsters.get(index);
        if(monster.getId()==index){
            return monster;
        }else{
            return null;
        }

    }
    public int getSizeTeam() {
        return sizeTema;
    }

    public boolean isTeamIsExist() {
        return teamIsExist;
    }

    public boolean removeMonster(Monster monster) {
        boolean result = monsters.remove(monster);
        if(result) {
            this.sizeTema--;
            if (sizeTema <= 0) {
                this.teamIsExist = false;
            }
        }
        return result;
    }
}
