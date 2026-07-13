package ec.edu.espe.mothersApp.model;

import java.util.ArrayList;

/**
 * @author Angie Nacato, Error 404, @ESPE
 */
public class Mother extends Person implements IValidator {

    private String idNumber;      
    private boolean disability;  
    private int age;              

    public String firstName;
    public String lastName;
    public String id;
    public String birthDate;
    public double weight;
    public double height;
    public ArrayList<Baby> babies;

    public Mother(int personId, String firstName, String lastName,
                  String idNumber, boolean disability, int age) {
        super(personId, firstName, lastName);
        this.idNumber   = idNumber;
        this.disability = disability;
        this.age        = age;
        
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.id         = idNumber;
        this.birthDate  = "";
        this.weight     = 0;
        this.height     = 0;
        this.babies     = new ArrayList<>();
    }

    public Mother(String firstName, String lastName, String id, 
                  String birthDate, double weight, double height) {
        super(0, firstName, lastName);
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.id         = id;
        this.idNumber   = id;
        this.birthDate  = birthDate;
        this.weight     = weight;
        this.height     = height;
        this.disability = false;
        this.age        = 0;
        this.babies     = new ArrayList<>();
    }

    @Override
    public void updateProfile() {
    }

    @Override
    public void viewProfile() {
    }

    @Override
    public void displayInfo() {
        viewProfile();
    }

    @Override
    public boolean validate() {
        return idNumber != null && idNumber.matches("\\d{1,20}");
    }

    public String getIdNumber() { 
        return idNumber; 
    }
    
    public void setIdNumber(String v) { 
        this.idNumber = v; 
    }
    
    public boolean isDisability() { 
        return disability; 
    }
    
    public void setDisability(boolean v) { 
        this.disability = v; 
    }
    
    public int getAge() { 
        return age; 
    }
    
    public void setAge(int v) { 
        this.age = v; 
    }
}