package management.reader;

import management.model.Cat;

/**
 *
 * @author kir
 */
public class CatReader {
// передаем параметры животного циферками
    public static Cat readCat(String[] catParams) {
        String name = catParams[1];
        int health = Integer.parseInt(catParams[2]);
        int strength = Integer.parseInt(catParams[3]);
        int status = Integer.parseInt(catParams[4]);
        int exp = Integer.parseInt(catParams[5]);
        int catType = Integer.parseInt(catParams[6]);

        Cat cat = new Cat(name, health, strength, status, exp, catType);
        return cat;
    }

}
