package repository;

import model.Assistant;
import model.Doctor;
import model.Patient;
import model.Resident;
import utils.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static utils.Queries.*;

public class CabinetRepository {
    private final DbConnection dbConnection = DbConnection.getInstance();

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

            patients.addAll(mp.values());
        } catch(SQLException exception) {
            exception.printStackTrace();
        }

        return patients;
    }

    public List<Doctor> retrieveAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(RETRIEVE_ALL_DOCTORS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Doctor doctor = new Doctor(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8), resultSet.getInt(9), resultSet.getString(10));
                doctors.add(doctor);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return doctors;
    }

    public List<Resident> retrieveAllResidents() {
        List<Resident> residents = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(RETRIEVE_ALL_RESIDENTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Resident resident = new Resident(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8), resultSet.getInt(9), resultSet.getDate(10).toLocalDate());
                residents.add(resident);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return residents;
    }

    public List<Assistant> retrieveAllAssistants() {
        List<Assistant> assistants = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(RETRIEVE_ALL_ASSISTANTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Assistant assistant = new Assistant(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8), resultSet.getInt(9), resultSet.getString(10));
                assistants.add(assistant);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return assistants;
    }
}
