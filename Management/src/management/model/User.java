package management.model;

import java.util.ArrayList;

public class User {

    public static final int START_MONEY = 1000;
    private static final boolean IS_ADMIN = false;

    String username;
    int money;
    ArrayList<Dog> dogs;
    ArrayList<Cat> cats;

// когда юзер только что создан делаем его дефолтным
    public User(String username) {
        this.username = username;
        this.money = START_MONEY;
        this.dogs = new ArrayList<Dog>();
        this.cats = new ArrayList<Cat>();
    }
// если юзер существует берем его данные из файла
    public User(String username, int money, ArrayList<Dog> dogs, ArrayList<Cat> cats) {
        this.username = username;
        this.money = money;
        this.dogs = dogs;
        this.cats = cats;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public ArrayList<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(ArrayList<Dog> dogs) {
        this.dogs = dogs;
    }

    public ArrayList<Cat> getCats() {
        return cats;
    }

    public void setCats(ArrayList<Cat> cats) {
        this.cats = cats;
    }
    
    public boolean isAdmin(){
        return IS_ADMIN;
    }
    
// переводим данные юзера в строку и выписываем красиво    
    @Override
    public String toString() {
        String tempResult = "";
        
        tempResult += "Name: " + this.username + "\n";
        tempResult += "Money: " + this.money + "$\n";
        
        for(Dog d: dogs){
            tempResult += d.toString() + "\n";
        }
        
        for(Cat c: cats){
            tempResult += c.toString() + "\n";
        }
        
        return tempResult;
    }
    
    

}
