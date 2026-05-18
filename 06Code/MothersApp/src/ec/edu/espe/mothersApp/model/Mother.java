package ec.edu.espe.mothersApp.model;

/**
 * @author Jennyfer Nase, Error 404, @ESPE
 */
public class Mother {
    public String firstName;
    public String lastName;
    public String identificationNumber;
    public String birthDate;
    public double weight;
    public double height;

    public Mother(String firstName, String lastName,String identificationNumber,String birthDate,double weight,double height)
            
    {

        this.firstName = firstName;
        this.lastName = lastName;
        this.identificationNumber = identificationNumber;
        this.birthDate = birthDate;
        this.weight = weight;
        this.height = height;
    }
}