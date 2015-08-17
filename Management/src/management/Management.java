package management;

import com.sun.imageio.plugins.common.ReaderUtil;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import management.commandparser.ParserManager;
import management.model.User;
import management.reader.UserReader;
import management.util.ReaderUtils;

/**
 *
 * @author kir
 */
public class Management {

    static Scanner commandScanner = new Scanner(System.in);
    static User actualUser;
    
// инициализация пользователя и ожидание ввода команд
    public static void main(String[] args) {
        init();
        ParserManager.startParsingCommands(actualUser);
    }

    static void init() {
        System.out.print("Enter username: ");
        String userName = commandScanner.nextLine();
        String command;
// если пользователь существует - загружаем его данные из файла
        if (UserReader.isUserCreated(userName)) {
            actualUser = UserReader.readUser(userName);
            System.out.println("Login completed");
        } else { // если нет - предлагаем создать нового
            System.out.println("Profile not found, create new profile?");
            command = commandScanner.next();
//если соглашаемся создать - создаем нового дефолтного пользователя с данным именем
            if (ReaderUtils.isYes(command)) {
                actualUser = UserReader.createNewUser(userName);
            } else { // или просим залогиниться заново
                while (true) {
                    System.out.println("Enter username again: ");
                    userName = commandScanner.next();
                    if (UserReader.isUserCreated(userName)) {
                        actualUser = UserReader.readUser(userName);
                        break;
                    }
                }
            }
        }
        if (!actualUser.isAdmin()) {
            System.out.println(actualUser);
        }
    }

    
}
