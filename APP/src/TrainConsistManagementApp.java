import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

// =====================================================
// UC14 : CUSTOM EXCEPTION (Checked)
// =====================================================
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// =====================================================
// UC15 : CUSTOM RUNTIME EXCEPTION
// =====================================================
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// =====================================================
// PASSENGER BOGIE
// =====================================================
class PassengerBogie {
    private String type;
    private int capacity;

    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0)
            throw new InvalidCapacityException("Capacity must be greater than zero");
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() { return type; }
    public int getCapacity() { return capacity; }

    @Override
    public String toString() {
        return type + " - Capacity: " + capacity;
    }
}

// =====================================================
// GOODS BOGIE
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

    // UC15 Safe cargo assignment
    public void assignCargo(String newCargo) {
        try {
            if (type.equalsIgnoreCase("Rectangular") &&
                    newCargo.equalsIgnoreCase("Petroleum")) {
                throw new CargoSafetyException("Rectangular bogie cannot carry Petroleum!");
            }

            this.cargo = newCargo;
            System.out.println("Cargo assigned successfully: " + newCargo);

        } catch (CargoSafetyException e) {
            System.out.println("ERROR: " + e.getMessage());

        } finally {
            System.out.println("Cargo assignment attempt completed.");
        }
    }

    @Override
    public String toString() {
        return type + " - " + cargo + " - " + capacity;
    }
}

// =====================================================
// MAIN APPLICATION
// =====================================================
public class TrainConsistManagementApp {

    // UC11 Regex Validation Methods
    public static boolean validateTrainID(String trainID) {
        return Pattern.matches("TRN-\\d{4}", trainID);
    }

    public static boolean validateCargoCode(String code) {
        return Pattern.matches("PET-[A-Z]{2}", code);
    }

    public static void main(String[] args) throws Exception {

        System.out.println("Train Consist Management App Running...\n");

        // =====================================================
        // CREATE PASSENGER BOGIES
        // =====================================================
        List<PassengerBogie> passengers = new ArrayList<>();
        passengers.add(new PassengerBogie("Sleeper", 72));
        passengers.add(new PassengerBogie("AC Chair", 60));
        passengers.add(new PassengerBogie("First Class", 40));
        passengers.add(new PassengerBogie("Sleeper", 70));

        // =====================================================
        // UC9 : GROUPING
        // =====================================================
        System.out.println("UC9 : Grouping Bogies");
        Map<String, List<PassengerBogie>> grouped =
                passengers.stream().collect(Collectors.groupingBy(PassengerBogie::getType));
        grouped.forEach((k,v) -> System.out.println(k + " -> " + v));

        // =====================================================
        // UC10 : REDUCE TOTAL SEATS
        // =====================================================
        int totalSeats = passengers.stream()
                .map(PassengerBogie::getCapacity)
                .reduce(0, Integer::sum);
        System.out.println("\nUC10 : Total Seats = " + totalSeats);

        // =====================================================
        // UC11 : REGEX VALIDATION
        // =====================================================
        System.out.println("\nUC11 : Regex Validation");
        System.out.println("TRN-1234 valid? " + validateTrainID("TRN-1234"));
        System.out.println("PET-AB valid? " + validateCargoCode("PET-AB"));

        // =====================================================
        // UC12 : SAFETY CHECK using allMatch
        // =====================================================
        List<GoodsBogie> goods = List.of(
                new GoodsBogie("Cylindrical","Petroleum",80),
                new GoodsBogie("Rectangular","Coal",70)
        );

        boolean safe = goods.stream().allMatch(b ->
                !b.getType().equalsIgnoreCase("Cylindrical") ||
                        b.getCargo().equalsIgnoreCase("Petroleum")
        );
        System.out.println("\nUC12 : Train Safety = " + safe);

        // =====================================================
        // UC13 : PERFORMANCE (Loop vs Stream)
        // =====================================================
        System.out.println("\nUC13 : Performance Test");

        long startLoop = System.nanoTime();
        List<PassengerBogie> loopFiltered = new ArrayList<>();
        for (PassengerBogie b : passengers)
            if (b.getCapacity() > 60) loopFiltered.add(b);
        long endLoop = System.nanoTime();

        long startStream = System.nanoTime();
        List<PassengerBogie> streamFiltered = passengers.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        long endStream = System.nanoTime();

        System.out.println("Loop Time : " + (endLoop - startLoop));
        System.out.println("Stream Time : " + (endStream - startStream));

        // =====================================================
        // UC15 : SAFE CARGO ASSIGNMENT
        // =====================================================
        System.out.println("\nUC15 : Safe Cargo Assignment");

        GoodsBogie rect = new GoodsBogie("Rectangular","Coal",70);
        GoodsBogie cyl = new GoodsBogie("Cylindrical","Oil",80);

        cyl.assignCargo("Petroleum");   // safe
        rect.assignCargo("Petroleum");  // unsafe handled

        System.out.println("\nApplication finished successfully.");
    }
}