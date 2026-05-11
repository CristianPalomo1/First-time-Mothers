package ec.edu.espe.mothersapp.model;

/**
 * @author Jennyfer Nase, Error 404, @ESPE
 */
public class Baby {
    private String name;
    private String idCard;
    private double weight; 
    private double height; 

    public Baby() {}

    public Baby(String name, String idCard, double weight, double height) {
        this.name = name;
        this.idCard = idCard;
        this.weight = weight;
        this.height = height;
    }
    
    public double calculateBMI() {
        double weightKg = this.weight / 1000;
        double heightM = this.height / 100;
        if (heightM == 0) return 0;
        return weightKg / (heightM * heightM);
    }

    public String getWeightStatus() {
        if (this.weight < 2500) {
            return "Low Birth Weight";
        } else if (this.weight <= 4000) {
            return "Normal Weight";
        } else {
            return "Macrosomia (High Weight)";
        }
    }

    @Override
    public String toString() {
        return String.format(
            "Baby: %s | ID: %s | Weight: %.2fg (%s) | Height: %.2fcm | BMI: %.2f",
            name, idCard, weight, getWeightStatus(), height, calculateBMI()
        );
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getIdCard() { return idCard; }
    public void setIdCard(String idCard) { this.idCard = idCard; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }
}