package management.model;

import java.util.Random;

public class Dog extends Animal {

    private static final int MAX_HEALTH_FIGHT = 200;
    private static final int MAX_HEALTH_GUARD = 260;
    private static final int MIN_STRANGTH = 10;

    private static final int TYPE_FIGHT = 0;
    private static final int TYPE_GUARD = 1;

    private Integer dogType;

// хреновина создает дефолтного пса с именем 
    public Dog(String name) {
        super(name);
        setDogType(TYPE_FIGHT);
    }
// хреновина создает пса с именем и настройками из базы

    public Dog(String name, int health, int strength, int status, int experiencePoints, Integer dogType) {
        super(name, health, strength, status, experiencePoints);
        setDogType(dogType);
    }

    public Integer getDogType() {
        return dogType;
    }

    public void setDogType(Integer dogType) {
        this.dogType = dogType;
    }
    

// возвращает значение максимального здоровья при создании цобаки
    @Override
    public int getMaxHealth() {
        if (getDogType() == TYPE_FIGHT) {
            return MAX_HEALTH_FIGHT;
        }else{
            return MAX_HEALTH_GUARD;
        }
    }
// возвращает рандомное значение силы при создании цобаки

    @Override
    public int getBasicStrength() {
        Random rand = new Random();
        return rand.nextInt(5) + MIN_STRANGTH;
    }
// переводим все параметры собаки в стринг и записываем через ;
    @Override
    public String toString() {
        String tempResult = "";
        tempResult += "(Dog) Name: " + getName() + "," + " ";
        tempResult += "Health: " + getHealth() + "/" + getMaxHealth() + "," + " ";
        tempResult += "Strength: " + getStrength() + "," + " ";
        String typeName = "";
        switch (dogType) {
            case TYPE_FIGHT:
                typeName = "fight dog";
                break;
            case TYPE_GUARD:
                typeName = "guard dog";
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
