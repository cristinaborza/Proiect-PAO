package repository;

import model.Patient;
import utils.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import static utils.Queries.RETRIEVE_ALL_PATIENT_DISEASES;

public class CabinetRepository {
    private DbConnection dbConnection = DbConnection.getInstance();

    public List<Patient> retrieveAllPatients() {
        List<Patient> patients = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(RETRIEVE_ALL_PATIENT_DISEASES);
            ResultSet resultSet = preparedStatement.executeQuery();

            HashMap<Integer, Patient> mp = new HashMap<>();
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                List<String> diseases = new ArrayList<>();
                if(mp.containsKey(id)) {
                    diseases = mp.get(id).getDiseases();
                }

                diseases.add(resultSet.getString(11));
                mp.put(id, new Patient(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), diseases));
            }

            for(Patient patient : mp.values())
                patients.add(patient);
        } catch(SQLException exception) {
            exception.printStackTrace();
        }

        return patients;
    }
}
