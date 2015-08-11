package management.commandparser;

import management.model.User;

/**
 *
 * @author kir
 */
public class UserParser extends BaseCommandParser {

    private User mUser;

    public UserParser(User user) {
        this.mUser = user;
    }

    @Override
    public void writeCommandHeader() {
        System.out.print(mUser.getUsername() + ": ");
    }

    @Override
    public void parseCommand(String command) {
        System.out.println("Unknoun command!");
    }
}
