import java.util.ArrayList;
import java.util.List;

public class TrainConsistApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // UC1 → Initialize empty consist
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

        System.out.println("\nFinal bogie list: " + trainConsist);
    }
}