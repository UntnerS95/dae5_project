package model;

import java.util.Date;

/**
 * resource representation class for driver
 * 
 * @author Stefan Untner (S2010306033)
 */
public class Driver {
    private String username;
    private Date dateOfBirth;
    private String origin;
    private String firstName;
    private String lastName;

    public Driver(){}
    public Driver(String user, Date date, String origin, String firstName, String lastName){
        this.username = user;
        this.dateOfBirth = date;
        this.origin = origin;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    /* --------------- getter functions --------------- */
    public String getUsername(){ return username; }
    public Date getDateOfBirth(){ return dateOfBirth; }
    public String getOrigin(){ return origin; }
    public String getFirstName(){ return firstName; }
    public String getLastName(){ return lastName; }
    /* --------------- setter functions --------------- */
    public void setUsername(String user){ this.username = user; }
    public void setDateOfBirth(Date date){ this.dateOfBirth = date; }
    public void setOrigin(String origin){ this.origin = origin; }
    public void setFirstName(String firstName){ this.firstName = firstName; }
    public void setLastName(String lastName){ this.lastName = lastName; }
}
