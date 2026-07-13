/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mothersApp.controller;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;
import ec.edu.espe.mothersApp.model.MongoConnection;

/**
 *
 * @author Jennyfer Nase, Error 404, @ESPE
 */
public class InteractiveChatController {
    private final MongoCollection<Document> collection;

    public InteractiveChatController() {
        this.collection = MongoConnection.getDatabase().getCollection("InteractiveChats");
    }

    public void sendMessage(String sender, String message) {
        Document msg = new Document("sender", sender)
                .append("message", message)
                .append("timestamp", new java.util.Date().toString());
        collection.insertOne(msg);
    }

    public List<Document> viewMessages() {
        return collection.find().into(new ArrayList<>());
    }
}
