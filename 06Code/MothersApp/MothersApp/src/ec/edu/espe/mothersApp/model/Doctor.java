package ec.edu.espe.mothersApp.model;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Angie Ñacato, Error 404, @ESPE
 */

public class Doctor extends Person implements ISearchable, IProfile {

    private String speciality;  

    public Doctor() {
        super();
    }

    public Doctor(int id, String firstName, String lastName, String speciality) {
        super(id, firstName, lastName);
        this.speciality = speciality;
    }

    @Override
    public void updateProfile() {
        System.out.println("Updating doctor profile: " + firstName + " " + lastName
            + " | Speciality: " + speciality);
    }

    @Override
    public void viewProfile() {
        System.out.println("Doctor: " + firstName + " " + lastName
            + " | Speciality: " + speciality + " | ID: " + id);
    }

    @Override
    public void displayInfo() {
        viewProfile();
    }

    @Override
    public String search(String keyword) {
        try {
            MongoCollection<Document> col =
                MongoConnection.getDatabase().getCollection("Doctors");
            Document result = col.find(
                Filters.or(
                    Filters.regex("firstName", keyword, "i"),
                    Filters.regex("lastName",  keyword, "i"),
                    Filters.regex("specialty", keyword, "i")
                )
            ).first();
            return result != null ? result.toJson() : "No results for: " + keyword;
        } catch (Exception e) {
            return "Search error: " + e.getMessage();
        }
    }

    public List<MedicalRecord> viewPatientHistory(int babyId) {
        List<MedicalRecord> records = new ArrayList<>();
        try {
            MongoCollection<Document> col =
                MongoConnection.getDatabase().getCollection("allProjectRecords");
            for (Document doc : col.find(Filters.eq("babyId", String.valueOf(babyId)))) {
                MedicalRecord mr = new MedicalRecord();
                mr.setNotes(doc.getString("diagnosis"));
                records.add(mr);
            }
        } catch (Exception e) {
            System.out.println("Error fetching patient history: " + e.getMessage());
        }
        return records;
    }

    public void addMedicalNote(int babyId, String note) {
        try {
            MongoCollection<Document> col =
                MongoConnection.getDatabase().getCollection("allProjectRecords");
            Document doc = new Document("babyId", String.valueOf(babyId))
                .append("doctorName", firstName + " " + lastName)
                .append("diagnosis", note)
                .append("addedAt", new Date());
            col.insertOne(doc);
            System.out.println("Medical note added for baby ID: " + babyId);
        } catch (Exception e) {
            System.out.println("Error adding medical note: " + e.getMessage());
        }
    }

    public void recommendFollowUp(int babyId, Date date) {
        try {
            MongoCollection<Document> col =
                MongoConnection.getDatabase().getCollection("ScheduleAppointments");
            Document doc = new Document("babyId", babyId)
                .append("doctorId", id)
                .append("doctorName", firstName + " " + lastName)
                .append("followUpDate", date)
                .append("status", "Recommended")
                .append("createdAt", new Date());
            col.insertOne(doc);
            System.out.println("Follow-up recommended for baby ID: " + babyId);
        } catch (Exception e) {
            System.out.println("Error saving follow-up: " + e.getMessage());
        }
    }

    public String getSpeciality()         { return speciality; }
    public void   setSpeciality(String v) { this.speciality = v; }
}