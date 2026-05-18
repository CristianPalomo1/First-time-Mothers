package ec.edu.espe.mothersApp.model;
import java.util.Date;

/**
 * @author Jennyfer Nase, Error 404, @ESPE
 */
public class Baby {

    public String firstName;
    public String lastName;
    public String id;
    public String birthDate;
    public int weightGrams;
    public int height;
    public boolean disability;
    public String gestationPeriod;
    public boolean neonate;

    public Baby(String firstName,String lastName,String id,int weightGrams,int height,String birthDate,boolean disability,String gestationPeriod,boolean neonate)
            
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.weightGrams = weightGrams;
        this.height = height;
        this.birthDate = birthDate;
        this.disability = disability;
        this.gestationPeriod = gestationPeriod;
        this.neonate = neonate;
    }
}