/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * creating back command back one room
     */
    private Room prevRoom=null;
    
    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, theater, pub, lab, office, conference, shed, 
        dorm, basement, gym, library, courts, dining, cafeteria, nurse;
        // Item reference variables
        Item outside_Item, theater_Item, pub_Item,lab_Item,
        office_Item, conference_Item, shed_Item, dorm_Item, basement_Item
        , gym_Item, library_Item, courts_Item, dining_Item, cafeteria_Item
        , nurse_Item;
        conference_Item= new Item("Chairs: To sit on, to"+
        "relax"+"Pass time",0);
        shed_Item= new Item("Storage: To keep equipment in",600);
        dorm_Item= new Item("Beds: To sleep on, to"+
        "relax"+"Study",400);
        basement_Item= new Item("Stores files: To gather information, to"+
        "keep records",50);
        gym_Item= new Item("Bench: To benchpress on, to"+
        "lift wieghts"+"workout",500);
        library_Item= new Item("Books: To read, to"+
        "relax"+"gain knowledge",20);
        courts_Item= new Item("Basketball hoops: To play on, to"+
        "workout"+"Have fun ",200);
        dining_Item= new Item("Tables: To sit on, to"+
        "eat on"+"Have fun with friends",300);
        cafeteria_Item= new Item("Cash register: To collect money , to"+
        "accept money for food",60);
        nurse_Item= new Item("Tylenol: To clear headaches, to"+
        "relax"+"To cure illnesses",30);
        outside_Item = new Item("Ball: To play with, to"+
        "relieve stress"+"Pass time",0);
        theater_Item = new Item("Screen: To watch plays"+ 
        "To present videos" +"Enteraintment", 300);
        pub_Item = new Item("Drinks: Cola"+ "Any drink you desire"
        , 55);
        lab_Item = new Item("Computers: To do work"+ 
        "Access the internet", 700);
        office_Item = new Item("Printer: Prints files"+
        "Makes copies", 500);
        // create the rooms
        outside = new Room("outside the main entrance of the university",
        outside_Item);
        theater = new Room("in a lecture theater",
        theater_Item);
        pub = new Room("in the campus pub",
        pub_Item);
        lab = new Room("in a computing lab",
        lab_Item);
        office = new Room("in the computing admin office",
        office_Item);
        conference = new Room("in a school meeting room",
        conference_Item);
        shed = new Room("outside across from courts",
        shed_Item);
        dorm = new Room("in the college for students",dorm_Item);
        basement= new Room("under the college next to lab room"
        ,basement_Item);
        gym= new Room("in the gym above the cafeteria",gym_Item);
        library= new Room("library room for students to study across of conference room"
        , library_Item);
        courts= new Room("outside of college for sports",courts_Item);
        dining= new Room("in cafeteria for eating",dining_Item);
        cafeteria= new Room("holds dining room and stores food"
        ,cafeteria_Item);
        nurse= new Room("next to gym to help with injuries and illnesses"
        ,nurse_Item);
        //create Item objects
        Item outsideItems[] = { new Item("Nothing",0),
            new Item("Bench",0),
            new Item("Tables", 50)};
            Item theaterItem[] = {
                new Item("Laptop", 400),
                new Item("Seats", 30)};
              Item pubItem[] = { new Item("Cups",20),
                  new Item("Speakers",600)};
                  Item officeItem[]={new Item("Couch",300),
                      new Item("Stapler", 30)};
                      Item labItem[]={
                          new Item("Chairs",40),
                          new Item("Smartphones", 50)};
        Item conferenceItems[] ={
            new Item("Bagels",20),
            new Item("Coffee Machine", 60)}; 
        Item shedItems[] ={
            new Item("Balls",0),
            new Item("Rackets",10)};
        Item dormItems[] ={
        new Item("Posters",5),
        new Item("Pillows",20)};
        Item basementItems[]={
            new Item("Cabinets",50),
            new Item("Lights",30)};
        Item gymItems[]={
            new Item("Weights",100),
            new Item("Bar",45)};
        Item libraryItems[]={
            new Item("Desks",40),
            new Item("Couch", 60)};
        Item courtsItems[]={
            new Item("Soccer courts", 400),
            new Item("Volleyball courts", 600)};
        Item diningItems[]={
            new Item("Forks",10),
            new Item("Spoon",10)};
        Item cafeteriaItems[]={
            new Item("Trays",15),
            new Item("Change",0)};
        Item nurseItems[]={
            new Item("Thermometer",20),
            new Item("Icepacks",30)};
        //aray of item objects into their rooms
        outside=addItemsToRoom(outside,outsideItems);
        theater=addItemsToRoom(theater,theaterItem);
        pub=addItemsToRoom(pub,pubItem);              
        lab=addItemsToRoom(lab,labItem);
        office=addItemsToRoom(office,officeItem);
        conference=addItemsToRoom(conference,conferenceItems);
        shed=addItemsToRoom(shed,shedItems);
        dorm=addItemsToRoom(dorm,dormItems);
        basement=addItemsToRoom(basement,basementItems);
        gym=addItemsToRoom(gym,gymItems);
        library=addItemsToRoom(library,libraryItems);
        courts=addItemsToRoom(courts,courtsItems);
        dining=addItemsToRoom(dining,diningItems);
        cafeteria=addItemsToRoom(cafeteria,cafeteriaItems);
        nurse=addItemsToRoom(nurse,nurseItems);
        
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);
        conference.setExit("east",library);
        shed.setExit("north",courts);
        dorm.setExit("west",cafeteria);
        basement.setExit("south",library);
        gym.setExit("east",nurse);
        library.setExit("west",conference);
        library.setExit("north",basement);
        courts.setExit("east",shed);
        dining.setExit("west",cafeteria);
        dining.setExit("east",outside);
        cafeteria.setExit("east",dining);
        cafeteria.setExit("north",theater);
        nurse.setExit("south",lab);
        nurse.setExit("west",gym);

        currentRoom = outside;  // start game outside
    }

    /**
     * Add the array of items to the room and return room object
     */
    private Room addItemsToRoom(Room room, Item items[])
    {
        for(int i=0;i<items.length; i++)
        {
            room.addItem(items[i]);
        }
        return room;
    }
    
    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;
        
        if(command.isUnknown())
        {
            System.out.println("I don't know what you mean...");
            return false;
        }
        String commandWord = command.getCommandWord();
        if(commandWord.equals("help"))
        printHelp();
        else if (commandWord.equals("go"))
        goRoom(command);
        else if (commandWord.equals("quit"))
        wantToQuit=quit(command);
        else if (commandWord.equals("look"))
        look();
        else if (commandWord.equals("eat"))
        System.out.println( "You have eaten now and you are not hungry anymore");
        else if (commandWord.equals("back"))
        backRoom();
        /*CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
            case LOOK:
                look(command);
                break; 
        */
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        String str = parser.showCommands();
        System.out.println(str);
    }

    

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            prevRoom = currentRoom;
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }
    /**
     * go back to previous room and display room info
     */
    private void backRoom()
    {
        currentRoom=prevRoom;
        System.out.println(currentRoom.getLongDescription());
    }
    
    /**
     * prints current room descripion with available exits.
     * Prints exists if the room has exits.
     */
   
     private void look()
    {
    System.out.println(currentRoom.getLongDescription());
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
