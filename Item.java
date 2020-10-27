
/**
 * Item class holds info about the items
 * Contains info about item description and weight of the items.
 *
 * @author Sergius Manolov
 * @version 10/27/20
 */
public class Item
{
    // instance variables 
    private String itemDescription;
    private int itemWeight;

    /**
     * Constructor for objects of class Item
     */
    public Item()
    {
        // initialise instance variables
        itemDescription = "";
        itemWeight = 0;
    }

    /**
     * Constructor for objects of class Item
     * sets instance variables with parameter values
     */
    public Item(String description, int weight)
    {
        //initialize instance variables
        itemDescription=description;
        itemWeight = weight;
    }
    /**
     * Returns description of items in the room
     */
    public String getItemDescription()
    {
        String itemString = "Item Description:";
        itemString += this.itemDescription +"\n";
        itemString += "Item Weight: "+this.itemWeight;
        return itemString;
    }
}

