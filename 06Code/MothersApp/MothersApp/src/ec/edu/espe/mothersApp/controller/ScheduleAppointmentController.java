/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mothersApp.controller;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import ec.edu.espe.mothersApp.model.MongoConnection;
import java.util.Date;
/**
 *
 * @author Jennyfer Nase, Error 404, @ESPE
 */
public class ScheduleAppointmentController {
   private final MongoCollection<Document> appointmentCollection;
    private final MongoCollection<Document> historyCollection;

    public ScheduleAppointmentController() {
        this.appointmentCollection = MongoConnection.getDatabase().getCollection("appointments");
        this.historyCollection = MongoConnection.getDatabase().getCollection("medicalHistories");
    }

    
    public boolean processScheduleAppointment(String date, String reminder) {
        try {
            Document appointmentDoc = new Document()
                    .append("appointmentDate", date)
                    .append("reminder", reminder.isEmpty() ? "No reminder set" : reminder)
                    .append("createdAt", new Date());

            appointmentCollection.insertOne(appointmentDoc);
            return true;
        } catch (Exception e) {
            System.out.println("Error saving appointment: " + e.getMessage());
            return false;
        }
    }

    
    public boolean processSaveMedicalHistory(String recommendation) {
        try {
            Document historyDoc = new Document()
                    .append("doctorRecommendation", recommendation)
                    .append("savedAt", new Date());

            historyCollection.insertOne(historyDoc);
            return true;
        } catch (Exception e) {
            System.out.println("Error saving history: " + e.getMessage());
            return false;
        }
    }

    
    public String getAllAppointmentsFromDB() {
        StringBuilder sb = new StringBuilder();
        try (MongoCursor<Document> cursor = appointmentCollection.find().iterator()) {
            int count = 1;
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                sb.append(count).append(". Date: ").append(doc.getString("appointmentDate"))
                  .append("  |  Reminder: ").append(doc.getString("reminder")).append("\n");
                count++;
            }
        } catch (Exception e) {
            return "Error pulling database records: " + e.getMessage();
        }
        return sb.length() == 0 ? "No medical appointments found in MongoDB collection." : sb.toString();
    }
}
