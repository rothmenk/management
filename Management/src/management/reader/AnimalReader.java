package management.reader;

import management.model.Animal;

/**
 *
 * @author kir
 */
public class AnimalReader {
// считываем животных, в зависимости от типа животного вызываем метод предка
    public static Animal readAnimal(String animalString) {
        String[] animalParams = animalString.split(";");

        if (isCat(animalParams[0])) {
            return CatReader.readCat(animalParams);
        } else {
            return DogReader.readDog(animalParams);
        }
    }
// проверяем тип животного (в начале каждой строки с животным)
    private static boolean isCat(String animalParam) {
        if (animalParam.equalsIgnoreCase("cat")) {
            return true;
        } else if (animalParam.equalsIgnoreCase("dog")) {
            return false;
        } else {
            //TODO handle error
            return false;
        }
    }
}
// comments