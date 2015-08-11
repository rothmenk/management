
package management.commandparser;

/**
 *
 * @author kir
 */
public abstract class BaseCommandParser {
    
     public abstract void writeCommandHeader();
     public abstract void parseCommand(String command);
     
}
