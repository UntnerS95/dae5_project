package model;

import org.postgresql.geometric.PGpoint;

/**
 * resource representation class for points
 * 
 * @author Stefan Untner (S2010306033)
 */
public class Points {

    private int id;
    private PGpoint location;
    private String type;
    private String description;
    private String trackName;

    public Points(){}
    public Points(int id, PGpoint coordinates, String type, String description, String trackName){
        this.id = id;
        this.location = coordinates;
        this.type = type;
        this.description = description;
        this.trackName = trackName;
    }
    /* --------------- getter functions --------------- */
    public int getId(){ return id; }
    public PGpoint getLocation(){ return location; }
    public String getType(){ return type; }
    public String getDescription(){ return description; }
    public String getTrackName(){ return trackName; }
    /* --------------- setter functions --------------- */
    public void setId(int id){ this.id = id; }
    public void setLocation(PGpoint coordinates){ this.location = coordinates; }
    public void setType(String type){ this.type = type; }
    public void setDescription(String description){ this.description = description; }
    public void setTrackName(String trackName){ this.trackName = trackName; }
}
