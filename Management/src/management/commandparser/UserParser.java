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

    public User getUser() {
        return mUser;
    }

    public void setUser(User mUser) {
        this.mUser = mUser;
    }
    @Override
    public void writeCommandHeader() {
        System.out.print(mUser.getUsername() + ": ");
    }

    @Override
    public boolean parseCommand(String command) {
        switch (command) {
            case "animalmgt" :
                startAnimalManagement();
                return true;
        }
        return super.parseCommand(command);
    }

    @Override
    protected void writeCommandList() {
        super.writeCommandList();
        System.out.println("animalmgt - запускает менеджер животных данного пользователя");
    }

    private void startAnimalManagement() {
        ParserManager.setActualParser(new AnimalManagerParser(getUser()));
    }


}
