package ec.edu.espe.mothersapp.model;

import java.util.ArrayList;

/**
 * @author Jennyfer Nase, Error 404, @ESPE
 */
public class Mother {

    private String firstName;
    private String lastName;
    private String idCard; 
    private String birthDate;
    private String lastMenstrualPeriod; 
    private ArrayList<Baby> babies;

    public Mother() {
        this.babies = new ArrayList<>();
    }

    public Mother(String firstName, String lastName, String idCard, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idCard = idCard;
        this.birthDate = birthDate;
        this.babies = new ArrayList<>();
    }

    public void addBaby(Baby baby) {
        this.babies.add(baby);
    }

    public Baby getBabyById(String id) {
        for (Baby b : babies) {
            if (b.getIdCard() != null && b.getIdCard().equals(id)) {
                return b;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format(
            "Mother: %s %s | ID: %s | Babies: %d", 
            firstName, lastName, idCard, babies.size()
        );
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getIdCard() { return idCard; }
    public void setIdCard(String idCard) { this.idCard = idCard; }

    public String getBirthDate() { return birthDate; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }

    public String getLastMenstrualPeriod() { return lastMenstrualPeriod; }
    public void setLastMenstrualPeriod(String lastMenstrualPeriod) { this.lastMenstrualPeriod = lastMenstrualPeriod; }

    public ArrayList<Baby> getBabies() { return babies; }
    public void setBabies(ArrayList<Baby> babies) { this.babies = babies; }
}