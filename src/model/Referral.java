package model;

public class Referral extends Document{
    private Doctor doctorRef;
    private Clinic clinic;

    public Referral(String date, Doctor doctor, Patient patient, Doctor doctorRef, Clinic clinic) {
        super(date, doctor, patient);
        this.doctorRef = doctorRef;
        this.clinic = clinic;
    }

    public Doctor getDoctorRef() {
        return doctorRef;
    }

    public void setDoctorRef(Doctor doctorRef) {
        this.doctorRef = doctorRef;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }
}
