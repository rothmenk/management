
package management.commandparser;

/**
 *
 * @author kir
 */
public abstract class BaseCommandParser {
    
     public abstract void writeCommandHeader(); //выписываем "рут" команды
     public abstract void parseCommand(String command); //парсируем команду
     
}
