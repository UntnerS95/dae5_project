package bl;

import dal.implementation.DriverDao;
import dal.interfaces.Dao;
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
public class DriverLogic {
    /* instance of a default DAO implementation */
    private Dao<Driver> dao = new DriverDao();

    public boolean delete(String name) {
        Driver driverToDelete = new Driver();
        driverToDelete.setUsername(name);
        boolean deleted = false;
        try {
            deleted = dao.delete(driverToDelete);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deleted;
    }

    public List<Driver> getAll(){
        Optional<List<Driver>> driverList = null;
        try{
            driverList = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (driverList != null && driverList.isPresent()) {
            return driverList.get();
        }
        else {
            return null;
        }
    }

    public boolean save(Driver d) {
        boolean saved = false;
        try {
            saved = dao.save(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saved;
    }

    public Driver getDriver(String name){
        Optional<Driver> foundDriver = null;
        DriverDao driverDao = new DriverDao();
        try{
            foundDriver = driverDao.getByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (foundDriver != null && foundDriver.isPresent()) {
            return foundDriver.get();
        }
        else {
            return null;
        }
    }

    public List<Motorcycle> getMotorcyclesFromDriver(String name){
        Optional<List<Motorcycle>> motorcycleList = null;
        DriverDao driverDao = new DriverDao();
        try{
            motorcycleList = driverDao.getMotorcyclesByDriver(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (motorcycleList != null && motorcycleList.isPresent()) {
            return motorcycleList.get();
        }
        else {
            return null;
        }
    }

    public List<Track> getTracksFromDriver(String name){
        Optional<List<Track>> trackList = null;
        DriverDao driverDao = new DriverDao();
        try{
            trackList = driverDao.getTracksByDriver(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (trackList != null && trackList.isPresent()) {
            return trackList.get();
        }
        else {
            return null;
        }
    }

}
