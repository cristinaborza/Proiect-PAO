package utils;

public class Queries {
    public static final String RETRIEVE_ALL_PATIENT_DISEASES =  "SELECT * FROM proiect_pao.patient pat\n" +
                                                                "JOIN proiect_pao.patient_disease pd ON (pat.id = pd.patientId)\n" +
                                                                "JOIN proiect_pao.disease dis ON (dis.id = pd.diseaseId)";
}
