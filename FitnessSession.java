import java.util.ArrayList;
import java.util.List;

/**
 * Base class for all fitness session types
 */
public abstract class FitnessSession implements SessionBookable {
    private static int idCounter = 1;
    protected final int sessionId;
    protected final String sessionName;
    protected final String fitnessLevel;
    protected final String day;
    protected final String startTime;
    protected final int duration;
    protected int availableSpaces;
    protected final List<String> participants;
    
    /**
     * Constructor for base fitness session
     * @param name Name of session
     * @param level Required fitness level
     * @param day Day of week
     * @param time Start time
     * @param duration Duration in minutes
     * @param spaces Available spaces
     */
    public FitnessSession(String name, String level, String day, 
                         String time, int duration, int spaces) {
        this.sessionId = idCounter++;
        this.sessionName = name;
        this.fitnessLevel = level;
        this.day = day;
        this.startTime = time;
        this.duration = duration;
        this.availableSpaces = spaces;
        this.participants = new ArrayList<>();
    }
    
    // Getters
    public int getSessionId() { return sessionId; }
    public String getSessionName() { return sessionName; }
    public int getAvailableSpaces() { return availableSpaces; }
    
    /**
     * Displays session details in table
     */
    public void displaySessionInfo() {
        System.out.printf("| %-10d | %-12s | %-15s | %-10s | %-10s | %-8d | %-17d | %-30s |\n",
            sessionId, sessionName, fitnessLevel, day, startTime, 
            duration, availableSpaces, getSessionDetails());
    }
    
    /**
     * Updates available spaces
     */
    protected void adjustSpaces(int change) {
        availableSpaces += change;
    }
    
  
    public abstract String getSessionDetails();
    
    /**
     * Books a user into desired session
     */
    @Override
    public void bookSession(int sessionId, String participantName) throws Exception {
        validateSessionId(sessionId);
        validateParticipantName(participantName);
        
        if (availableSpaces <= 0) {
            throw new Exception("Session is full! Cannot register " + participantName);
        }
        if (participants.contains(participantName)) {
            throw new Exception(participantName + " is already registered");
        }
        
        participants.add(participantName);
        adjustSpaces(-1);
        System.out.println("Booking successful! for " + participantName);
    }
    
    /**
     * Cancels a participant's booking
     */
    @Override
    public void cancelBooking(int sessionId, String participantName) throws Exception {
        validateSessionId(sessionId);
        validateParticipantName(participantName);
        
        if (!participants.contains(participantName)) {
            throw new Exception(participantName + " is not registered");
        }
        
        participants.remove(participantName);
        adjustSpaces(1);
        System.out.println("Cancellation processed for " + participantName);
    }
    
    // Validation methods
    private void validateSessionId(int id) throws Exception {
        if (this.sessionId != id) {
            throw new Exception("Invalid session ID");
        }
    }
    
    private void validateParticipantName(String name) throws Exception {
        if (name == null || name.trim().isEmpty()) {
            throw new Exception("Participant name cannot be empty");
        }
    }
}