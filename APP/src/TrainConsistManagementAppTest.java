import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    // 1️⃣ Loop filtering should return bogies with capacity > 60
    @Test
    void testLoopFilteringLogic() {
        List<Bogie> bogies = List.of(
                new Bogie("B1", 40),
                new Bogie("B2", 70),
                new Bogie("B3", 90)
        );

        List<Bogie> result = TrainConsistManagementApp.filterUsingLoop(bogies);

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
    }

    // 2️⃣ Stream filtering should return bogies with capacity > 60
    @Test
    void testStreamFilteringLogic() {
        List<Bogie> bogies = List.of(
                new Bogie("B1", 20),
                new Bogie("B2", 65),
                new Bogie("B3", 80)
        );

        List<Bogie> result = TrainConsistManagementApp.filterUsingStream(bogies);

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
    }

    // 3️⃣ Loop and Stream results must match
    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> bogies = TrainConsistManagementApp.createBogies(100);

        List<Bogie> loopResult = TrainConsistManagementApp.filterUsingLoop(bogies);
        List<Bogie> streamResult = TrainConsistManagementApp.filterUsingStream(bogies);

        assertEquals(loopResult.size(), streamResult.size());
    }

    // 4️⃣ Execution time must be positive
    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> bogies = TrainConsistManagementApp.createBogies(1000);

        long loopTime = TrainConsistManagementApp.measureLoopTime(bogies);
        long streamTime = TrainConsistManagementApp.measureStreamTime(bogies);

        assertTrue(loopTime > 0);
        assertTrue(streamTime > 0);
    }

    // 5️⃣ Large dataset processing
    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> bogies = TrainConsistManagementApp.createBogies(10000);

        List<Bogie> loopResult = TrainConsistManagementApp.filterUsingLoop(bogies);
        List<Bogie> streamResult = TrainConsistManagementApp.filterUsingStream(bogies);

        assertNotNull(loopResult);
        assertNotNull(streamResult);
        assertEquals(loopResult.size(), streamResult.size());
    }
}