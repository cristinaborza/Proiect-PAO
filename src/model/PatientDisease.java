package model;

public class PatientDisease {
    private int patientID, diseaseID;

    public PatientDisease(int patientID, int diseaseID) {
        this.patientID = patientID;
        this.diseaseID = diseaseID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getDiseaseID() {
        return diseaseID;
    }

    public void setDiseaseID(int diseaseID) {
        this.diseaseID = diseaseID;
    }
}
