package management.commandparser;

import java.util.Scanner;
import management.model.Animal;
import management.model.User;
import management.util.ReaderUtils;

/**
 *
 * @author kir
 */
public class AnimalManagerParser extends BaseCommandParser {

    private User mActualUser;

    public AnimalManagerParser(User user) {
        this.mActualUser = user;
    }

    public User getActualUser() {
        return mActualUser;
    }

    public void setActualUser(User mActualUser) {
        this.mActualUser = mActualUser;
    }

    @Override
    public void writeCommandHeader() {
        getActualUser().writeAnimalList();
        System.out.print(mActualUser.getUsername() + "/" + "animalmanager: ");
    }

    @Override
    protected void writeCommandList() {
        super.writeCommandList();
        System.out.println("remove *имя животного* - удаляет животное по имени");
        System.out.println("status *имя животного* - меняет статус животного");
    }

    @Override
    public boolean parseCommand(String command) {
        String[] commandSegments = command.split(" ");
        switch (commandSegments[0]) {
            case "remove":
                if (commandSegments.length > 1) {
                    removeAnimal(commandSegments[1]);
                    return true;
                } else {
                    System.out.println("remove: отсутствует имя животного");
                    return true;
                }
            case "status":
                if (commandSegments.length > 1) {
                    changeStatusAnimal(commandSegments[1]);
                    return true;
                } else {
                    System.out.println("status: отсутствует имя животного");
                    return true;
                }
        }

        return super.parseCommand(command);
    }

    private void removeAnimal(String animalName) {
        if (ReaderUtils.confirmAction("Удалить это животное?")) {
            for (Animal a : getActualUser().getAnimals()) {
                if (a.getName().equalsIgnoreCase(animalName)) {
                    getActualUser().removeAnimal(a);

                    System.out.println("Животное с именем " + animalName + " успешно удалено");

                    return;
                }
            }

            System.out.println("Животное с именем " + animalName + " не было найдено");

        } else {
            return;
        }

    }

    private void changeStatusAnimal(String animalName) {
        Animal animalToChange = null;
        for (Animal a : getActualUser().getAnimals()) {
            if (a.getName().equalsIgnoreCase(animalName)) {
                animalToChange = a;
            }
        }
        if (animalToChange == null) {
            System.out.println("Животное с именем " + animalName + " не было найдено");
            return;
        }
        System.out.println("Установите статус животного: ");
        String command;
        do {
            Animal.writeStatusList();
            command = sc.nextLine();
        } while (!animalToChange.setStatus(command));
    }

}
