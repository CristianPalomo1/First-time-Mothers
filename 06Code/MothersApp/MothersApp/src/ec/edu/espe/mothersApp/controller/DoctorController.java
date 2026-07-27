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
import java.util.Calendar;
import java.util.List;
/**
 *
 * @author Jennyfer Nase, Error 404, @ESPE
 */
public class DoctorController {
    private final MongoCollection<Document> collection;

    public DoctorController() {
        this.collection = MongoConnection.getDatabase().getCollection("Doctors");
    }

    
    public void saveDoctorProfile(int id, String name, String speciality) throws Exception {
        Document doctorDoc = new Document("id", id)
                .append("fullName", name)
                .append("specialty", speciality)
                .append("registeredAt", Calendar.getInstance().getTime());
        
        collection.insertOne(doctorDoc);
        
    }

    public void registerDoctor(int id, String firstName, String lastName, String specialty, String phone, String hospital) {
        try {
            Document doctorDoc = new Document("id", id)
                    .append("firstName", firstName)
                    .append("lastName", lastName)
                    .append("specialty", specialty)
                    .append("phone", phone)
                    .append("hospital", hospital)
                    .append("registeredAt", Calendar.getInstance().getTime());
            
            collection.insertOne(doctorDoc);
        } catch (Exception e) {
            System.out.println("Error registering doctor: " + e.getMessage());
        }
    }

    public Document getDoctorById(int id) {
        try {
            return collection.find(Filters.eq("id", id)).first();
        } catch (Exception e) {
            System.out.println("Error searching for doctor by ID: " + e.getMessage());
            return null;
        }
    }

    public List<Document> getDoctorsBySpecialty(String specialty) {
        List<Document> doctors = new ArrayList<>();
        try {
            collection.find(Filters.eq("specialty", specialty)).into(doctors);
        } catch (Exception e) {
            System.out.println("Error filtering doctors by specialty: " + e.getMessage());
        }
        return doctors;
    }

    public void scheduleAppointment(int babyId, int doctorId, String appointmentDate, String notes) {
        try {
            MongoCollection<Document> appointmentsCollection = MongoConnection.getDatabase().getCollection("Appointments");
            
            Document appointmentDoc = new Document("babyId", babyId)
                    .append("doctorId", doctorId)
                    .append("appointmentDate", appointmentDate)
                    .append("notes", notes)
                    .append("createdAt", Calendar.getInstance().getTime());
            
            appointmentsCollection.insertOne(appointmentDoc);
            System.out.println("¡Medical appointment successfully registered!");
        } catch (Exception e) {
            System.out.println("Error registering medical appointment: " + e.getMessage());
        }
    }
}
