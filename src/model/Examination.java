package model;

import java.util.List;

public class Examination extends Appointment{
    private String verdict;

    public Examination() {
        super();
    }
    public Examination(int id, String date, Patient patient, Doctor doctor, int price, String verdict) {
        super(id, date, patient, doctor, price);
        this.verdict = verdict;
    }

    public String getVerdict() {
        return verdict;
    }

    public void setVerdict(String verdict) {
        this.verdict = verdict;
    }
}
