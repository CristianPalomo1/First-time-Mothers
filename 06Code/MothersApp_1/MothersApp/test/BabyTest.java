/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
import ec.edu.espe.mothersApp.model.Baby;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cristian
 */
public class BabyTest {
    private Baby baby;

    @Before
    public void setUp() {
        baby = new Baby("Sofia", "Gomez", "B-001",
                        3200.0, 50.0, "2024-01-10", true);
    }

    @Test
    public void testFirstName() {
        assertEquals("Sofia", baby.firstName);
    }

    @Test
    public void testWeight() {
        assertEquals(3200.0, baby.getWeight(), 0.001);
    }

    @Test
    public void testHeight() {
        assertEquals(50.0, baby.getHeight(), 0.001);
    }

    @Test
    public void testGenderDefault() {
        assertEquals("", baby.getGender());
    }

    @Test
    public void testDisabilityDefault() {
        assertFalse(baby.isDisability());
    }

    @Test
    public void testUpdateInfo() {
        baby.updateInfo(3500.0, 52.0, false);
        assertEquals(3500.0, baby.getWeight(), 0.001);
        assertEquals(52.0, baby.getHeight(), 0.001);
        assertFalse(baby.isDisability());
    }

    @Test
    public void testSetGender() {
        baby.setGender("Female");
        assertEquals("Female", baby.getGender());
    }

    @Test
    public void testFullConstructor() {
        Baby fullBaby = new Baby("Lucas", "Torres", "B-002",
                                  2900.0, 48.0, "Male",
                                  "2024-03-01", true, false);
        assertEquals("Male", fullBaby.getGender());
        assertEquals(2900.0, fullBaby.getWeight(), 0.001);
        assertFalse(fullBaby.isDisability());
    }
}
