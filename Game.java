package gameIF;

/**
 * Interface to be implemented by classes that can represent and alter the game state.
 */
public interface Game {
    /**
     * Get the number of columns on the board
     * @return The number of columns on the board on which the game is played
     */
    int getWidth();

    /**
     * Get the number of rows on the board
     * @return The number of rows on the board on which the game is played
     */
    int getHeight();

    /**
     * Get the entity at a particular column and row on the board
     * @param column Column index (indexes start at 0)
     * @param row Row index (indexes start at 0)
     * @return The entity at the specified column and row, or null if there is no entity on that square
     */
    Entity getEntityAt(int column, int row);

    /**
     * Add an entity to the game
     * @param entity Entity to be added
     * @param column Column on which the entity is to be added
     * @param row Row on which the entity is to be added
     * @return true if the entity was successfully added false otherwise. If the specified column/row are already
     * occupied or outside the board then the method should return false and should not change the state of the board
     */
    boolean addEntity(Entity entity, int column, int row);

    /**
     * Move the player forward by one square in the direction in which she is facing
     * @return A Response object indicating whether or not the player moved. If the move would take the player onto a
     * square that is already occupied or outside the board then the status of the Response should be false and the
     * state of the board should be unchanged
     */
    Response step();

    /**
     * Change the direction in which the player is facing
     * @param orientation an integer representing the direction in which the player is
     *                    facing, where 0=up, 1=right, 2=down, 3=left
     */
    void turn(int orientation);

    /**
     * Get the column on which the player is situated
     * @return the column on which the player is situated
     */
    int getPlayerX();

    /**
     * Get the row on which the player is situated
     * @return the row on which the player is situated
     */
    int getPlayerY();

    /**
     * Get the player
     * @return the player
     */
    Player getPlayer();

    /**
     * Get the NPC in the facing square
     * @return The NPC in the facing square, if there is one, otherwise null
     */
    NPC getFacingNPC();

    /**
     * Send a request to the facing entity.
     * @param request The request to be processed
     * @return A Response object indicating whether the request was executed and containing any other relevant
     * information (see coursework specification)
     */
    Response requestFacing(String request);
}
