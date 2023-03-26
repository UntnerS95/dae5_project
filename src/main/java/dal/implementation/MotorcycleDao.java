package dal.implementation;

import dal.interfaces.Dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import model.Motorcycle;

/**
 * 
 * @author Stefan Untner (S2010306033)
 *
 */
public class MotorcycleDao extends DaoBase implements Dao<Motorcycle> {
    
    public Optional<Motorcycle> getById(int id){
        String selectMotorcycleByUsernameQuery;
        selectMotorcycleByUsernameQuery = "SELECT * FROM motorcycle WHERE number = " + id + ";";
        Motorcycle m = null;
        Statement stmt;
        try{
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectMotorcycleByUsernameQuery);
            if(rs.next()){
                int number = rs.getInt("number");
                String model = rs.getString("model_description");
                String brand = rs.getString("brand");
                String type = rs.getString("type_description");
                String driver = rs.getString("username");
                m = new Motorcycle(number,model,brand,type,driver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return Optional.ofNullable(m);
    }

    @Override
    public boolean delete(Motorcycle m) {
        String deleteMotorcycleQuery;
        deleteMotorcycleQuery = "DELETE FROM motorcycle WHERE number = ?;";
        int affectedRows = 0;
        try {
            PreparedStatement deleteMotorcycleStatement = conn.prepareStatement(deleteMotorcycleQuery);
            deleteMotorcycleStatement.setInt(1, m.getId());
            affectedRows = deleteMotorcycleStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return affectedRows == 1;
    }

    @Override
    public Optional<List<Motorcycle>> getAll() {
        String selectMotorcycleQuery;
        selectMotorcycleQuery = "SELECT * FROM motorcycle;";
        List<Motorcycle> motorcycles = new ArrayList<Motorcycle>();
        try {
            ResultSet rs = conn.createStatement().executeQuery(selectMotorcycleQuery);
            while (rs.next()) {
                int number = rs.getInt("number");
                String model = rs.getString("model_description");
                String brand = rs.getString("brand");
                String type = rs.getString("type_description");
                String driver = rs.getString("username");
                motorcycles.add(new Motorcycle(number,model,brand,type,driver));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return Optional.ofNullable(motorcycles);
    }

    @Override
    public boolean save(Motorcycle m) {
        String addNewMotorcycleQuery = "INSERT INTO motorcycle VALUES ("
            + m.getId() + m.getModel() + m.getBrand() + m.getType() + m.getDriver() + ");";
        int affectedRows = 0;
        try {
            Statement stmt = conn.createStatement();
            affectedRows = stmt.executeUpdate(addNewMotorcycleQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return affectedRows == 1;
    }
}
