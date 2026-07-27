/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mothersApp.model;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 *
<<<<<<< HEAD:06Code/MothersApp/src/ec/edu/espe/mothersApp/model/MongoConnection.java
 * @author sbart
=======
 * @author Jennyfer Nase, Error 404, @ESPE
>>>>>>> 174b2d62278d6f772fd72a06419e16e4835eb939:06Code/MothersApp_1/MothersApp/src/ec/edu/espe/mothersApp/model/MongoConnection.java
 */
public class MongoConnection {
    private static final String CONNECTION_STRING = "mongodb+srv://Jennyfer:jennyfer@jennyfer.owlaicw.mongodb.net/?appName=Jennyfer";
    private static MongoClient mongoClient = null;

    public static MongoDatabase getDatabase() {
        if (mongoClient == null) {
            mongoClient = MongoClients.create(CONNECTION_STRING);
        }
        return mongoClient.getDatabase("MothersAppDB");
    }
}
