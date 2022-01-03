package gameIF;

/**
 * An interface describing responses to requests to perform operations
 */
public interface Response {
    /**
     * Get the status of the Response, as described in the coursework specification.
     * @return The status of the Response, as described in the coursework specification.
     */
    boolean getStatus();

    /**
     * Get the message associated with the Response, as described in the coursework specification.
     * @return The message associated with the Response, as described in the coursework specification.
     */
    String getMessage();
}
