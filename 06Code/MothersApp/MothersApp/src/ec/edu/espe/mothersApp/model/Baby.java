package ec.edu.espe.mothersApp.model;

/**
 * @author Angie Ñacato, Error 404, @ESPE
 */

public class Baby {

    private double weight;        
    private double height;      
    private String gender;     
    private String lastName;      
    private boolean disability;   

    public String firstName;
    public String id;
    public String birthDate;
    public boolean born;
    public int gestationPeriod;
    public int months;

    public Baby(String firstName, String lastName, String id,
                double weight, double height,
                String birthDate, boolean born) {
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.id         = id;
        this.weight     = weight;
        this.height     = height;
        this.birthDate  = birthDate;
        this.born       = born;
        this.gender     = "";
        this.disability = false;
        this.gestationPeriod = 0;
        this.months     = 0;
    }

    public Baby(String firstName, String lastName, String id,
                double weight, double height, String gender,
                String birthDate, boolean born, boolean disability) {
        this(firstName, lastName, id, weight, height, birthDate, born);
        this.gender     = gender;
        this.disability = disability;
    }


    public void updateInfo(double weight, double height, boolean disability) {
        this.weight     = weight;
        this.height     = height;
        this.disability = disability;
        System.out.println("Baby info updated: " + firstName + " " + lastName);
    }

    public void viewInfo() {
        System.out.println("Baby: " + firstName + " " + lastName
            + " | Weight: " + weight + "g"
            + " | Height: " + height + "cm"
            + " | Gender: " + gender
            + " | Disability: " + disability);
    }

    public double getWeight()              
        { return weight; }
    public void   setWeight(double v)      
        { this.weight = v; }
    public double getHeight()              
        { return height; }
    public void   setHeight(double v)      
        { this.height = v; }
    public String getGender()             
        { return gender; }
    public void   setGender(String v)     
        { this.gender = v; }
    public String getLastName()           
        { return lastName; }
    public void   setLastName(String v)   
        { this.lastName = v; }
    public boolean isDisability()         
        { return disability; }
    public void   setDisability(boolean v)
        { this.disability = v; }
}