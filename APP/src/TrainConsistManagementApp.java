import java.util.*;

public class TrainConsistApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // ==============================
        // UC1 → Initialize empty consist
        // ==============================
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Initial bogie count: " + trainConsist.size());

        // ==============================
        // UC2 → Passenger bogie operations
        // ==============================
        System.out.println("\nAdding passenger bogies...");

        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        System.out.println("Bogies after addition: " + trainConsist);

        System.out.println("\nRemoving AC Chair bogie...");
        trainConsist.remove("AC Chair");

        System.out.println("Checking if Sleeper exists...");
        System.out.println("Sleeper present? " + trainConsist.contains("Sleeper"));

        System.out.println("Final bogie list: " + trainConsist);

        // ==============================
        // UC3 → Unique Bogie IDs using HashSet
        // ==============================
        System.out.println("\nTracking Unique Bogie IDs...");

        Set<String> bogieIds = new HashSet<>();

        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // duplicate intentionally
        bogieIds.add("BG102"); // duplicate intentionally

        System.out.println("Unique Bogie IDs: " + bogieIds);
    }
}