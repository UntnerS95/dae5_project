package pl.controller;

import java.util.List;
import bl.DriverLogic;
import model.Driver;
import model.Motorcycle;
import model.Track;

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
public class DriverController {
    
    /**
     * 
     * @return a list of all driver entries
     */
    @RequestMapping(value = "/driver", method = { RequestMethod.GET })
    @ResponseBody
    public ResponseEntity<List<?>> getAll() {
        List<Driver> drivers = new DriverLogic().getAll();
        return new ResponseEntity<List<?>>(drivers, HttpStatus.OK);
    }

    /**
     * 
     * @param username the name of the driver entry to be retrieved
     * @return the driver entry with the given username
     */
    @RequestMapping(value = "/driver/{username}", method = { RequestMethod.GET })
    @ResponseBody
    public ResponseEntity<Driver> getDriverByUser(@PathVariable("username") String username) {
        return new ResponseEntity<Driver>(new DriverLogic().getDriver(username), HttpStatus.OK);
    }

    /**
     * deletes a certain driver entry, identified by its username
     * 
     * @param username the username of the driver entry to be deleted
     * @return a success / failure message
     */
    @RequestMapping(value = "/driver/{username}", method = { RequestMethod.DELETE })
    @ResponseBody
    public ResponseEntity<String> deleteDriverByUser(@PathVariable("username") String username) {
        boolean deleted = new DriverLogic().delete(username);
        if (deleted) {
            return new ResponseEntity<String>("Driver with username " + username + " successfully deleted!", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Driver with username " + username + " NOT successfully deleted!",
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @param driver - the driver that should be saved in db
     * @return a success / failure message
     */
    @RequestMapping(value = "driver", method = { RequestMethod.POST, RequestMethod.PUT })
    @ResponseBody
    public ResponseEntity<String> addDriver(@RequestBody Driver driver) {
        boolean saved = new DriverLogic().save(driver);
        if (saved) {
            return new ResponseEntity<String>("Driver " + driver.getUsername() + " successfully saved!",
                HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Driver " + driver.getUsername() + " NOT successfully saved!",
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 
     * @param username the name of the driver, motorcycle entries to be retrieved
     * @return the motorcycle entries from driver with the given username
     */
    @RequestMapping(value = "/driver/{username}/motorcycle", method = { RequestMethod.GET })
    @ResponseBody
    public ResponseEntity<List<?>> getMotorcyclesByUser(@PathVariable("username") String username) {
        List<Motorcycle> motorcycles = new DriverLogic().getMotorcyclesFromDriver(username);
        return new ResponseEntity<List<?>>(motorcycles, HttpStatus.OK);
    }

    /**
     * 
     * @param username the name of the driver, track entries to be retrieved
     * @return the track entries from driver with the given username
     */
    @RequestMapping(value = "/driver/{username}/track", method = { RequestMethod.GET })
    @ResponseBody
    public ResponseEntity<List<?>> getTracksByUser(@PathVariable("username") String username) {
        List<Track> tracks = new DriverLogic().getTracksFromDriver(username);
        return new ResponseEntity<List<?>>(tracks, HttpStatus.OK);
    }
}
