package gameIF;

/**
 * Interface to be implemented by a class that represents the Player.
 */
public interface Player extends  Entity{

    /**
     * Return an integer describing the orientation of the player an integer representing the direction in which the
     * player is facing
     * @return an integer representing the direction in which the player is facing where 0=up, 1=right, 2=down, 3=left
     */
    int getOrientation();

    /**
     * Set the orientation of the player
     * @param orientation An integer describing the orientation of the player. Values are as described in the javadoc
     *                    for getOrientation
     */
    void setOrientation(int orientation);
}
