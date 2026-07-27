package ec.edu.espe.mothersApp.model;

/**
 * @author Angie Nacato, Error 404, @ESPE
 */
public class AlarmValidator {

    public boolean checkTemperature(double temp) {
        return temp >= 35.5 && temp <= 38.0;
    }

    public boolean checkRespiration(String status) {
        return !status.equalsIgnoreCase("yes");
    }

    public boolean checkFeeding(String status) {
        return !status.equalsIgnoreCase("yes");
    }

    public boolean checkSkinColor(String color) {
        return !color.equalsIgnoreCase("yes");
    }

    public boolean checkActivity(String level) {
        return !level.equalsIgnoreCase("yes");
    }

    public String generateAlert() {
        return "CRITICAL RISK: Immediate hospital attention required.";
    }
}