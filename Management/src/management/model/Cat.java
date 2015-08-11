package management.model;

import java.util.Random;

/**
 *
 * @author kir
 */
public class Cat extends Animal {

    private static final int MAX_HEALTH_HOME = 100;
    private static final int MAX_HEALTH_WILD = 120;
    private static final int MIN_STRENGTH = 5;
    public static final int TYPE_HOME = 0;
    public static final int TYPE_WILD = 1;

    private Integer catType;

// хреновина создает дефолтного котэ с именем 
    public Cat(String name) {
        super(name);
        setCatType(TYPE_HOME);

    }
// хреновина создает котэ с именем и настройками из базы
                                                                                    // ???
    public Cat(String name, int health, int strength, int status, int experiencePoints, Integer catType) {
        super(name, health, strength, status, experiencePoints);
        setCatType(catType);
    }

    public int getCatType() {
        if (catType == null){
            setCatType(TYPE_HOME);
        }
        return catType;
    }

    public void setCatType(int catType) {
        this.catType = catType;
    }
// возвращает значение максимального здоровья при создании котэ

    @Override
    public int getMaxHealth() {
        if (getCatType() == TYPE_HOME) {
            return MAX_HEALTH_HOME;
        } else {
            return MAX_HEALTH_WILD;
        }
    }
// возвращает рандомное значение силы при создании котэ

    @Override
    public int getBasicStrength() {
        Random rand = new Random();
        return rand.nextInt(5) + MIN_STRENGTH;
    }

    @Override
    public String toString() {
        String tempResult = "";
        tempResult += "(Cat) Name: " + getName() + "," + " ";
        tempResult += "Health: " + getHealth() + "/" + getMaxHealth() + "," + " ";
        tempResult += "Strength: " + getStrength() + "," + " ";
        String typeName = "";
        switch (catType) {
            case TYPE_HOME:
                typeName = "normal cat";
                break;
            case TYPE_WILD:
                typeName = "wild cat";
                break;
        }
        tempResult += "Type: " + typeName + "," + " ";
        String statusName = "";
        switch (getStatus()) {
            case STATUS_NORMAL:
                statusName = "normal";
                break;
            case STATUS_DEAD:
                statusName = "dead";
                break;
            case STATUS_OFFLINE:
                statusName = "offline";
                break;
        }
        tempResult += "Status is: " + statusName + "," + " ";
        tempResult += "Exp: " + getExperience().toString();

        return tempResult;
    }

}
