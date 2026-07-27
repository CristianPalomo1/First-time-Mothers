/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import ec.edu.espe.mothersApp.model.PediatricGrowthValidator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cristian
 */
public class PediatricGrowthValidatorTest {
    private String captureOutput(Runnable action) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(baos));
        action.run();
        System.setOut(original);
        return baos.toString();
    }

    @Test
    public void testNormalGrowth() {
        String output = captureOutput(() ->
            PediatricGrowthValidator.showResult(3200, 50));
        assertTrue("Full-term healthy baby should be NORMAL", output.contains("NORMAL"));
    }

    @Test
    public void testNormalGrowthBoundary() {
        String output = captureOutput(() ->
            PediatricGrowthValidator.showResult(2500, 45));
        assertTrue("Exact minimum for NORMAL should still be NORMAL", output.contains("NORMAL"));
    }

    @Test
    public void testLowRiskGrowth() {
        String output = captureOutput(() ->
            PediatricGrowthValidator.showResult(2000, 38));
        assertTrue("Underweight but above severe threshold should be LOW RISK", output.contains("LOW RISK"));
    }

    @Test
    public void testLowRiskGrowthBoundary() {
        String output = captureOutput(() ->
            PediatricGrowthValidator.showResult(1800, 35));
        assertTrue("Exact minimum for LOW RISK should be LOW RISK", output.contains("LOW RISK"));
    }

    @Test
    public void testJustBelowNormal() {
        String output = captureOutput(() ->
            PediatricGrowthValidator.showResult(2499, 44));
        assertTrue("Just below NORMAL threshold should be LOW RISK", output.contains("LOW RISK"));
    }

    @Test
    public void testSevereGrowth() {
        String output = captureOutput(() ->
            PediatricGrowthValidator.showResult(1200, 30));
        assertTrue("Very underweight baby should be SEVERE", output.contains("SEVERE"));
    }

    @Test
    public void testZeroValuesSevere() {
        String output = captureOutput(() ->
            PediatricGrowthValidator.showResult(0, 0));
        assertTrue("Zero values should always be SEVERE", output.contains("SEVERE"));
    }

    @Test
    public void testJustBelowLowRisk() {
        String output = captureOutput(() ->
            PediatricGrowthValidator.showResult(1799, 34));
        assertTrue("Just below LOW RISK threshold should be SEVERE", output.contains("SEVERE"));
    }

    @Test
    public void testStaticFieldsAssignment() {
        PediatricGrowthValidator.babyWeight  = 3000;
        PediatricGrowthValidator.babyHeight  = 50;
        PediatricGrowthValidator.motherWeight = 65;
        PediatricGrowthValidator.motherHeight = 162;

        assertEquals(3000, PediatricGrowthValidator.babyWeight);
        assertEquals(50,   PediatricGrowthValidator.babyHeight);
    }
}
