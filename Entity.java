package gameIF;

import java.util.ArrayList;

/**
 * Base interface for Entities.
 */
public interface Entity {
    /**
     * Get the entity code
     * @return the Unicode character that represents this entity
     */
    char getCode();

    /**
     * Get a list containing the names of all the items that the entity may possess
     * @return A list containing the names of all the items that the entity can possess
     */
    ArrayList<String> getItemNames();

    /**
     * Set the number of units of an item owned by this entity
     * @param name The name of the item
     * @param quantity The number of units of the item that this entity will own after execution of the method
     */
    void setItemQuantity(String name, int quantity);

    /**
     * Get the number of units of a particular item possessed by this entity
     * @param ItemName Name of the item
     * @return Number of units of the item possessed by the player
     */
    int getItemQuantity(String ItemName);
}
