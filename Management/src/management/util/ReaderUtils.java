package management.util;

import java.util.Scanner;



/**
 *
 * @author kir
 */
public class ReaderUtils {
    private static final Scanner sc = new Scanner(System.in);
    
    public static boolean confirmAction(String message){
        System.out.println(message + " (yes/no)");
        String command = sc.nextLine();
        return isYes(command);
    }
    
    public static boolean isYes (String command){
        if(command.equalsIgnoreCase("yes") || command.equalsIgnoreCase("y")){
            return true;
        }else if (command.equalsIgnoreCase("no") || command.equalsIgnoreCase("n")){
            return false;
        }else{
            System.out.println("Incorrect input. Command readed as \"no\"");
            return false;
        }
    }
}
