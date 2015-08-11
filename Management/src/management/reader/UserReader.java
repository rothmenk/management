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

/**
 *
 * @author kir
 */
public class UserReader {

    static public boolean isUserCreated(String username) {
        File userFile = new File(username);
        return userFile.exists();
    }

    static public User createNewUser(String username) throws IOException {
        User user = new User(username);
        File userFile = new File(username);

        if (userFile.exists()) {
            userFile.delete();
        }
        userFile.createNewFile();

        //TODO remove костыль
        user.getCats().add(new Cat("pisun"));

        writeUser(userFile, user);

        return user;
    }

    static public User readUser(String username) {
        try {
            File userFile = new File(username);
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
