/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
import ec.edu.espe.mothersApp.model.Appointment;

import org.junit.Before;
import org.junit.Test;
import java.sql.Time;
import java.util.Date;
import static org.junit.Assert.*;

/**
 *
 * @author Cristian
 */
public class AppointmentTest {
    private Appointment appointment;

    @Before
    public void setUp() {
        appointment = new Appointment();
        appointment.setMotherId(1);
        appointment.setDoctorId(2);
    }

    @Test
    public void testScheduleStatus() {
        Date date = new Date();
        Time time = new Time(System.currentTimeMillis());
        appointment.schedule(date, time, "Checkup");
        assertEquals("Scheduled", appointment.getStatus());
    }

    @Test
    public void testScheduleDate() {
        Date date = new Date();
        appointment.schedule(date, new Time(0), "Follow-up");
        assertEquals(date, appointment.getDate());
    }

    @Test
    public void testScheduleReason() {
        appointment.schedule(new Date(), new Time(0), "Vaccination");
        assertEquals("Vaccination", appointment.getReason());
    }

    @Test
    public void testCancelStatus() {
        appointment.cancel("Mother unavailable");
        assertEquals("Cancelled", appointment.getStatus());
    }

    @Test
    public void testRescheduleStatus() {
        Date newDate = new Date();
        appointment.reschedule(newDate, new Time(0));
        assertEquals("Rescheduled", appointment.getStatus());
    }

    @Test
    public void testRescheduleDate() {
        Date newDate = new Date(System.currentTimeMillis() + 86400000L);
        appointment.reschedule(newDate, new Time(0));
        assertEquals(newDate, appointment.getDate());
    }

    @Test
    public void testNotes() {
        appointment.setNotes("Bring medical documents");
        assertEquals("Bring medical documents", appointment.getNotes());
    }

    @Test
    public void testMotherId() {
        assertEquals(1, appointment.getMotherId());
    }
}
