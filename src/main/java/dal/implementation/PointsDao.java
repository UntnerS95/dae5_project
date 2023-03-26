package dal.implementation;

import dal.interfaces.Dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.postgresql.geometric.PGpoint;
import model.Points;

/**
 * 
 * @author Stefan Untner (S2010306033)
 *
 */
public class PointsDao extends DaoBase implements Dao<Points> {
    
    public Optional<Points> getById(int number){
        String selectPointsByUsernameQuery;
        selectPointsByUsernameQuery = "SELECT * FROM points WHERE number = " + number + ";";
        Points p = null;
        Statement stmt;
        try{
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectPointsByUsernameQuery);
            if(rs.next()){
                int id = rs.getInt("number");
                PGpoint location = (PGpoint)rs.getArray("location");
                String type = rs.getString("type");
                String description = rs.getString("description");
                String trackName = rs.getString("track_name");;
                p = new Points(id,location,type,description,trackName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return Optional.ofNullable(p);
    }

    @Override
    public boolean delete(Points p) {
        String deletePointsQuery;
        deletePointsQuery = "DELETE FROM points WHERE number = ?;";
        int affectedRows = 0;
        try {
            PreparedStatement deletePointsStatement = conn.prepareStatement(deletePointsQuery);
            deletePointsStatement.setInt(1, p.getId());
            affectedRows = deletePointsStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return affectedRows == 1;
    }

    @Override
    public Optional<List<Points>> getAll() {
        String selectPointsQuery;
        selectPointsQuery = "SELECT * FROM points;";
        List<Points> points = new ArrayList<Points>();
        try {
            ResultSet rs = conn.createStatement().executeQuery(selectPointsQuery);
            while (rs.next()) {
                int id = rs.getInt("number");
                PGpoint location = (PGpoint)rs.getArray("location");
                String type = rs.getString("type");
                String description = rs.getString("description");
                String trackName = rs.getString("track_name");;
                points.add(new Points(id,location,type,description,trackName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return Optional.ofNullable(points);
    }

    @Override
    public boolean save(Points p) {
        String addNewPointsQuery = "INSERT INTO points VALUES ("
            + p.getId() + p.getLocation() + p.getType() + p.getDescription() + p.getTrackName() + ");";
        int affectedRows = 0;
        try {
            Statement stmt = conn.createStatement();
            affectedRows = stmt.executeUpdate(addNewPointsQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return affectedRows == 1;
    }
}
