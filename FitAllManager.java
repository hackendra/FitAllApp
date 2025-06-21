import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FitAllManager {
    private final List<FitnessSession> sessions;
    private final Scanner scanner;
    
    public static void main(String[] args) {
        FitAllManager manager = new FitAllManager();
        manager.run();
    }
    
    public FitAllManager() {
        this.sessions = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        initializeSessions();
    }
    
    /**
     * Loop for main appliation
     */
    public void run() {
        boolean running = true;
        
        while (running) {
            displayMenu();
            int choice = getMenuChoice();
            
            switch (choice) {
                case 1 -> displayAllSessions();
                case 2 -> processBooking();
                case 3 -> processCancellation();
                case 4 -> running = false;
                default -> System.out.println("Invalid option, please try again.");
            }
        }
        
        System.out.println("Thank you for using FitAll Manager. Goodbye!");
        scanner.close();
    }
    
    /**
     * Presents the user with a menu of options
     */
    private void initializeSessions() {
        sessions.add(new YogaClass("Morning Yoga", "Beginner", "Monday", "09:00", 
                                  60, 15, "Hatha", 10));
        sessions.add(new PilatesClass("Core Pilates", "Intermediate", "Wednesday", "18:00", 
                                     45, 10, "Mat", "Intermediate"));
        sessions.add(new ZumbaClass("Latin Zumba", "All Levels", "Friday", "19:30", 
                                   50, 20, "Salsa", 350));
        sessions.add(new YogaClass("Mediation Yoga", "Advanced", "Saturday", "08:00", 
                                  75, 15, "Vinyasa", 5));
    }
    
    /**
     * Displays the main menu
     */
    private void displayMenu() {
        System.out.println("\n=== Welcome to FitAll ===");
        System.out.println("1. View Session Timetable");
        System.out.println("2. Book a Session");
        System.out.println("3. Cancel Booking");
        System.out.println("4. Exit");
        System.out.print("Select an option: ");
    }
    
    /**
     * Gets and validates menu choice
     * @return Validated menu choice
     */
    private int getMenuChoice() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid Session ID. Please enter a number (1-4): ");
            }
        }
    }
    
    /**
     * Displays all sessions in table
     */
    private void displayAllSessions() {
        System.out.println("\n=== Sessions Available ===");
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-12s | %-15s | %-10s | %-10s | %-8s | %-17s | %-30s |\n", 
                         "SessionID", "Name", "Fitness Level", "Day", "Time", 
                         "Duration", "Spaces Left", "Details");
        System.out.println("--------------------------------------------------------------------------------------------------");
        
        sessions.forEach(FitnessSession::displaySessionInfo);
        System.out.println("--------------------------------------------------------------------------------------------------");
    }
    
    /**
     * Session booking process
     */
    private void processBooking() {
        try {
            System.out.print("\nEnter your name: ");
            String name = scanner.nextLine().trim();
            
            System.out.print("Enter session ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            
            FitnessSession session = findSession(id);
            if (session != null) {
                session.bookSession(id, name);
                System.out.println("Spaces available: " + session.getAvailableSpaces());
            } else {
                System.out.println("Session not found: " + id);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    /**
     * Booking cancellation process
     */
    private void processCancellation() {
        try {
            System.out.print("\nEnter participant name: ");
            String name = scanner.nextLine().trim();
            
            System.out.print("Enter session ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            
            FitnessSession session = findSession(id);
            if (session != null) {
                session.cancelBooking(id, name);
                System.out.println("Remaining spaces: " + session.getAvailableSpaces());
            } else {
                System.out.println("Session not found: " + id);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    /**
     * Finds session by ID
     * @param id Session ID to find
     * @return Found session or provides an error
     */
    private FitnessSession findSession(int id) {
        return sessions.stream()
                      .filter(s -> s.getSessionId() == id)
                      .findFirst()
                      .orElse(null);
    }
}