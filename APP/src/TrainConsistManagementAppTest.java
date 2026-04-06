import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    // Helper method to create sample bogie list
    private List<Bogie> createSampleBogies() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 80));
        bogies.add(new Bogie("AC Chair", 70));
        bogies.add(new Bogie("First Class", 50));
        bogies.add(new Bogie("Sleeper", 75));
        return bogies;
    }

    // 1️⃣ Bogies grouped correctly by type
    @Test
    void testGrouping_BogiesGroupedByType() {
        Map<String, List<Bogie>> result =
                TrainConsistManagementApp.groupBogiesByType(createSampleBogies());

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }

    // 2️⃣ Multiple bogies in same group
    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        Map<String, List<Bogie>> result =
                TrainConsistManagementApp.groupBogiesByType(createSampleBogies());

        assertEquals(2, result.get("Sleeper").size());
    }

    // 3️⃣ Different bogie types separated
    @Test
    void testGrouping_DifferentBogieTypes() {
        Map<String, List<Bogie>> result =
                TrainConsistManagementApp.groupBogiesByType(createSampleBogies());

        assertEquals(3, result.size());
    }

    // 4️⃣ Empty bogie list
    @Test
    void testGrouping_EmptyBogieList() {
        Map<String, List<Bogie>> result =
                TrainConsistManagementApp.groupBogiesByType(new ArrayList<>());

        assertTrue(result.isEmpty());
    }

    // 5️⃣ Single category case
    @Test
    void testGrouping_SingleBogieCategory() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 80));
        list.add(new Bogie("Sleeper", 75));

        Map<String, List<Bogie>> result =
                TrainConsistManagementApp.groupBogiesByType(list);

        assertEquals(1, result.size());
        assertTrue(result.containsKey("Sleeper"));
    }

    // 6️⃣ Map contains correct keys
    @Test
    void testGrouping_MapContainsCorrectKeys() {
        Map<String, List<Bogie>> result =
                TrainConsistManagementApp.groupBogiesByType(createSampleBogies());

        Set<String> keys = result.keySet();
        assertTrue(keys.contains("Sleeper"));
        assertTrue(keys.contains("AC Chair"));
        assertTrue(keys.contains("First Class"));
    }

    // 7️⃣ Group size validation
    @Test
    void testGrouping_GroupSizeValidation() {
        Map<String, List<Bogie>> result =
                TrainConsistManagementApp.groupBogiesByType(createSampleBogies());

        assertEquals(2, result.get("Sleeper").size());
        assertEquals(1, result.get("AC Chair").size());
        assertEquals(1, result.get("First Class").size());
    }

    // 8️⃣ Original list unchanged
    @Test
    void testGrouping_OriginalListUnchanged() {
        List<Bogie> original = createSampleBogies();
        int originalSize = original.size();

        TrainConsistManagementApp.groupBogiesByType(original);

        assertEquals(originalSize, original.size());
    }
}