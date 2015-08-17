/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management.commandparser;

import management.model.User;

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
        System.out.print(mActualUser.getUsername() + "/" + "animalmanager: ");
    }

}
