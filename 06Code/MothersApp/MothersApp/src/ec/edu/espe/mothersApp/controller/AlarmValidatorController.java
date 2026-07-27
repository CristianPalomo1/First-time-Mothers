/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mothersApp.controller;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import ec.edu.espe.mothersApp.model.MongoConnection;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Jennyfer Nase, Error 404, @ESPE
 */
public class AlarmValidatorController {
    
    private final MongoCollection<Document> alertCollection;

    public AlarmValidatorController() {
        this.alertCollection = MongoConnection.getDatabase().getCollection("healthAssessments");
    }

   
    public String validateAndSaveAssessment(double temperature, boolean respiratory, boolean feeding, boolean skin, boolean lethargy) {
        String riskLevel = "NORMAL RISK";
        String alertMessage = "NORMAL RISK — Baby is stable. Continue standard care.";
        
        int severeSymptoms = (respiratory ? 1 : 0) + (feeding ? 1 : 0) + (skin ? 1 : 0) + (lethargy ? 1 : 0);
        
        if (temperature >= 38.3 || temperature <= 35.5 || severeSymptoms >= 1) {
            riskLevel = "CRITICAL RISK";
            alertMessage = "🚨 CRITICAL RISK — Immediate hospital attention required.";
        } else if (temperature >= 37.5 || severeSymptoms == 1) {
            riskLevel = "WARNING RISK";
            alertMessage = "⚠ WARNING RISK — Mild symptoms. Monitor closely and call a doctor.";
        }

        try {
            Document assessmentDoc = new Document()
                    .append("temperatureCelsius", temperature)
                    .append("symptoms", new Document()
                            .append("respiratoryDistress", respiratory)
                            .append("feedingProblems", feeding)
                            .append("abnormalSkinColor", skin)
                            .append("lethargyOrCrying", lethargy))
                    .append("diagnosedRisk", riskLevel)
                    .append("checkedAt", new Date());

            alertCollection.insertOne(assessmentDoc);
            System.out.println("Health assessment successfully synced to MongoDB collection: healthAssessments");
            
        } catch (Exception e) {
            System.err.println("Database Persistence Error: " + e.getMessage());
        }

        return alertMessage;
    }
}
