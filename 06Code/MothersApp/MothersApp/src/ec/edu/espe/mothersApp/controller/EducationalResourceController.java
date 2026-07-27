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
public class EducationalResourceController {
  private final MongoCollection<Document> collection;

    private final String[][] tipsMatrix = {
        {
            "Keep the room quiet and dark.",
            "Rock the baby gently.",
            "Avoid loud noises before bedtime."
        },
        {
            "Ensure the baby's mouth is wide open like a yawn.",
            "Bring the baby to the breast, not the breast to the baby.",
            "Make sure the baby's chin touches the breast first."
        },
        {
            "Hold the baby upright against your chest.",
            "Gently pat or rub the baby's back for a few minutes.",
            "Sit the baby on your lap, supporting their chin and chest."
        },
        {
            "Check if the diaper needs to be changed.",
            "Offer a pacifier or check if it has been too long since the last feeding.",
            "CRITICAL: If the baby has been crying constantly for more than 2 hours and has a fever, contact your pediatrician immediately."
        },
        {
            "Keep the cord stump clean and dry. Wash your hands before touching it.",
            "Let the stump fall off naturally; never pull or tug at it.",
            "WARNING: If you notice redness, foul odor, or pus around the umbilical cord, seek medical attention."
        }
    };

    private final String[][] colorsMatrix = {
        { "NORMAL", "NORMAL", "NORMAL" },
        { "NORMAL", "NORMAL", "NORMAL" },
        { "NORMAL", "NORMAL", "NORMAL" },
        { "NORMAL", "NORMAL", "DANGER" },
        { "NORMAL", "NORMAL", "WARNING" }
    };

    public EducationalResourceController() {
        this.collection = MongoConnection.getDatabase().getCollection("EducationalResources");
    }
    public String getTipContent(int topicIndex, int tipIndex) {
        String content = tipsMatrix[topicIndex][tipIndex];
        String alertLevel = colorsMatrix[topicIndex][tipIndex];

        try {
            Document logDoc = new Document("action", "Viewed Educational Tip")
                    .append("topicIndex", topicIndex)
                    .append("tipIndex", tipIndex)
                    .append("contentPreview", content)
                    .append("alertLevel", alertLevel)
                    .append("viewedAt", Calendar.getInstance().getTime());
            
            collection.insertOne(logDoc);
            System.out.println("¡Visualización de recurso educativo guardada en MongoDB!");
        } catch (Exception e) {
            System.out.println("Error al guardar log en MongoDB: " + e.getMessage());
        }

        return content;
    }

    
    public String getAlertLevel(int topicIndex, int tipIndex) {
        return colorsMatrix[topicIndex][tipIndex];
    }

  
    public int getTipsCount(int topicIndex) {
        return tipsMatrix[topicIndex].length;
    }  

  
    public void viewGuide() {
        try {
            Document guideDoc = new Document("action", "View Guide Overview")
                    .append("timestamp", Calendar.getInstance().getTime());
            collection.insertOne(guideDoc);
            System.out.println("Operación viewGuide registrada en MongoDB.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public String searchTopic(String keyword) {
        try {
            Document searchDoc = new Document("action", "Search Topic")
                    .append("keyword", keyword)
                    .append("timestamp", Calendar.getInstance().getTime());
            collection.insertOne(searchDoc);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return "Resultados para: " + keyword;
    }
}
