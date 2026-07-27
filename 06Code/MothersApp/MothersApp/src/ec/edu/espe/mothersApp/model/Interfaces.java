package ec.edu.espe.mothersApp.model;

import java.util.Date;
import java.util.List;

/**
 * @author Angie Nacato, Error 404, @ESPE
 */

interface IValidator {
    boolean validate();
}

interface IProfile {
    void updateProfile();
    void viewProfile();
}

interface ISearchable {
    String search(String keyword);
}

interface IAppointment {
    void schedule();
    void cancel();
    void reschedule(Date newDate, Date newTime);
}

interface IRecordRepository {
    void saveRecord(MedicalRecord record);
    List<MedicalRecord> getRecords(int babyId);
    Object getProfile(int userId);
}

