package dal.implementation;

import dal.interfaces.Dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import model.Driver;
import model.Motorcycle;
import model.Track;

/**
 * 
 * @author Stefan Untner (S2010306033)
 *
 */
public class DriverDao extends DaoBase implements Dao<Driver> {

    public Optional<Driver> getByName(String user){
        String selectDriverByUsernameQuery;
        selectDriverByUsernameQuery = "SELECT * FROM driver WHERE username = " + user + ";";
        Driver d = null;
        Statement stmt;
        try{
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectDriverByUsernameQuery);
            if(rs.next()){
                String username = rs.getString("username");
                Date dateOfBirth = rs.getDate("date_of_birth");
                String origin = rs.getString("origin");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                d = new Driver(username,dateOfBirth,origin,firstName,lastName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return Optional.ofNullable(d);
    }

    @Override
    public boolean delete(Driver d) {
        String deleteDriverQuery;
        deleteDriverQuery = "DELETE FROM driver WHERE username = ?;";
        int affectedRows = 0;
        try {
            PreparedStatement deleteDriverStatement = conn.prepareStatement(deleteDriverQuery);
            deleteDriverStatement.setString(1, d.getUsername());
            affectedRows = deleteDriverStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return affectedRows == 1;
    }

    @Override
    public Optional<List<Driver>> getAll() {
        String selectDriverQuery;
        selectDriverQuery = "SELECT * FROM driver;";
        List<Driver> drivers = new ArrayList<Driver>();
        try {
            ResultSet rs = conn.createStatement().executeQuery(selectDriverQuery);
            while (rs.next()) {
                String username = rs.getString("username");
                Date dateOfBirth = rs.getDate("date_of_birth");
                String origin = rs.getString("origin");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                drivers.add(new Driver(username,dateOfBirth,origin,firstName,lastName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return Optional.ofNullable(drivers);
    }

    @Override
    public boolean save(Driver d) {
        String addNewDriverQuery = "INSERT INTO driver VALUES ("
            + d.getUsername() + d.getDateOfBirth() + d.getOrigin() + d.getFirstName() + d.getLastName() + ");";
        int affectedRows = 0;
        try {
            Statement stmt = conn.createStatement();
            affectedRows = stmt.executeUpdate(addNewDriverQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return affectedRows == 1;
    }

    public Optional<List<Motorcycle>> getMotorcyclesByDriver(String user){
        String selectDriverQuery;
        selectDriverQuery = "SELECT * FROM motorcycle WHERE username = " + user + ";";
        List<Motorcycle> motorcycles = new ArrayList<Motorcycle>();
        try {
            ResultSet rs = conn.createStatement().executeQuery(selectDriverQuery);
            while (rs.next()) {
                int id = rs.getInt("number");
                String model = rs.getString("model_description");
                String brand = rs.getString("brand");
                String type = rs.getString("type_description");
                String driver = rs.getString("username");
                motorcycles.add(new Motorcycle(id,model,brand,type,driver));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return Optional.ofNullable(motorcycles);
    }

    public Optional<List<Track>> getTracksByDriver(String user){
        String selectDriverQuery;
        selectDriverQuery = "SELECT * FROM track WHERE username = " + user + ";";
        List<Track> tracks = new ArrayList<Track>();
        try {
            ResultSet rs = conn.createStatement().executeQuery(selectDriverQuery);
            while (rs.next()) {
                String name = rs.getString("name");
                float duration = rs.getFloat("duration");
                Timestamp creationDate = rs.getTimestamp("date_of_creation");
                Timestamp changeDate = rs.getTimestamp("date_of_change");
                int difficulty = rs.getInt("difficulty");
                String driver = rs.getString("username");
                int motorcycleId = rs.getInt("bike_number");
                tracks.add(new Track(name,duration,creationDate,changeDate,difficulty,driver,motorcycleId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return Optional.ofNullable(tracks);
    }
}
