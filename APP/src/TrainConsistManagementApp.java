import java.util.ArrayList;
import java.util.List;

public class UC1TrainConsistInitialization {

    public static void main(String[] args) {

        // Welcome message
        System.out.println("=== Train Consist Management App ===");

        // Initialize empty consist using ArrayList
        List<String> trainConsist = new ArrayList<>();

        // Display initial bogie count
        System.out.println("Train consist initialized successfully.");
        System.out.println("Initial bogie count: " + trainConsist.size());

        System.out.println("Application ready for next operations.");
    }
}