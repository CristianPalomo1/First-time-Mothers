/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
import ec.edu.espe.mothersApp.model.InteractiveChat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cristian
 */
public class InteractiveChatTest {
    private String captureMessage(String message) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(baos));
        try {
            InteractiveChat chat = new InteractiveChat();
            chat.sendMessage(message);
        } catch (Exception ignored) {}
        System.setOut(original);
        return baos.toString();
    }

    @Test
    public void testFeverKeyword() {
        String output = captureMessage("My baby has fever");
        assertTrue("Fever keyword should trigger temperature advice", 
                   output.toLowerCase().contains("temperature"));
    }

    @Test
    public void testFeedingKeyword() {
        String output = captureMessage("Feeding problem today");
        assertTrue("Feeding keyword should trigger feeding advice", 
                   output.toLowerCase().contains("feeding"));
    }

    @Test
    public void testCryingKeyword() {
        String output = captureMessage("Baby won't stop crying");
        assertTrue("Crying keyword should trigger crying advice", 
                   output.toLowerCase().contains("crying"));
    }

    @Test
    public void testSleepKeyword() {
        String output = captureMessage("Baby can't sleep");
        assertTrue("Sleep keyword should trigger sleep environment advice", 
                   output.toLowerCase().contains("quiet") || output.toLowerCase().contains("room"));
    }

    @Test
    public void testUnknownKeyword() {
        String output = captureMessage("random unknown topic xyz");
        assertTrue("Unknown topic should return default community reply", 
                   output.contains("community") || output.contains("received"));
    }
}
