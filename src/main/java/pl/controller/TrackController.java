package pl.controller;

import java.util.List;
import bl.TrackLogic;
import model.Track;
import model.Points;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Stefan Untner (S2010306033)
 *
 */
@RestController
public class TrackController {
    /**
     * 
     * @return a list of all track entries
     */
    @RequestMapping(value = "/track", method = { RequestMethod.GET })
    @ResponseBody
    public ResponseEntity<List<?>> getAll() {
        List<Track> tracks = new TrackLogic().getAll();
        return new ResponseEntity<List<?>>(tracks, HttpStatus.OK);
    }

    /**
     * 
     * @param trackname the name of the track entry to be retrieved
     * @return the track entry with the given trackname
     */
    @RequestMapping(value = "/track/{trackname}", method = { RequestMethod.GET })
    @ResponseBody
    public ResponseEntity<Track> getTrackByName(@PathVariable("trackname") String trackname) {
        return new ResponseEntity<Track>(new TrackLogic().getTrack(trackname), HttpStatus.OK);
    }

    /**
     * deletes a certain track entry, identified by its trackname
     * 
     * @param trackname the name of the track entry to be deleted
     * @return a success / failure message
     */
    @RequestMapping(value = "/track/{trackname}", method = { RequestMethod.DELETE })
    @ResponseBody
    public ResponseEntity<String> deleteTrackByName(@PathVariable("trackname") String trackname) {
        boolean deleted = new TrackLogic().delete(trackname);
        if (deleted) {
            return new ResponseEntity<String>("Track with name " + trackname + " successfully deleted!", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Track with name " + trackname + " NOT successfully deleted!",
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @param track - the track that should be saved in db
     * @return a success / failure message
     */
    @RequestMapping(value = "track", method = { RequestMethod.POST, RequestMethod.PUT })
    @ResponseBody
    public ResponseEntity<String> addTrack(@RequestBody Track track) {
        boolean saved = new TrackLogic().save(track);
        if (saved) {
            return new ResponseEntity<String>("Track " + track.getName() + " successfully saved!",
                HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Track " + track.getName() + " NOT successfully saved!",
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 
     * @param trackname the name of the track, point entries to be retrieved
     * @return the point entries from track with the given trackname
     */
    @RequestMapping(value = "/track/{trackname}/points", method = { RequestMethod.GET })
    @ResponseBody
    public ResponseEntity<List<?>> getPointsByName(@PathVariable("trackname") String trackname) {
        List<Points> points = new TrackLogic().getPointsFromTrack(trackname);
        return new ResponseEntity<List<?>>(points, HttpStatus.OK);
    }
}
