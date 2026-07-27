package ec.edu.espe.mothersApp.model;

/**
 *
 * @author Angie Ñacato, Error 404, @ESPE
 */

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommunityActivity {

    private int    id;
    private String title;
    private String description;
    private String category;
    private String symptom;
    private String target;
    private Date   datePublished;

    private List<Slide> slides;
    private int currentSlideIndex = 0;

    public CommunityActivity() {
        this.slides        = new ArrayList<>();
        this.datePublished = new Date();
    }

    public CommunityActivity(int id, String title, String description,
                             String category, String symptom, String target) {
        this();
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.symptom = symptom;
        this.target = target;
    }

    public void viewGuide() {
        if (slides.isEmpty()) {
            System.out.println("No slides available for: " + title);
            return;
        }
        currentSlideIndex = 0;
        slides.get(0).showSlide();
        saveViewLog("viewGuide");
    }

    public void nextSlide() {
        if (currentSlideIndex < slides.size() - 1) {
            currentSlideIndex++;
            slides.get(currentSlideIndex).showSlide();
        } else {
            System.out.println("Already at last slide.");
        }
    }

    public void previousSlide() {
        if (currentSlideIndex > 0) {
            currentSlideIndex--;
            slides.get(currentSlideIndex).showSlide();
        } else {
            System.out.println("Already at first slide.");
        }
    }

    public String searchTopc(String keyword) {
        try {
            MongoCollection<Document> col =
                MongoConnection.getDatabase().getCollection("EducationalResources");
            Document result = col.find(
                new Document("$or", List.of(
                    new Document("title",    new Document("$regex", keyword).append("$options","i")),
                    new Document("category", new Document("$regex", keyword).append("$options","i")),
                    new Document("symptom",  new Document("$regex", keyword).append("$options","i"))
                ))
            ).first();
            return result != null ? result.toJson() : "No results for: " + keyword;
        } catch (Exception e) {
            return "Search error: " + e.getMessage();
        }
    }

    public void addSlide(Slide slide) {
        slides.add(slide);
    }

    private void saveViewLog(String action) {
        try {
            MongoCollection<Document> col =
                MongoConnection.getDatabase().getCollection("EducationalResources");
            Document doc = new Document("action", action)
                .append("activityId",    id)
                .append("activityTitle", title)
                .append("timestamp",     new Date());
            col.insertOne(doc);
        } catch (Exception e) {
            System.out.println("Log error: " + e.getMessage());
        }
    }

    public int    getId()                      
        { return id; }
    public void   setId(int v)                 
        { this.id = v; }
    public String getTitle()                   
        { return title; }
    public void   setTitle(String v)           
        { this.title = v; }
    public String getDescription()             
        { return description; }
    public void   setDescription(String v)     
        { this.description = v; }
    public String getCategory()                
        { return category; }
    public void   setCategory(String v)        
        { this.category = v; }
    public String getSymptom()                 
        { return symptom; }
    public void   setSymptom(String v)         
        { this.symptom = v; }
    public String getTarget()                  
        { return target; }
    public void   setTarget(String v)          
        { this.target = v; }
    public Date   getDatePublished()           
        { return datePublished; }
    public void   setDatePublished(Date v)     
        { this.datePublished = v; }
    public List<Slide> getSlides()             
        { return slides; }
    public Slide  getCurrentSlide() {
        return slides.isEmpty() ? null : slides.get(currentSlideIndex);
    }
}