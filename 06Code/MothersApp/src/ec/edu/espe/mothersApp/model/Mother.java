package ec.edu.espe.mothersApp.model;

/**
 * @author Jennyfer Nase, Error 404, @ESPE
 */
public class Mother {

    public String firstName;
    public String lastName;
    public String id;
    public String birthDate;

    public Mother(String firstName, String lastName,
                  String id, String birthDate) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.birthDate = birthDate;
    }
}