/**
 * Class for Yoga sessions
 */
public class YogaClass extends FitnessSession {
    private final String yogaStyle;
    private final int meditationDuration;
    
    /**
     * Constructor for Yoga session
     * @param name Session name
     * @param level Fitness level
     * @param day Day of week
     * @param time Start time
     * @param duration Session duration
     * @param spaces Available spaces
     * @param style Yoga style
     * @param meditation Meditation duration
     */
    public YogaClass(String name, String level, String day, String time, 
                    int duration, int spaces, String style, int meditation) {
        super(name, level, day, time, duration, spaces);
        this.yogaStyle = style;
        this.meditationDuration = meditation;
    }
    

    @Override
    public String getSessionDetails() {
        return String.format("Style: %s, Meditation: %d mins", yogaStyle, meditationDuration);
    }
}