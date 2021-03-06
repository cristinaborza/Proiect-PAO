package model;

import java.time.LocalDate;
import java.util.List;

public class Prescription extends Document{
    private List<Drug> drugs;

    public Prescription(LocalDate date, Doctor doctor, Patient patient, List<Drug> drugs) {
        super(date, doctor, patient);
        this.drugs = drugs;
    }

    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }
}
