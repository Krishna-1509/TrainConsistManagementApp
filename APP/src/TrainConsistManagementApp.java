import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    String id;
    int capacity;

    Bogie(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public String toString() {
        return id + " (" + capacity + ")";
    }
}

public class TrainConsistManagementApp {

    // Create dataset of bogies
    public static List<Bogie> createBogies(int size) {
        List<Bogie> bogies = new ArrayList<>();
        Random rand = new Random();

        for (int i = 1; i <= size; i++) {
            int capacity = rand.nextInt(100) + 1; // 1–100
            bogies.add(new Bogie("B" + i, capacity));
        }
        return bogies;
    }

    // LOOP BASED FILTERING
    public static List<Bogie> filterUsingLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }
        return result;
    }

    // STREAM BASED FILTERING
    public static List<Bogie> filterUsingStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    // LOOP BENCHMARK
    public static long measureLoopTime(List<Bogie> bogies) {
        long start = System.nanoTime();
        filterUsingLoop(bogies);
        long end = System.nanoTime();
        return end - start;
    }

    // STREAM BENCHMARK
    public static long measureStreamTime(List<Bogie> bogies) {
        long start = System.nanoTime();
        filterUsingStream(bogies);
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) {

        // Create large dataset
        List<Bogie> bogies = createBogies(100000);

        long loopTime = measureLoopTime(bogies);
        long streamTime = measureStreamTime(bogies);

        System.out.println("Loop filtering time (ns): " + loopTime);
        System.out.println("Stream filtering time (ns): " + streamTime);

        // Verify results are same
        List<Bogie> loopResult = filterUsingLoop(bogies);
        List<Bogie> streamResult = filterUsingStream(bogies);

        System.out.println("Loop Result Size: " + loopResult.size());
        System.out.println("Stream Result Size: " + streamResult.size());
    }
}