package management.commandparser;

import java.util.Scanner;
import management.model.User;

/**
 *
 * @author kir
 */
public class ParserManager {
    
    private static final Scanner sc = new Scanner(System.in);    
    private static BaseCommandParser sActualParser;
    
    public static BaseCommandParser getActualParser() {
        return sActualParser;
    }
    
    public static void setActualParser(BaseCommandParser actualParser) {
        ParserManager.sActualParser = actualParser;
    }
    
    public static void startParsingCommands(User user) {
         if (!user.isAdmin()) {
            setActualParser(new UserParser(user));
        } else {
            setActualParser(new AdminParser(user));
        }
         
        while (true) {
            getActualParser().writeCommandHeader();
            String command = sc.nextLine();
            getActualParser().parseCommand(command);
        }
    }
    
}
