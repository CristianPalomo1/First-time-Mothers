package ec.edu.espe.mothersApp.model;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jennyfer Nase, Error 404, @ESPE
 */

public class InteractiveChat {

    private MongoCollection<Document> collection;

    public InteractiveChat() {
        try {
            this.collection = MongoConnection.getDatabase()
                                             .getCollection("InteractiveChats");
        } catch (Exception e) {
            System.out.println("MongoDB not available: " + e.getMessage());
        }
    }

    public void sendMessage(String message) {
        String autoReply = generateAutoReply(message);
        System.out.println("Mother: " + message);
        System.out.println("System: " + autoReply);

        try {
            Document doc = new Document("sender", "Mother")
                .append("message", message)
                .append("autoReply", autoReply)
                .append("timestamp", new Date());
            collection.insertOne(doc);
        } catch (Exception e) {
            System.out.println("Save error: " + e.getMessage());
        }
    }

    public void askQuestion(String question) {
        sendMessage(question);
    }

    public List<Document> viewMessages() {
        List<Document> messages = new ArrayList<>();
        try {
            collection.find().into(messages);
        } catch (Exception e) {
            System.out.println("Error fetching messages: " + e.getMessage());
        }
        return messages;
    }

    private String generateAutoReply(String message) {
        String lower = message.toLowerCase();
        if (lower.contains("fever"))
            return "Please monitor the baby's temperature carefully.";
        if (lower.contains("feeding"))
            return "Feeding difficulties may require medical attention.";
        if (lower.contains("crying"))
            return "Persistent crying can indicate discomfort or illness.";
        if (lower.contains("sleep"))
            return "Ensure the baby is in a quiet, dark room.";
        return "Your question has been received by the community.";
    }
}
