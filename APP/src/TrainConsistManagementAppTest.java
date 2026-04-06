import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    private List<TrainConsistManagementApp.Bogie> createSampleBogies() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair", 56));
        bogies.add(new TrainConsistManagementApp.Bogie("First Class", 30));
        return bogies;
    }

    // ================= UC10 TEST CASES =================

    @Test
    void testReduce_TotalSeatCalculation() {
        List<TrainConsistManagementApp.Bogie> bogies = createSampleBogies();
        int total = TrainConsistManagementApp.calculateTotalSeats(bogies);
        assertEquals(158, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<TrainConsistManagementApp.Bogie> bogies = createSampleBogies();
        int total = TrainConsistManagementApp.calculateTotalSeats(bogies);
        assertTrue(total > 100);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        int total = TrainConsistManagementApp.calculateTotalSeats(bogies);
        assertEquals(72, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        int total = TrainConsistManagementApp.calculateTotalSeats(bogies);
        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<TrainConsistManagementApp.Bogie> bogies = createSampleBogies();
        int total = TrainConsistManagementApp.calculateTotalSeats(bogies);
        assertEquals(72 + 56 + 30, total);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<TrainConsistManagementApp.Bogie> bogies = createSampleBogies();
        int total = TrainConsistManagementApp.calculateTotalSeats(bogies);
        assertEquals(158, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<TrainConsistManagementApp.Bogie> bogies = createSampleBogies();
        TrainConsistManagementApp.calculateTotalSeats(bogies);
        assertEquals(3, bogies.size());
    }
}