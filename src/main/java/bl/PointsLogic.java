package bl;

import dal.implementation.PointsDao;
import dal.interfaces.Dao;
import java.util.List;
import java.util.Optional;
import model.Points;

/**
 * 
 * @author Stefan Untner (S2010306033)
 *
 */
public class PointsLogic {
    /* instance of a default DAO implementation */
    private Dao<Points> dao = new PointsDao();

    public boolean delete(int number) {
        Points pointToDelete = new Points();
        pointToDelete.setId(number);
        boolean deleted = false;
        try {
            deleted = dao.delete(pointToDelete);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deleted;
    }

    public List<Points> getAll(){
        Optional<List<Points>> pointsList = null;
        try{
            pointsList = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (pointsList != null && pointsList.isPresent()) {
            return pointsList.get();
        }
        else {
            return null;
        }
    }

    public boolean save(Points p) {
        boolean saved = false;
        try {
            saved = dao.save(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saved;
    }

    public Points getPoint(int number){
        Optional<Points> foundPoint = null;
        PointsDao pointsDao = new PointsDao();
        try{
            foundPoint = pointsDao.getById(number);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (foundPoint != null && foundPoint.isPresent()) {
            return foundPoint.get();
        }
        else {
            return null;
        }
    }
}
