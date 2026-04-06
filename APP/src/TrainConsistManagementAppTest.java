import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    // 1️⃣ Valid capacity should create bogie successfully
    @Test
    void testException_ValidCapacityCreation() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie("Sleeper", 72);
        assertNotNull(bogie);
        assertEquals(72, bogie.getCapacity());
    }

    // 2️⃣ Negative capacity should throw exception
    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception ex = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("AC Chair", -10);
        });

        assertEquals("Capacity must be greater than zero", ex.getMessage());
    }

    // 3️⃣ Zero capacity should throw exception
    @Test
    void testException_ZeroCapacityThrowsException() {
        assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("First Class", 0);
        });
    }

    // 4️⃣ Exception message validation
    @Test
    void testException_ExceptionMessageValidation() {
        Exception ex = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("Sleeper", 0);
        });

        assertEquals("Capacity must be greater than zero", ex.getMessage());
    }

    // 5️⃣ Object integrity after creation
    @Test
    void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie("AC Chair", 64);

        assertEquals("AC Chair", bogie.getType());
        assertEquals(64, bogie.getCapacity());
    }

    // 6️⃣ Multiple valid bogies creation
    @Test
    void testException_MultipleValidBogiesCreation() throws InvalidCapacityException {
        PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
        PassengerBogie b2 = new PassengerBogie("AC Chair", 64);
        PassengerBogie b3 = new PassengerBogie("First Class", 40);

        assertNotNull(b1);
        assertNotNull(b2);
        assertNotNull(b3);
    }
}