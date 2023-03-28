package pl.controller;

import java.util.List;
import bl.MotorcycleLogic;
import model.Motorcycle;

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
public class MotorcycleController {
    
    /**
     * 
     * @return a list of all motorcycle entries
     */
    @RequestMapping(value = "/motorcycle", method = { RequestMethod.GET })
    @ResponseBody
    public ResponseEntity<List<?>> getAll() {
        List<Motorcycle> motorcycles = new MotorcycleLogic().getAll();
        return new ResponseEntity<List<?>>(motorcycles, HttpStatus.OK);
    }

    /**
     * 
     * @param id the id of the motorcycle entry to be retrieved
     * @return the motorcycle entry with the given id
     */
    @RequestMapping(value = "/motorcycle/{id}", method = { RequestMethod.GET })
    @ResponseBody
    public ResponseEntity<Motorcycle> getMotorcycleById(@PathVariable("id") int id) {
        return new ResponseEntity<Motorcycle>(new MotorcycleLogic().getMotorcycle(id), HttpStatus.OK);
    }

    /**
     * deletes a certain motorcycle entry, identified by its id
     * 
     * @param id the id of the motorcycle entry to be deleted
     * @return a success / failure message
     */
    @RequestMapping(value = "/motorcycle/{id}", method = { RequestMethod.DELETE })
    @ResponseBody
    public ResponseEntity<String> deleteMotorcycleById(@PathVariable("id") int id) {
        boolean deleted = new MotorcycleLogic().delete(id);
        if (deleted) {
            return new ResponseEntity<String>("Motorcycle with id " + String.valueOf(id) + " successfully deleted!", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Motorcycle with id " + String.valueOf(id) + " NOT successfully deleted!",
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @param motorcycle - the motorcycle that should be saved in db
     * @return a success / failure message
     */
    @RequestMapping(value = "motorcycle", method = { RequestMethod.POST, RequestMethod.PUT })
    @ResponseBody
    public ResponseEntity<String> addMotorcycle(@RequestBody Motorcycle motorcycle) {
        boolean saved = new MotorcycleLogic().save(motorcycle);
        if (saved) {
            return new ResponseEntity<String>("Motorcycle " + motorcycle.getBrand() + " " + motorcycle.getModel() + " successfully saved!",
                HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Motorcycle " + motorcycle.getBrand() + " " + motorcycle.getModel() + " NOT successfully saved!",
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
