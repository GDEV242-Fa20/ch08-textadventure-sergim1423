//import java.util.Iterator;
import java.util.HashMap;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Sergius Manolov
 * @version 10/27/20
 */

public class CommandWords
{
    // A mapping between a command word and the CommandWord
    // associated with it.
    private HashMap<String, CommandWord> validCommands;
    //constand array that holds all valid command words
        private static final String[] CommandValid= {
            "go", "quit", "help", "look","eat", "back"
        };
    
    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        validCommands = new HashMap<>();
        for(CommandWord command : CommandWord.values()) {
            if(command != CommandWord.UNKNOWN) {
                validCommands.put(command.toString(), command);
            }
        }
    }
    /**
     * Returns all valid commads.
     */
    public String getCommandList()
    {
        String returnString="";
        for (String command : CommandValid)
        {
            returnString = returnString + command + "";
        }
        return returnString;
    }
    
    /**
     * Find the CommandWord associated with a command word.
     * @param commandWord The word to look up.
     * @return The CommandWord correspondng to commandWord, or UNKNOWN
     *         if it is not a valid command word.
     */
    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = validCommands.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return CommandWord.UNKNOWN;
        }
    }
    
    /**
     * Check whether a given String is a valid command word. 
     * @return true if it is, false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    }

    /**
     * Print all valid commands to System.out.
     */
    public void showAll() 
    {
        for(String command : validCommands.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
        /**
     * Print all valid commands to System.out. Supposed to be the
     * new println but doesnt work
     */
    /*public void showAll()
    {
        for(String command : validCommands)
        {
            System.out.print(command + "");
        }
        System.out.println();
    }*/
    }
}
