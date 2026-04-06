import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    // ===== Bogie Class =====
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public String getName() {
            return name;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return name + " (" + capacity + " seats)";
        }
    }

    // ================= UC8 =================
    // Filter Passenger Bogies Using Streams
    public static List<Bogie> filterHighCapacityBogies(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }

    // ================= UC9 =================
    // Group Bogies by Type
    public static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
    }

    // ================= UC10 =================
    // Count Total Seats using reduce()
    public static int calculateTotalSeats(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 30));
        bogies.add(new Bogie("Sleeper", 72));

        // ---------- UC8 OUTPUT ----------
        System.out.println("Filtered Bogies (>60 seats):");
        List<Bogie> filtered = filterHighCapacityBogies(bogies);
        filtered.forEach(System.out::println);

        // ---------- UC9 OUTPUT ----------
        System.out.println("\nGrouped Bogies:");
        Map<String, List<Bogie>> grouped = groupBogiesByType(bogies);
        grouped.forEach((type, list) -> {
            System.out.println(type + " -> " + list);
        });

        // ---------- UC10 OUTPUT ----------
        System.out.println("\nTotal Seating Capacity:");
        int totalSeats = calculateTotalSeats(bogies);
        System.out.println("Total Seats in Train = " + totalSeats);
    }
}