/**
 * Class for Zumba sessions
 */
public class ZumbaClass extends FitnessSession {
    private final String danceStyle;
    private final int caloriesBurned;
    
    /**
     * Constructor for Zumba session
     * @param name Session name
     * @param level Fitness level
     * @param day Day of week
     * @param time Start time
     * @param duration Session duration
     * @param spaces Available spaces
     * @param style Dance style
     * @param calories Estimated calories burned
     */
    public ZumbaClass(String name, String level, String day, String time, 
                      int duration, int spaces, String style, int calories) {
        super(name, level, day, time, duration, spaces);
        this.danceStyle = style;
        this.caloriesBurned = calories;
    }
    

    @Override
    public String getSessionDetails() {
        return String.format("Style: %s, Calories: %d", danceStyle, caloriesBurned);
    }
}