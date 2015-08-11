package management.model;
/**
 *
 * @author kir
 */
public abstract class Animal {

    public static final int STATUS_NORMAL = 0;
    public static final int STATUS_DEAD = 1;
    public static final int STATUS_OFFLINE = 2;
    
    private String name;
    private int health;
    private int strength;
    private int status;
    private Experience experience;

    // дефолтное животное с именем и стоковыми параметрами
    public Animal(String name){
        this.name = name;
        this.health = getMaxHealth();
        this.strength = getBasicStrength();
        this.status = STATUS_NORMAL;
        this.experience = new Experience();
    }
    
    // существующее животное с именем и параметрами из базы данных
    public Animal(String name, int health, int strength, int status, int experiencePoints) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.status = status;
        this.experience = new Experience(experiencePoints);

    }
    
    
    
// возвращает дефолтное значение жизней или силы в зависимости от типа животины    
    public abstract int getMaxHealth();
    public abstract int getBasicStrength();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }
}