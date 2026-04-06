import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class TrainConsistManagementAppTest {

    // ================= UC15 TESTS =================

    @Test
    void testCargo_SafeAssignment() {
        GoodsBogie bogie = new GoodsBogie("Cylindrical", "Oil", 80);
        bogie.assignCargo("Petroleum");
        assertEquals("Petroleum", bogie.getCargo());
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie bogie = new GoodsBogie("Rectangular", "Coal", 70);
        bogie.assignCargo("Petroleum");
        assertNotEquals("Petroleum", bogie.getCargo());
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie bogie = new GoodsBogie("Rectangular", "Coal", 70);
        bogie.assignCargo("Petroleum");
        assertEquals("Coal", bogie.getCargo());
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        GoodsBogie b1 = new GoodsBogie("Rectangular", "Coal", 70);
        GoodsBogie b2 = new GoodsBogie("Cylindrical", "Oil", 80);

        b1.assignCargo("Petroleum"); // fails
        b2.assignCargo("Petroleum"); // succeeds

        assertEquals("Petroleum", b2.getCargo());
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        GoodsBogie bogie = new GoodsBogie("Rectangular", "Coal", 70);
        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
    }
}