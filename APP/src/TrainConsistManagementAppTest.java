import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class TrainConsistManagementAppTest {

    @Test
    public void testSortBogiesByCapacity() {
        List<PassengerBogie> bogies = new ArrayList<>();
        bogies.add(new PassengerBogie("B1", 80));
        bogies.add(new PassengerBogie("B2", 60));
        bogies.add(new PassengerBogie("B" +
                "3", 100));

        List<PassengerBogie> sorted = TrainConsistManagementApp.sortBogiesByCapacity(bogies);

        assertEquals(60, sorted.get(0).getCapacity());
        assertEquals(80, sorted.get(1).getCapacity());
        assertEquals(100, sorted.get(2).getCapacity());
    }
}