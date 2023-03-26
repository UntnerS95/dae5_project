package bl;

import dal.implementation.MotorcycleDao;
import dal.interfaces.Dao;
import java.util.List;
import java.util.Optional;
import model.Motorcycle;

/**
 * 
 * @author Stefan Untner (S2010306033)
 *
 */
public class MotorcycleLogic {
    /* instance of a default DAO implementation */
    private Dao<Motorcycle> dao = new MotorcycleDao();

    public boolean delete(int number) {
        Motorcycle motorcycleToDelete = new Motorcycle();
        motorcycleToDelete.setId(number);
        boolean deleted = false;
        try {
            deleted = dao.delete(motorcycleToDelete);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deleted;
    }

    public List<Motorcycle> getAll(){
        Optional<List<Motorcycle>> motorcycleList = null;
        try{
            motorcycleList = dao.getAll();
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

    public boolean save(Motorcycle m) {
        boolean saved = false;
        try {
            saved = dao.save(m);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saved;
    }

    public Motorcycle getMotorcycle(int number){
        Optional<Motorcycle> foundMotorcycle = null;
        MotorcycleDao motorcycleDao = new MotorcycleDao();
        try{
            foundMotorcycle = motorcycleDao.getById(number);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (foundMotorcycle != null && foundMotorcycle.isPresent()) {
            return foundMotorcycle.get();
        }
        else {
            return null;
        }
    }
}
