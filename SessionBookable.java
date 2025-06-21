/**
 * Interface for booking operations of fitness sessions
 */
public interface SessionBookable {
    /**
     * Books a participant into a session
     * @param sessionId The ID of the session
     * @param participantName Name of participant
     * @throws Exception if booking fails
     */
    void bookSession(int sessionId, String participantName) throws Exception;
    
    /**
     * Cancels a participant's booking
     * @param sessionId The ID of the session
     * @param participantName Name of participant
     * @throws Exception if cancellation fails
     */
    void cancelBooking(int sessionId, String participantName) throws Exception;
}