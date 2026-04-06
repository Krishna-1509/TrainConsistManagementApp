import java.util.*;

class Cargo {
    String cargoId;
    int weight;
    boolean isHazardous;

    Cargo(String cargoId, int weight, boolean isHazardous) {
        this.cargoId = cargoId;
        this.weight = weight;
        this.isHazardous = isHazardous;
    }
}

public class TrainConsistManagementApp {

    private static final int MAX_WEIGHT_PER_WAGON = 100;

    public static String assignCargoSafely(String cargoId, int weight, boolean isHazardous) {
        try {
            if (cargoId == null || cargoId.isEmpty()) {
                throw new IllegalArgumentException("Cargo ID cannot be empty");
            }

            if (weight <= 0) {
                throw new IllegalArgumentException("Weight must be positive");
            }

            if (weight > MAX_WEIGHT_PER_WAGON) {
                throw new Exception("Cargo exceeds wagon capacity");
            }

            if (isHazardous) {
                return "Hazardous cargo assigned to special wagon";
            }

            return "Cargo assigned successfully";

        } catch (IllegalArgumentException e) {
            return "Invalid cargo details: " + e.getMessage();
        } catch (Exception e) {
            return "Assignment failed: " + e.getMessage();
        } finally {
            System.out.println("Cargo assignment attempted.");
        }
    }

    public static void main(String[] args) {
        System.out.println(assignCargoSafely("C101", 50, false));
        System.out.println(assignCargoSafely("C102", 120, false));
        System.out.println(assignCargoSafely("", 40, false));
        System.out.println(assignCargoSafely("C103", 60, true));
    }
}