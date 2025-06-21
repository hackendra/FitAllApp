/**
 * Class for Pilates sessions
 */
public class PilatesClass extends FitnessSession {
    private final String equipment;
    private final String focusLevel;
    
    /**
     * Constructor for Pilates session
     * @param name Session name
     * @param level Fitness level
     * @param day Day of week
     * @param time Start time
     * @param duration Session duration
     * @param spaces Available spaces
     * @param equipment Required equipment
     * @param focus Core focus level
     */
    public PilatesClass(String name, String level, String day, String time, 
                       int duration, int spaces, String equipment, String focus) {
        super(name, level, day, time, duration, spaces);
        this.equipment = equipment;
        this.focusLevel = focus;
    }
    
  
    @Override
    public String getSessionDetails() {
        return String.format("Equipment: %s, Focus: %s", equipment, focusLevel);
    }
}