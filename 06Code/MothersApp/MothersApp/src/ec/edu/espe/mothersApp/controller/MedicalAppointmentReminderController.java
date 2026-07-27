/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mothersApp.controller;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import ec.edu.espe.mothersApp.model.MongoConnection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jennyfer Nase, Error 404, @ESPE
 */
public class MedicalAppointmentReminderController {
    private final MongoCollection<Document> collection;

    public MedicalAppointmentReminderController() {
        this.collection = MongoConnection.getDatabase().getCollection("ScheduleAppointments");
    }

    public void schedule(int id, int motherId, String date, String time, String reason) {
        try {
            Document appointment = new Document("id", id)
                    .append("motherId", motherId)
                    .append("date", date)
                    .append("time", time)
                    .append("reason", reason)
                    .append("status", "Scheduled");
            collection.insertOne(appointment);
        } catch (Exception e) {
            System.out.println("Error al agendar: " + e.getMessage());
        }
    }

    public void reschedule(int id, String newDate, String newTime) {
        collection.updateOne(
            Filters.eq("id", id),
            Updates.combine(Updates.set("date", newDate), Updates.set("time", newTime))
        );
    }

    public void cancel(int id, String reason) {
        collection.updateOne(
            Filters.eq("id", id),
            Updates.combine(Updates.set("status", "Canceled"), Updates.set("notes", reason))
        );
    }

    public List<Document> viewAppointments(int motherId) {
        return collection.find(Filters.eq("motherId", motherId)).into(new ArrayList<>());
    }
}
