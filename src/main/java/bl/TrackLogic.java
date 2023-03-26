package bl;

import dal.implementation.TrackDao;
import dal.interfaces.Dao;
import java.util.List;
import java.util.Optional;
import model.Track;
import model.Points;

/**
 * 
 * @author Stefan Untner (S2010306033)
 *
 */
public class TrackLogic {
    /* instance of a default DAO implementation */
    private Dao<Track> dao = new TrackDao();

    public boolean delete(String name) {
        Track trackToDelete = new Track();
        trackToDelete.setName(name);
        boolean deleted = false;
        try {
            deleted = dao.delete(trackToDelete);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deleted;
    }

    public List<Track> getAll(){
        Optional<List<Track>> trackList = null;
        try{
            trackList = dao.getAll();
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

    public boolean save(Track t) {
        boolean saved = false;
        try {
            saved = dao.save(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saved;
    }

    public Track getTrack(String name){
        Optional<Track> foundTrack = null;
        TrackDao trackDao = new TrackDao();
        try{
            foundTrack = trackDao.getByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (foundTrack != null && foundTrack.isPresent()) {
            return foundTrack.get();
        }
        else {
            return null;
        }
    }

    public List<Points> getPointsFromTrack(String name){
        Optional<List<Points>> pointsList = null;
        TrackDao trackDao = new TrackDao();
        try{
            pointsList = trackDao.getPointsByTrack(name);
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
}
