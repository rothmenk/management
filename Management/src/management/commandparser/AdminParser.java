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
public class AdminParser extends UserParser {

    public AdminParser(User user) {
        super(user);
    }

    @Override
    public void writeCommandHeader() {
        System.out.print("admin: ");
    }

    @Override
    public void parseCommand(String command) {
        System.out.println("Unknoun command!");
    }

}
