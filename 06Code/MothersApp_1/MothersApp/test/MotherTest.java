/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
import ec.edu.espe.mothersApp.model.Mother;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cristian
 */
public class MotherTest {
    private Mother mother;

    @Before
    public void setUp() {
        mother = new Mother("Maria", "Gomez", "1712345678",
                            "1990-05-15", 65.0, 162.0);
    }

    @Test
    public void testFirstName() {
        assertEquals("Maria", mother.firstName);
    }

    @Test
    public void testLastName() {
        assertEquals("Gomez", mother.lastName);
    }

    @Test
    public void testIdNumber() {
        assertEquals("1712345678", mother.getIdNumber());
    }

    @Test
    public void testWeight() {
        assertEquals(65.0, mother.weight, 0.001);
    }

    @Test
    public void testHeight() {
        assertEquals(162.0, mother.height, 0.001);
    }

    @Test
    public void testDisabilityDefault() {
        assertFalse("Disability should default to false", mother.isDisability());
    }

    @Test
    public void testBabiesListEmpty() {
        assertNotNull(mother.babies);
        assertEquals(0, mother.babies.size());
    }

    @Test
    public void testValidateValidId() {
        assertTrue("Valid numeric ID should pass validation", mother.validate());
    }

    @Test
    public void testValidateInvalidIdLetters() {
        mother.setIdNumber("ABCD123456");
        assertFalse("ID with letters should fail validation", mother.validate());
    }

    @Test
    public void testValidateNullId() {
        mother.setIdNumber(null);
        assertFalse("Null ID should fail validation", mother.validate());
    }

    @Test
    public void testSetAge() {
        mother.setAge(30);
        assertEquals(30, mother.getAge());
    }

    @Test
    public void testSetDisability() {
        mother.setDisability(true);
        assertTrue(mother.isDisability());
    }
}
