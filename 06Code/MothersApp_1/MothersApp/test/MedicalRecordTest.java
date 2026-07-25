    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
import ec.edu.espe.mothersApp.model.MedicalRecord;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Cristian
 */
public class MedicalRecordTest {
    private MedicalRecord record;

    @Before
    public void setUp() {
        record = new MedicalRecord(1, 70.0, 165.0, 36.8,
                                   "Normal", "Normal", "Normal", "Normal",
                                   "Routine checkup");
    }

    @Test
    public void testId() {
        assertEquals(1, record.getId());
    }

    @Test
    public void testTemperature() {
        assertEquals(36.8, record.getTemperature(), 0.001);
    }

    @Test
    public void testNotes() {
        assertEquals("Routine checkup", record.getNotes());
    }

    @Test
    public void testDefaultRespiratoryStatus() {
        MedicalRecord def = new MedicalRecord();
        assertEquals("Normal", def.getRespiratoryStatus());
    }

    @Test
    public void testDefaultFeedingStatus() {
        MedicalRecord def = new MedicalRecord();
        assertEquals("Normal", def.getFeedingStatus());
    }

    @Test
    public void testSetTemperature() {
        record.setTemperature(39.0);
        assertEquals(39.0, record.getTemperature(), 0.001);
    }

    @Test
    public void testSetWeight() {
        record.setWeight(72.5);
        assertEquals(72.5, record.getWeight(), 0.001);
    }

    @Test
    public void testSetRespiratoryStatus() {
        record.setRespiratoryStatus("yes");
        assertEquals("yes", record.getRespiratoryStatus());
    }

    @Test
    public void testDateInitialized() {
        assertNotNull("Date must be initialized in constructor", record.getDate());
    }
}
