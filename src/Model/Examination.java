package Model;

import java.io.LineNumberInputStream;
import java.util.List;

public class Examination extends Appointment{
    private String verdict;
    private List<Prescription> prescriptions;
    private List<Referral> referrals;

    public Examination(String date, Patient patient, Doctor doctor, int price, String verdict, List<Prescription> prescriptions, List<Referral> referrals) {
        super(date, patient, doctor, price);
        this.verdict = verdict;
        this.prescriptions = prescriptions;
        this.referrals = referrals;
    }

    public String getVerdict() {
        return verdict;
    }

    public void setVerdict(String verdict) {
        this.verdict = verdict;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public List<Referral> getReferrals() {
        return referrals;
    }

    public void setReferrals(List<Referral> referrals) {
        this.referrals = referrals;
    }
}
