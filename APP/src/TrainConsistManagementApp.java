import java.util.*;
class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}

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
        // ==============================
// UC5 → Preserve insertion order using LinkedHashSet
// ==============================
        System.out.println("\nTrain Formation using LinkedHashSet...");

        LinkedHashSet<String> formation = new LinkedHashSet<>();

        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper"); // duplicate attempt

        System.out.println("Final Formation Order: " + formation);
        // ==============================
// UC6 → Map Bogie to Capacity using HashMap
// ==============================
        System.out.println("\nMapping Bogies to Capacity using HashMap...");

        HashMap<String, Integer> bogieCapacity = new HashMap<>();

        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 60);
        bogieCapacity.put("First Class", 24);

        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(entry.getKey() + " Capacity: " + entry.getValue());
        }
        // ==============================
// UC7 → Sort Bogies by Capacity using Comparator
// ==============================
        System.out.println("\nSorting Bogies by Capacity...");

        List<Bogie> bogieList = new ArrayList<>();

        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));

// Sort using Comparator + Lambda
        bogieList.sort(Comparator.comparingInt(b -> b.capacity));

// Display sorted list
        for (Bogie b : bogieList) {
            System.out.println(b.name + " - Capacity: " + b.capacity);
        }
    }
}