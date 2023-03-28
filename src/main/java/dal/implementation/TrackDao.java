package dal.implementation;

import dal.interfaces.Dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.postgresql.geometric.PGpoint;
import model.Points;
import model.Track;

/**
 * 
 * @author Stefan Untner (S2010306033)
 *
 */
public class TrackDao extends DaoBase implements Dao<Track> {
    
    public Optional<Track> getByName(String track){
        String selectTrackByUsernameQuery;
        selectTrackByUsernameQuery = "SELECT * FROM track WHERE name = '" + track + "';";
        Track t = null;
        Statement stmt;
        try{
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectTrackByUsernameQuery);
            if(rs.next()){
                String name = rs.getString("name");
                float duration = rs.getFloat("duration");
                Timestamp creationDate = rs.getTimestamp("date_of_creation");
                Timestamp changeDate = rs.getTimestamp("date_of_change");
                int difficulty = rs.getInt("difficulty");
                String driver = rs.getString("username");
                int motorcycleId = rs.getInt("bike_number");
                t = new Track(name,duration,creationDate,changeDate,difficulty,driver,motorcycleId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return Optional.ofNullable(t);
    }

    @Override
    public boolean delete(Track t) {
        String deleteTrackQuery;
        deleteTrackQuery = "DELETE FROM track WHERE name = ?;";
        int affectedRows = 0;
        try {
            PreparedStatement deleteTrackStatement = conn.prepareStatement(deleteTrackQuery);
            deleteTrackStatement.setString(1, t.getName());
            affectedRows = deleteTrackStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return affectedRows == 1;
    }

    @Override
    public Optional<List<Track>> getAll() {
        String selectTrackQuery;
        selectTrackQuery = "SELECT * FROM track;";
        List<Track> tracks = new ArrayList<Track>();
        try {
            ResultSet rs = conn.createStatement().executeQuery(selectTrackQuery);
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

    @Override
    public boolean save(Track t) {
        String addNewTrackQuery = "INSERT INTO track VALUES ("
            + t.getName() + t.getDuration() + t.getCreationDate() + t.getChangeDate() + t.getDifficulty()
            + t.getDriver() + t.getMotorcycleId() + ");";
        int affectedRows = 0;
        try {
            Statement stmt = conn.createStatement();
            affectedRows = stmt.executeUpdate(addNewTrackQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return affectedRows == 1;
    }

    public Optional<List<Points>> getPointsByTrack(String track){
        String selectDriverQuery;
        selectDriverQuery = "SELECT * FROM points WHERE track_name = '" + track + "';";
        List<Points> points = new ArrayList<Points>();
        try {
            ResultSet rs = conn.createStatement().executeQuery(selectDriverQuery);
            while (rs.next()) {
                int id = rs.getInt("number");
                PGpoint location = new PGpoint(rs.getString("location"));
                String type = rs.getString("type");
                String description = rs.getString("description");
                String trackName = rs.getString("track_name");
                points.add(new Points(id,location,type,description,trackName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return Optional.ofNullable(points);
    }
}
