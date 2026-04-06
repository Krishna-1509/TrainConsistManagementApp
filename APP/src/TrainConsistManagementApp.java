import java.util.*;

// PassengerBogie class
class PassengerBogie {
    private String bogieId;
    private int capacity;

    public PassengerBogie(String bogieId, int capacity) {
        this.bogieId = bogieId;
        this.capacity = capacity;
    }

    public String getBogieId() {
        return bogieId;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return bogieId + " - Capacity: " + capacity;
    }
}

// Comparator to sort by capacity
class CapacityComparator implements Comparator<PassengerBogie> {
    @Override
    public int compare(PassengerBogie b1, PassengerBogie b2) {
        return Integer.compare(b1.getCapacity(), b2.getCapacity());
    }
}

// Main Application
public class TrainConsistManagementApp {

    public static List<PassengerBogie> sortBogiesByCapacity(List<PassengerBogie> bogies) {
        Collections.sort(bogies, new CapacityComparator());
        return bogies;
    }

    // Optional manual run
    public static void main(String[] args) {
        List<PassengerBogie> bogies = new ArrayList<>();
        bogies.add(new PassengerBogie("B1", 80));
        bogies.add(new PassengerBogie("B2", 60));
        bogies.add(new PassengerBogie("B3", 100));

        sortBogiesByCapacity(bogies);

        for (PassengerBogie b : bogies) {
            System.out.println(b);
        }
    }
}