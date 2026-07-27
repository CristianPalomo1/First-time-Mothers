package ec.edu.espe.mothersApp.model;

import java.util.Date;

/**
 *
 * @author Jennyfer Nase, Error 404, @ESPE
 */

public class MedicalRecord {

    private int    id;
    private Date   date;
    private double weight;           
    private double height;          
    private double temperature;      
    private String respiratoryStatus; 
    private String feedingStatus;     
    private String skinColor;          
    private String activityLevel;    
    private String notes;               

    public MedicalRecord() {
        this.date = new Date();
        this.respiratoryStatus = "Normal";
        this.feedingStatus     = "Normal";
        this.skinColor         = "Normal";
        this.activityLevel     = "Normal";
        this.notes             = "";
    }

    public MedicalRecord(int id, double weight, double height, double temperature,
                         String respiratoryStatus, String feedingStatus,
                         String skinColor, String activityLevel, String notes) {
        this.id = id;
        this.date = new Date();
        this.weight = weight;
        this.height = height;
        this.temperature = temperature;
        this.respiratoryStatus = respiratoryStatus;
        this.feedingStatus = feedingStatus;
        this.skinColor = skinColor;
        this.activityLevel = activityLevel;
        this.notes = notes;
    }

    public void addRecord() {
        try {
            com.mongodb.client.MongoCollection<org.bson.Document> col =
                MongoConnection.getDatabase().getCollection("allProjectRecords");

            org.bson.Document doc = new org.bson.Document("id", id)
                .append("date",              date)
                .append("weight",            weight)
                .append("height",            height)
                .append("temperature",       temperature)
                .append("respiratoryStatus", respiratoryStatus)
                .append("feedingStatus",     feedingStatus)
                .append("skinColor",         skinColor)
                .append("activityLevel",     activityLevel)
                .append("notes",             notes);

            col.insertOne(doc);
            System.out.println("Medical record saved to MongoDB.");
        } catch (Exception e) {
            System.out.println("Error saving record: " + e.getMessage());
        }
    }

    public void viewRecord() {
        System.out.println("=== Medical Record ID: " + id + " ===");
        System.out.println("Date:        " + date);
        System.out.println("Weight:      " + weight + " kg");
        System.out.println("Height:      " + height + " cm");
        System.out.println("Temperature: " + temperature + " °C");
        System.out.println("Respiratory: " + respiratoryStatus);
        System.out.println("Feeding:     " + feedingStatus);
        System.out.println("Skin Color:  " + skinColor);
        System.out.println("Activity:    " + activityLevel);
        System.out.println("Notes:       " + notes);
    }

    public void monitorWarningSigns() {
        System.out.println("\n=== WARNING SIGNS MONITOR ===");
        if (temperature > 38 || temperature < 35.5)
            System.out.println("WARNING: Abnormal temperature: " + temperature + "°C");
        if (respiratoryStatus.equalsIgnoreCase("yes"))
            System.out.println("WARNING: Respiratory distress.");
        if (feedingStatus.equalsIgnoreCase("yes"))
            System.out.println("WARNING: Feeding problem.");
        if (skinColor.equalsIgnoreCase("yes"))
            System.out.println("WARNING: Abnormal skin color.");
        if (activityLevel.equalsIgnoreCase("yes"))
            System.out.println("WARNING: Lethargy or inconsolable crying.");
    }

    public int    getId()                         { return id; }
    public void   setId(int v)                    { this.id = v; }
    public Date   getDate()                       { return date; }
    public void   setDate(Date v)                 { this.date = v; }
    public double getWeight()                     { return weight; }
    public void   setWeight(double v)             { this.weight = v; }
    public double getHeight()                     { return height; }
    public void   setHeight(double v)             { this.height = v; }
    public double getTemperature()                { return temperature; }
    public void   setTemperature(double v)        { this.temperature = v; }
    public String getRespiratoryStatus()          { return respiratoryStatus; }
    public void   setRespiratoryStatus(String v)  { this.respiratoryStatus = v; }
    public String getFeedingStatus()              { return feedingStatus; }
    public void   setFeedingStatus(String v)      { this.feedingStatus = v; }
    public String getSkinColor()                  { return skinColor; }
    public void   setSkinColor(String v)          { this.skinColor = v; }
    public String getActivityLevel()              { return activityLevel; }
    public void   setActivityLevel(String v)      { this.activityLevel = v; }
    public String getNotes()                      { return notes; }
    public void   setNotes(String v)              { this.notes = v; }
}
