package model;

import java.sql.Timestamp;

/**
 * resource representation class for track
 * 
 * @author Stefan Untner (S2010306033)
 */
public class Track {
    private String name;
    private float duration;
    private Timestamp creationDate;
    private Timestamp changeDate;
    private int difficulty;
    private String driver;
    private int motorcycleId;

    public Track(){}
    public Track(String name, float duration, Timestamp creation, Timestamp change, int difficulty, String driver, int motorcycleId){
        this.name = name;
        this.duration = duration;
        this.creationDate = creation;
        this.changeDate = change;
        this.difficulty = difficulty;
        this.driver = driver;
        this.motorcycleId = motorcycleId;
    }
    /* --------------- getter functions --------------- */
    public String getName(){ return name; }
    public float getDuration(){ return duration; }
    public Timestamp getCreationDate(){ return creationDate; }
    public Timestamp getChangeDate(){ return changeDate; }
    public int getDifficulty(){ return difficulty; }
    public String getDriver(){ return driver; }
    public int getMotorcycleId(){ return motorcycleId;}
    /* --------------- setter functions --------------- */
    public void setName(String name){ this.name = name; }
    public void setDuration(float duration){ this.duration = duration; }
    public void setCreationDate(Timestamp creation){ this.creationDate = creation; }
    public void setChangeDate(Timestamp change){ this.changeDate = change; }
    public void setDifficulty(int difficulty){ this.difficulty = difficulty; }
    public void setDriver(String driver){ this.driver = driver; }
    public void setMotorcycleId(int motorcycleId){ this.motorcycleId = motorcycleId;}
}
