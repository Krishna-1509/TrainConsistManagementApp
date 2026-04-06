import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    String name;
    int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " (Capacity: " + capacity + ")";
    }
}

public class TrainConsistManagementApp {

    // ================= UC8 =================
    // Filter Passenger Bogies using Streams
    public static List<Bogie> filterHighCapacityBogies(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());
    }

    // ================= UC9 =================
    // Group Bogies by Type using Streams
    public static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 80));
        bogies.add(new Bogie("AC Chair", 70));
        bogies.add(new Bogie("First Class", 50));
        bogies.add(new Bogie("Sleeper", 75));
        bogies.add(new Bogie("AC Chair", 90));

        // ===== Display Original List =====
        System.out.println("Original Bogie List:");
        bogies.forEach(System.out::println);

        // ================= UC8 OUTPUT =================
        System.out.println("\n--- Filtered Bogies (Capacity > 70) ---");

        List<Bogie> filteredBogies = filterHighCapacityBogies(bogies);
        filteredBogies.forEach(System.out::println);

        // ================= UC9 OUTPUT =================
        System.out.println("\n--- Grouped Bogies By Type ---");

        Map<String, List<Bogie>> groupedBogies = groupBogiesByType(bogies);

        groupedBogies.forEach((type, list) -> {
            System.out.println(type + " :");
            list.forEach(b -> System.out.println("   " + b));
        });
    }
}