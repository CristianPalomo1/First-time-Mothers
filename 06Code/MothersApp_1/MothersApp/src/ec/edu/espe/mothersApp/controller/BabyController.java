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
import java.util.Calendar;
/**
 *
 * @author Jennyfer Nase, Error 404, @ESPE
 */
public class BabyController {
    private final MongoCollection<Document> collection;

    public BabyController() {
        this.collection = MongoConnection.getDatabase().getCollection("Babies");
    }

    public void createBabyProfile(int id, String firstName, String birthDate, double weight, double height, String gender, String lastName, boolean disability) {
        try {
            Document babyDoc = new Document("id", id)
                    .append("firstName", firstName)
                    .append("birthDate", birthDate)
                    .append("weight", weight)
                    .append("height", height)
                    .append("gender", gender)
                    .append("lastName", lastName)
                    .append("disability", disability)
                    .append("createdAt", Calendar.getInstance().getTime());
            
            collection.insertOne(babyDoc);
            System.out.println("Baby profile successfully saved.");
        } catch (Exception e) {
            System.out.println("Error saving baby: " + e.getMessage());
        }
    }

    public void updateInfo(int id, double weight, double height, boolean disability) {
        collection.updateOne(
            Filters.eq("id", id),
            Updates.combine(
                Updates.set("weight", weight),
                Updates.set("height", height),
                Updates.set("disability", disability)
            )
        );
        System.out.println("Updated baby information.");
    }

    public Document viewInfo(int id) {
        return collection.find(Filters.eq("id", id)).first();
    }
}
