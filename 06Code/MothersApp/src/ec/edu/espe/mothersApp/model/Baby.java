package ec.edu.espe.mothersapp.model;

/**
 * @author Jennyfer Nase, Error 404, @ESPE
 */
public class Baby {
    private String firstName;
    private String lastName;
    private String idCard;
    private double weight; 
    private double height; 
    private String birthDate;
    private boolean hasDisability;

    public Baby() {}

    public Baby(String firstName, String lastName, String idCard, double weight, double height, String birthDate, boolean hasDisability) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idCard = idCard;
        this.weight = weight;
        this.height = height;
        this.birthDate = birthDate;
        this.hasDisability = hasDisability;
    }

    public double calculateBMI() {
        double weightKg = this.weight / 1000;
        double heightM = this.height / 100;
        if (heightM == 0) return 0;
        return weightKg / (heightM * heightM);
    }

    public String getGrowthStatus() {
        if (this.weight < 2500 || this.weight > 4500) {
            return "Critical";
        } else if (this.weight >= 2500 && this.weight < 3000) {
            return "Careful";
        } else {
            return "Good/Normal";
        }
    }

    @Override
    public String toString() {
        return String.format(
            "Baby: %s %s | ID: %s | Status: %s | Birth: %s | Disability: %b",
            firstName, lastName, idCard, getGrowthStatus(), birthDate, hasDisability
        );
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getIdCard() { return idCard; }
    public void setIdCard(String idCard) { this.idCard = idCard; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }

    public String getBirthDate() { return birthDate; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }

    public boolean isHasDisability() { return hasDisability; }
    public void setHasDisability(boolean hasDisability) { this.hasDisability = hasDisability; }
}