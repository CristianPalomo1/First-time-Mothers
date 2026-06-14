/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mothersApp.controller;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import ec.edu.espe.mothersApp.model.MongoConnection;
import java.util.Calendar;

/**
 *
 * @author Jennyfer Nase, Error 404, @ESPE
 */
public class PediatricGrowthController {
    private final MongoCollection<Document> collection;

    public PediatricGrowthController() {
        this.collection = MongoConnection.getDatabase().getCollection("PediatricGrowths");
    }

    public String validateGrowth(int babyId, double weight, double height, int ageMonths) {
        String status = "Normal";
        
        if (weight < (ageMonths * 2 + 3)) {
            status = "Bajo Peso";
        }

        try {
            Document doc = new Document("babyId", babyId)
                    .append("weightKg", weight)
                    .append("heightCm", height)
                    .append("ageMonths", ageMonths)
                    .append("status", status)
                    .append("validatedAt", Calendar.getInstance().getTime());
            
            collection.insertOne(doc);
            System.out.println("Validación de crecimiento guardada.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return status;
    }
}
