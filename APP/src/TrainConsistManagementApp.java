import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    // ================= Bogie Class (UC7 onwards) =================
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
            return name + " (" + capacity + ")";
        }
    }

    // ================= UC8 =================
    // Filter bogies with capacity > threshold
    public static List<Bogie> filterHighCapacityBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    // ================= UC9 =================
    // Group bogies by type/name
    public static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
    }

    // ================= UC10 =================
    // Calculate total seats using reduce()
    public static int calculateTotalSeats(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    // ================= UC11 =================
    // Regex Validation for Train ID
    public static boolean isValidTrainID(String trainID) {
        if (trainID == null) return false;
        return trainID.matches("TRN-\\d{4}");
    }

    // Regex Validation for Cargo Code
    public static boolean isValidCargoCode(String cargoCode) {
        if (cargoCode == null) return false;
        return cargoCode.matches("PET-[A-Z]{2}");
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 40));
        bogies.add(new Bogie("Sleeper", 72));

        // UC7 Sorting using Comparator
        bogies.sort(Comparator.comparingInt(b -> b.capacity));
        System.out.println("Sorted Bogies by Capacity:");
        bogies.forEach(System.out::println);

        // UC8 Filtering using Streams
        System.out.println("\nFiltered Bogies (>60 seats):");
        List<Bogie> filtered = filterHighCapacityBogies(bogies, 60);
        filtered.forEach(System.out::println);

        // UC9 Grouping using groupingBy
        System.out.println("\nGrouped Bogies:");
        Map<String, List<Bogie>> grouped = groupBogiesByType(bogies);
        grouped.forEach((type, list) -> System.out.println(type + " -> " + list));

        // UC10 Reduce (Total Seats)
        int totalSeats = calculateTotalSeats(bogies);
        System.out.println("\nTotal Seating Capacity: " + totalSeats);

        // UC11 Regex Validation
        System.out.println("\nRegex Validation:");
        System.out.println("Train ID TRN-1234 valid? " + isValidTrainID("TRN-1234"));
        System.out.println("Cargo Code PET-AB valid? " + isValidCargoCode("PET-AB"));
    }
}