package gameIF;

/**
 * Interface to be implemented by classes that create games
 */
public interface GameCreator {
    /**
     * Create an instance of the Game interface for a particular game. You should use this method to populate the board
     * with NPCs of your choice, and place the player where you want her to start.
     * @return An instance of the Game interface
     */
    Game createGame();
}
