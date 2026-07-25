/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */


import ec.edu.espe.mothersApp.model.AlarmValidator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Cristian
 */
public class AlarmValidatorTest {
     private AlarmValidator validator;

    @Before
    public void setUp() {
        validator = new AlarmValidator();
    }

    @Test
    public void testTemperatureNormal() {
        assertTrue(validator.checkTemperature(36.5));
    }

    @Test
    public void testTemperatureFever() {
        assertFalse(validator.checkTemperature(38.5));
    }

    @Test
    public void testTemperatureLowerBoundary() {
        assertTrue(validator.checkTemperature(35.5));
    }

    @Test
    public void testTemperatureUpperBoundary() {
        assertTrue(validator.checkTemperature(38.0));
    }

    @Test
    public void testTemperatureHypothermia() {
        assertFalse(validator.checkTemperature(35.0));
    }

    @Test
    public void testRespirationNormal() {
        assertTrue(validator.checkRespiration("no"));
    }

    @Test
    public void testRespirationDistress() {
        assertFalse(validator.checkRespiration("yes"));
    }

    @Test
    public void testRespirationUpperCase() {
        assertFalse(validator.checkRespiration("YES"));
    }

    @Test
    public void testFeedingNormal() {
        assertTrue(validator.checkFeeding("no"));
    }

    @Test
    public void testFeedingProblem() {
        assertFalse(validator.checkFeeding("yes"));
    }

    @Test
    public void testSkinColorNormal() {
        assertTrue(validator.checkSkinColor("no"));
    }

    @Test
    public void testSkinColorCyanosis() {
        assertFalse(validator.checkSkinColor("yes"));
    }

    @Test
    public void testActivityNormal() {
        assertTrue(validator.checkActivity("no"));
    }

    @Test
    public void testActivityLethargy() {
        assertFalse(validator.checkActivity("yes"));
    }

    @Test
    public void testGenerateAlertNotNull() {
        assertNotNull(validator.generateAlert());
    }

    @Test
    public void testGenerateAlertContent() {
        String alert = validator.generateAlert();
        assertTrue(alert.toUpperCase().contains("CRITICAL"));
    }
}
