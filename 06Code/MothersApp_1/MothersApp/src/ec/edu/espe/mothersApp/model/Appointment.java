package ec.edu.espe.mothersApp.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Angie Nacato, Error 404, @ESPE
 */
public class Appointment implements IAppointment {
    
    private int id;
    private int motherId;
    private int doctorId;
    private Date date;
    private Time time;
    private String reason;
    private String status;
    private String notes;

    public void schedule(Date date, Time time, String reason) {
        this.date = date;
        this.time = time;
        this.reason = reason;
        this.status = "Scheduled";
    }

    public void reschedule(Date newDate, Time newTime) {
        this.date = newDate;
        this.time = newTime;
        this.status = "Rescheduled";
    }

    public void cancel(String reason) {
        this.reason = reason;
        this.status = "Cancelled";
    }

    public List<Appointment> viewAppointments(int motherId) {
        return new ArrayList<>();
    }

    @Override
    public void schedule() {
        this.status = "Scheduled";
    }

    @Override
    public void cancel() {
        this.status = "Cancelled";
    }

    @Override
    public void reschedule(Date newDate, Date newTime) {
        this.date = newDate;
    }

    public int getId() 
        { return id; }
    public void setId(int id) 
        { this.id = id; }
    public int getMotherId() 
        { return motherId; }
    public void setMotherId(int motherId) 
        { this.motherId = motherId; }
    public int getDoctorId() 
        { return doctorId; }
    public void setDoctorId(int doctorId) 
        { this.doctorId = doctorId; }
    public Date getDate() 
        { return date; }
    public void setDate(Date date) 
        { this.date = date; }
    public Time getTime() 
        { return time; }
    public void setTime(Time time) 
        { this.time = time; }
    public String getReason() 
        { return reason; }
    public void setReason(String reason) 
        { this.reason = reason; }
    public String getStatus() 
        { return status; }
    public void setStatus(String status) 
        { this.status = status; }
    public String getNotes() 
        { return notes; }
    public void setNotes(String notes) 
        { this.notes = notes; }
}