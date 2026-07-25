/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
import ec.edu.espe.mothersApp.model.GestationCalculator;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cristian
 */
public class GestationCalculatorTest {
    @Test
    public void testWeek6Is1stTrimester() {
        GestationCalculator.GestationResult r =
            GestationCalculator.calculateFromWeek(6);
        assertEquals("1st Trimester", r.trimester);
        assertEquals(6, r.currentWeek);
    }

    @Test
    public void testWeek12Is1stTrimester() {
        GestationCalculator.GestationResult r =
            GestationCalculator.calculateFromWeek(12);
        assertEquals("1st Trimester", r.trimester,
            "Week 12 is the last week of 1st trimester");
    }

    @Test
    public void testWeek13Is2ndTrimester() {
        GestationCalculator.GestationResult r =
            GestationCalculator.calculateFromWeek(13);
        assertEquals("2nd Trimester", r.trimester);
    }

    @Test
    public void testWeek27Is2ndTrimester() {
        GestationCalculator.GestationResult r =
            GestationCalculator.calculateFromWeek(27);
        assertEquals("2nd Trimester", r.trimester,
            "Week 27 is the last week of 2nd trimester");
    }

    @Test
    public void testWeek28Is3rdTrimester() {
        GestationCalculator.GestationResult r =
            GestationCalculator.calculateFromWeek(28);
        assertEquals("3rd Trimester", r.trimester);
    }

    @Test
    public void testWeek40Is3rdTrimester() {
        GestationCalculator.GestationResult r =
            GestationCalculator.calculateFromWeek(40);
        assertEquals("3rd Trimester", r.trimester,
            "Week 40 is full term");
    }

    @Test
    public void testMethodFieldIsWeek() {
        GestationCalculator.GestationResult r =
            GestationCalculator.calculateFromWeek(20);
        assertEquals("WEEK", r.method);
    }

    @Test
    public void testDueDateNotNull() {
        GestationCalculator.GestationResult r =
            GestationCalculator.calculateFromWeek(20);
        assertNotNull(r.estimatedDueDate,
            "Estimated due date must never be null");
    }

    @Test
    public void testLmpMethodField() {
        GestationCalculator.GestationResult r =
            GestationCalculator.calculateFromLMP("2025-01-01");
        assertEquals("LMP", r.method);
    }

    @Test
    public void testLmpWeekNonNegative() {
        GestationCalculator.GestationResult r =
            GestationCalculator.calculateFromLMP("2025-01-01");
        assertTrue("Gestation week cannot be negative",
                r.currentWeek >= 0);
    }

    @Test
    public void testLmpTrimesterNotNull() {
        GestationCalculator.GestationResult r =
            GestationCalculator.calculateFromLMP("2025-06-01");
        assertNotNull("Trimester must always be assigned",
                r.trimester);
    }

    @Test
    public void testLmpInvalidDateThrows() {
        assertThrows("Invalid date format should throw an exception",
            Exception.class,
            () -> GestationCalculator.calculateFromLMP("not-a-date"));
    }
}
