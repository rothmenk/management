package management.reader;

import management.model.Dog;

/**
 *
 * @author kir
 */
public class DogReader {
// передаем параметры собаки циферками
    public static Dog readDog(String[] dogParams) {
        String name = dogParams[1];
        int health = Integer.parseInt(dogParams[2]);
        int strength = Integer.parseInt(dogParams[3]);
        int status = Integer.parseInt(dogParams[4]);
        int exp = Integer.parseInt(dogParams[5]);
        int dogType = Integer.parseInt(dogParams[6]);

        Dog dog = new Dog(name, health, strength, status, exp, dogType);
        return dog;
    }

}
