/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management.model;

/**
 *
 * @author kir
 */
public class UserAdmin extends User{
    
    private static final boolean IS_ADMIN = true;

    public UserAdmin(String username) {
        super(username);
    }
    @Override
    public boolean isAdmin(){
        return IS_ADMIN;
    }
    
}
