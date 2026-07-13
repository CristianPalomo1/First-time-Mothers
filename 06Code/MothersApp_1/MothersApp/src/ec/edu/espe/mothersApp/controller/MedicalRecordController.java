/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mothersApp.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import ec.edu.espe.mothersApp.model.MongoConnection;
import java.util.Date;

/**
 *
 * @author Jennyfer Nase, Error 404, @ESPE
 */
public class MedicalRecordController {
    private final MongoCollection<Document> collection;

    public MedicalRecordController() {
        this.collection = MongoConnection.getDatabase().getCollection("allProjectRecords");
    }

    public void saveMedicalConsultation(String babyId, String doctorName, String diagnosis) throws Exception {
        Document medicalData = new Document()
            .append("babyId", babyId)
            .append("doctorName", doctorName)
            .append("diagnosis", diagnosis);

        Document finalJson = new Document()
            .append("module", "Cita Medica")
            .append("syncDate", new Date().toString())
            .append("medicalRecordData", medicalData);

        collection.insertOne(finalJson);
    }
    
}
