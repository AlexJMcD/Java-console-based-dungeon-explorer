package gameIF;

import java.util.ArrayList;

/**
 * Interface to be implemented by classes representing non-player characteres
 */

public interface NPC extends Entity {
    /**
     * Get a description of the NPC
     * @return A description of the NPC
     */
    String getDescription();

    /**
     * Get a list of strings describing all the requests that the NPC can respond to. It is up to the developer to
     * decide how to represent list. As an example, if the class represented a merchant who can trade in rocks and gems
     * then the list returned might contain the strings "buy [rock|gem]" and "sell [rock|gem]"
     * @return
     */
    ArrayList<String> getPossibleRequests();

    /**
     * Perform a request. The way in which this method is to be used is described in the coursework specification
     * @param request The request to be performed.
     * @return A Response object describing the result of performing the request. The form of this Response is described
     * in the coursework specification.
     */
    Response performRequest(String request, Player player);
}
