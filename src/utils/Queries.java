package utils;

public class Queries {
    public static final String RETRIEVE_ALL_PATIENT_DISEASES =  "SELECT * FROM proiect_pao.patient pat\n" +
                                                                "JOIN proiect_pao.patient_disease pd ON (pat.id = pd.patientId)\n" +
                                                                "JOIN proiect_pao.disease dis ON (dis.id = pd.diseaseId)";
    public static final String RETRIEVE_ALL_DOCTORS = "SELECT * FROM proiect_pao.doctor";
    public static final String RETRIEVE_ALL_ASSISTANTS = "SELECT * FROM proiect_pao.assistant";
    public static final String RETRIEVE_ALL_RESIDENTS = "SELECT * FROM proiect_pao.resident";

    public static final String INSERT_NEW_DOCTOR = "INSERT INTO doctor(id, firstName, lastName, age, email, phone, sex, salary, experience, specialization) values (null,?,?,?,?,?,?,?,?,?)";
    public static final String INSERT_NEW_ASSISTANT = "INSERT INTO assistant(id, firstName, lastName, age, email, phone, sex, salary, experience, studies) values (null,?,?,?,?,?,?,?,?,?)";
    public static final String INSERT_NEW_RESIDENT = "INSERT INTO resident(id, firstName, lastName, age, email, phone, sex, salary, experience, graduationDate) values (null,?,?,?,?,?,?,?,?,?)";
}
