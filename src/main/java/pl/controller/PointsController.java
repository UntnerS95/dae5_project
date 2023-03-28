package pl.controller;

import java.util.List;
import bl.PointsLogic;
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
public class PointsController {

    /**
     * 
     * @return a list of all point entries
     */
    @RequestMapping(value = "/points", method = { RequestMethod.GET })
    @ResponseBody
    public ResponseEntity<List<?>> getAll() {
        List<Points> points = new PointsLogic().getAll();
        return new ResponseEntity<List<?>>(points, HttpStatus.OK);
    }

    /**
     * 
     * @param id the id of the point entry to be retrieved
     * @return the point entry with the given id
     */
    @RequestMapping(value = "/points/{id}", method = { RequestMethod.GET })
    @ResponseBody
    public ResponseEntity<Points> getPointsById(@PathVariable("id") int id) {
        return new ResponseEntity<Points>(new PointsLogic().getPoint(id), HttpStatus.OK);
    }

    /**
     * deletes a certain point entry, identified by its id
     * 
     * @param id the id of the point entry to be deleted
     * @return a success / failure message
     */
    @RequestMapping(value = "/points/{id}", method = { RequestMethod.DELETE })
    @ResponseBody
    public ResponseEntity<String> deletePointsById(@PathVariable("id") int id) {
        boolean deleted = new PointsLogic().delete(id);
        if (deleted) {
            return new ResponseEntity<String>("Point with id " + String.valueOf(id) + " successfully deleted!", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Point with id " + String.valueOf(id) + " NOT successfully deleted!",
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @param point - the point that should be saved in db
     * @return a success / failure message
     */
    @RequestMapping(value = "point", method = { RequestMethod.POST, RequestMethod.PUT })
    @ResponseBody
    public ResponseEntity<String> addPoints(@RequestBody Points point) {
        boolean saved = new PointsLogic().save(point);
        if (saved) {
            return new ResponseEntity<String>("Point with id " + String.valueOf(point.getId()) + " successfully saved!",
                HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Point with id " + String.valueOf(point.getId()) + " NOT successfully saved!",
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
