package ec.edu.espe.mothersApp.model;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 *
 * @author Jennyfer Nase, Error 404, @ESPE
 */

public class GestationCalculator {
    public int calculateWeek(Date LMP, Date currentDate) {
        long diffMs   = currentDate.getTime() - LMP.getTime();
        long diffDays = diffMs / (24 * 60 * 60 * 1000L);
        int  weeks    = (int) (diffDays / 7);

        try {
            MongoCollection<Document> col =
                MongoConnection.getDatabase().getCollection("GestationCalculations");

            LocalDate dueDate = LocalDate.now().plusWeeks(40 - weeks);

            Document doc = new Document("lmpDate",      LMP)
                .append("currentDate",      currentDate)
                .append("gestationWeeks",   weeks)
                .append("estimatedDueDate", dueDate.toString())
                .append("trimester",        getTrimester(weeks));

            col.insertOne(doc);
        } catch (Exception e) {
            System.out.println("MongoDB error: " + e.getMessage());
        }

        return weeks;
    }

    public static GestationResult calculateFromLMP(String lmpDateStr) {
        LocalDate lmpDate   = LocalDate.parse(lmpDateStr);
        int currentWeek     = (int) ChronoUnit.WEEKS.between(lmpDate, LocalDate.now());
        LocalDate dueDate   = lmpDate.plusWeeks(40);
        return new GestationResult(currentWeek, getTrimester(currentWeek),
                                   dueDate.toString(), lmpDateStr, "LMP");
    }

    public static GestationResult calculateFromWeek(int week) {
        int remainingWeeks  = 40 - week;
        LocalDate dueDate   = LocalDate.now().plusWeeks(remainingWeeks);
        return new GestationResult(week, getTrimester(week),
                                   dueDate.toString(), LocalDate.now().toString(), "WEEK");
    }

    public static void saveToMongo(String motherId, GestationResult result) {
        try {
            MongoCollection<Document> col =
                MongoConnection.getDatabase().getCollection("GestationCalculations");
            Document doc = new Document("motherId", motherId)
                .append("method",           result.method)
                .append("currentWeek",      result.currentWeek)
                .append("trimester",        result.trimester)
                .append("estimatedDueDate", result.estimatedDueDate)
                .append("calculatedAt",     new Date());
            col.insertOne(doc);
            System.out.println("Gestation record saved to MongoDB.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static String getTrimester(int week) {
        if (week <= 12)      return "1st Trimester";
        else if (week <= 27) return "2nd Trimester";
        else                 return "3rd Trimester";
    }

    public static class GestationResult {
        public int    currentWeek;
        public String trimester;
        public String estimatedDueDate;
        public String inputDate;
        public String method;

        public GestationResult(int w, String t, String d, String i, String m) {
            this.currentWeek      = w;
            this.trimester        = t;
            this.estimatedDueDate = d;
            this.inputDate        = i;
            this.method           = m;
        }
    }
}
