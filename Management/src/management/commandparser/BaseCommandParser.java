
package management.commandparser;

/**
 *
 * @author kir
 */
public abstract class BaseCommandParser {
    
    //выписываем "рут" команды
     public abstract void writeCommandHeader(); 
     //парсируем команду
     public boolean parseCommand(String command){
         switch (command){
             case "help": 
                 writeCommandList();
                 return true;
             case "exit":
                 closeProgram();
                 return true;
         }
         return false;
     } 

    protected void writeCommandList() {
        System.out.println("help - список доступных команд");
        System.out.println("exit - выход из программы");
    }

    private void closeProgram() {
        System.exit(0);
    }
     
}
