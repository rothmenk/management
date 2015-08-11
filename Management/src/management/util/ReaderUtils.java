package management.util;



/**
 *
 * @author kir
 */
public class ReaderUtils {
    
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
