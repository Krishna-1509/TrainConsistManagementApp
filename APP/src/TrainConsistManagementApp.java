import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// =====================================================
// UC14 : CUSTOM EXCEPTION
// =====================================================
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// =====================================================
// PASSENGER BOGIE (UC14)
// =====================================================
class PassengerBogie {
    private String type;
    private int capacity;

    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() { return type; }
    public int getCapacity() { return capacity; }
}

// =====================================================
// GOODS BOGIE (UC12 + UC13)
// =====================================================
class GoodsBogie {
    private String type;
    private String cargo;
    private int capacity;

    public GoodsBogie(String type, String cargo, int capacity) {
        this.type = type;
        this.cargo = cargo;
        this.capacity = capacity;
    }

    public String getType() { return type; }
    public String getCargo() { return cargo; }
    public int getCapacity() { return capacity; }

    @Override
    public String toString() {
        return type + " - " + cargo + " - " + capacity;
    }
}

// =====================================================
// MAIN APP
// =====================================================
public class TrainConsistManagementApp {

    // =====================================================
    // UC11 : REGEX VALIDATION
    // =====================================================
    public static boolean validateTrainID(String trainId) {
        return Pattern.matches("TRN-\\d{4}", trainId);
    }

    public static boolean validateCargoCode(String cargoCode) {
        return Pattern.matches("PET-[A-Z]{2}", cargoCode);
    }

    // =====================================================
    // UC12 : SAFETY VALIDATION USING STREAMS
    // =====================================================
    public static boolean isTrainSafe(List<GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(b ->
                        !b.getType().equalsIgnoreCase("Cylindrical") ||
                                b.getCargo().equalsIgnoreCase("Petroleum")
                );
    }

    // =====================================================
    // UC13 : LOOP FILTERING
    // =====================================================
    public static List<GoodsBogie> filterUsingLoop(List<GoodsBogie> bogies) {
        List<GoodsBogie> result = new ArrayList<>();
        for (GoodsBogie b : bogies) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }
        return result;
    }

    // =====================================================
    // UC13 : STREAM FILTERING
    // =====================================================
    public static List<GoodsBogie> filterUsingStream(List<GoodsBogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    // =====================================================
    // UC13 : PERFORMANCE BENCHMARK
    // =====================================================
    public static long measureLoopTime(List<GoodsBogie> bogies) {
        long start = System.nanoTime();
        filterUsingLoop(bogies);
        long end = System.nanoTime();
        return end - start;
    }

    public static long measureStreamTime(List<GoodsBogie> bogies) {
        long start = System.nanoTime();
        filterUsingStream(bogies);
        long end = System.nanoTime();
        return end - start;
    }

    // =====================================================
    // MAIN METHOD (Console Demo)
    // =====================================================
    public static void main(String[] args) {

        System.out.println("===== TRAIN CONSIST MANAGEMENT APP =====");

        // ---------------- UC11 DEMO ----------------
        System.out.println("\nUC11 : Regex Validation");
        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";

        System.out.println("Train ID valid: " + validateTrainID(trainId));
        System.out.println("Cargo Code valid: " + validateCargoCode(cargoCode));

        // ---------------- UC12 DEMO ----------------
        System.out.println("\nUC12 : Safety Validation");
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum", 80),
                new GoodsBogie("Open", "Coal", 70),
                new GoodsBogie("Box", "Grain", 65)
        );

        boolean safe = isTrainSafe(bogies);
        System.out.println("Train Safety Status: " + safe);

        // ---------------- UC13 DEMO ----------------
        System.out.println("\nUC13 : Performance Comparison");
        long loopTime = measureLoopTime(bogies);
        long streamTime = measureStreamTime(bogies);

        System.out.println("Loop Time (ns): " + loopTime);
        System.out.println("Stream Time (ns): " + streamTime);

        // ---------------- UC14 DEMO ----------------
        System.out.println("\nUC14 : Custom Exception Demo");
        try {
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            System.out.println("Passenger Bogie Created: " + b1.getType());
        } catch (InvalidCapacityException e) {
            System.out.println(e.getMessage());
        }

        try {
            PassengerBogie b2 = new PassengerBogie("AC Chair", -5);
        } catch (InvalidCapacityException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}