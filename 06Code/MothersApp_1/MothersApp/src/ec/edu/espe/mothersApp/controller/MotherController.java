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
public class MotherController {
    private final MongoCollection<Document> collection;

    public MotherController() {
        this.collection = MongoConnection.getDatabase().getCollection("Mothers");
    }

    public void createMotherProfile(int id, String firstName, String lastName, String idNumber, boolean disability, int age) {
        try {
            Document motherDoc = new Document("id", id)
                    .append("firstName", firstName)
                    .append("lastName", lastName)
                    .append("idNumber", idNumber)
                    .append("disability", disability)
                    .append("age", age)
                    .append("createdAt", Calendar.getInstance().getTime());
            
            collection.insertOne(motherDoc);
            System.out.println("Perfil de la Madre guardado con éxito.");
        } catch (Exception e) {
            System.out.println("Error al guardar madre: " + e.getMessage());
        }
    }

    public void updateProfile(int id, String firstName, String lastName, int age, boolean disability) {
        collection.updateOne(
            Filters.eq("id", id),
            Updates.combine(
                Updates.set("firstName", firstName),
                Updates.set("lastName", lastName),
                Updates.set("age", age),
                Updates.set("disability", disability)
            )
        );
        System.out.println("Perfil de la madre actualizado.");
    }

    public Document viewProfile(int id) {
        return collection.find(Filters.eq("id", id)).first();
    }

    public boolean validateID(String idNumber) {
        Document found = collection.find(Filters.eq("idNumber", idNumber)).first();
        return found == null; 
    }
}
