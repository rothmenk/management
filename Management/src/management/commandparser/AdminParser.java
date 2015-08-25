package management.commandparser;

import management.model.User;
import management.reader.UserReader;

/**
 *
 * @author kir
 */
public class AdminParser extends BaseCommandParser {

    public AdminParser() {
        super();
    }

    @Override
    public void writeCommandHeader() {
        System.out.print("admin: ");
    }

    @Override
    public boolean parseCommand(String command) {
        String[] commandSegments = command.split(" ");
        switch (commandSegments[0]) {
            case "create":
                if (commandSegments.length > 1) {
                    createUser(commandSegments[1]);
                    return true;
                } else {
                    System.out.println("create: отсутствует имя пользователя");
                    return true;
                }
            case "remove":
                if (commandSegments.length > 1) {
                    removeUser(commandSegments[1]);
                    return true;
                } else {
                    System.out.println("remove: отсутствует имя пользователя");
                    return true;
                }
        }
        return super.parseCommand(command);
    }

    @Override
    protected void writeCommandList() {
        super.writeCommandList();
        System.out.println("create *username* - создает нового пользователя с именем username");
        System.out.println("remove *username* - удаляет пользователя с именем username");
    }

    private void createUser(String userName) {
        UserReader.createNewUser(userName);
        System.out.println("Новый пользователь " + userName + " создан");
    }

    private void removeUser(String userName) {
        if (UserReader.removeUser(userName)) {
            System.out.println("Пользователь" + userName + " был удалён");
        } else {
            System.out.println("Ошибка! Пользователь " + userName + " не был найден");
        }
    }

}
