package management.reader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import management.model.Animal;
import management.model.Cat;
import management.model.Dog;
import management.model.User;
import management.model.UserAdmin;

/**
 *
 * @author kir
 */

// читаем юзера
public class UserReader {
// подключаемся к файлику с пользователем
    private static String USER_DATA_PATH = "userdata/users/";
// если пользователь существует грузим его файл    
    static public boolean isUserCreated(String username) {
        File userFile = new File(USER_DATA_PATH + username);
        return userFile.exists();
    }
// ежели нет создаем файл с именем юзера и записываем в него параметры нового пользователя
    static public User createNewUser(String username){
        User user = new User(username);
        File userFile = new File(USER_DATA_PATH + username);

        if (userFile.exists()) {
            userFile.delete();
        }
        try {
            userFile.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(UserReader.class.getName()).log(Level.SEVERE, null, ex);
        }

        writeUser(userFile, user);

        return user;
    }
    
    static public boolean removeUser(String username){
         File userFile = new File(USER_DATA_PATH + username);
         return userFile.delete();
    }
    
// если юзер все же существует считываем данные из файлика
    static public User readUser(String username) {
        if(username.equalsIgnoreCase("admin")){
            return new UserAdmin("admin");
        }
        try { // пытаемся открыть файлик и считываем данные построчно (в правильном порядке)
            File userFile = new File(USER_DATA_PATH + username);
            Scanner sc = new Scanner(userFile);
            String name = sc.nextLine();
            int money = Integer.parseInt(sc.nextLine());
            String temp;
            ArrayList<Dog> dogs = new ArrayList<>();
            ArrayList<Cat> cats = new ArrayList<>();

            while (sc.hasNext()) {
                temp = sc.nextLine();
                Animal tempAnimal = AnimalReader.readAnimal(temp);
                if (tempAnimal.getClass() == Cat.class) {
                    cats.add((Cat) tempAnimal);
                } else {
                    dogs.add((Dog) tempAnimal);
                }
            }

            return new User(name, money, dogs, cats);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserReader.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
// если информация изменилась (новый пользователь, измененный пользователь) записываем его данные
// в файлик в виде строки через ;    
    public static void writeUser(File file, User user) {
        try {
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter out = new BufferedWriter(writer);
            out.append(user.getUsername() + "\n");
            out.append(Integer.toString(user.getMoney()) + "\n");

            for (Dog d : user.getDogs()) {
                out.append("Dog" + ";");
                out.append(d.getName() + ";");
                out.append(Integer.toString(d.getHealth()) + ";");
                out.append(Integer.toString(d.getStrength()) + ";");
                out.append(Integer.toString(d.getStatus()) + ";");
                out.append(Integer.toString(d.getExperience().getExperiencePoints()) + "\n");
                out.append(Integer.toString(d.getDogType()) + "\n");
            }
            for (Cat c : user.getCats()) {
                out.append("Cat" + ";");
                out.append(c.getName() + ";");
                out.append(Integer.toString(c.getHealth()) + ";");
                out.append(Integer.toString(c.getStrength()) + ";");
                out.append(Integer.toString(c.getStatus()) + ";");
                out.append(Integer.toString(c.getExperience().getExperiencePoints()) + ";");
                out.append(Integer.toString(c.getCatType()) + "\n");
            }
            out.flush();
            out.close();

        } catch (IOException ex) {
            Logger.getLogger(UserReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
