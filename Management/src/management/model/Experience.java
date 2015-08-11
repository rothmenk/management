package management.model;

/**
 *
 * @author kir
 */
public class Experience {

    public static final int BASE_LEVEL_VALUE = 1000;
    private int level;
    private int experiencePoints;
// новая цобака/котэ
    public Experience() {
        experiencePoints = 0;
        level = 1;
    }
// подгружаем уже существующую цобаку/котэ
    public Experience(int experiencePoints) {
        
        this.experiencePoints = experiencePoints;

        int tempLevel = 0;
        int tempLevelValue = BASE_LEVEL_VALUE;

        while (experiencePoints > 0) {
            tempLevel++;
            experiencePoints = experiencePoints - tempLevelValue;
            tempLevelValue = tempLevelValue * 2;
        }
        this.level = tempLevel;
    }

    
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }
        
    @Override
    public String toString() {
        String tempResult = "";
        tempResult += "Level: " + this.level + " ";
        int actualExp = experiencePoints;
        int actualExpLimit = BASE_LEVEL_VALUE;
        
        for(int i = 1; i < level; i++){
            actualExp -= actualExpLimit;
            actualExpLimit *= 2;
        }
        tempResult += "(" + actualExp + "/" + actualExpLimit + ")";
        return tempResult;
    }

    
}
