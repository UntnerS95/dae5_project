package model;


/**
 * resource representation class for motorcycle
 * 
 * @author Stefan Untner (S2010306033)
 */
public class Motorcycle {
    private int id;
    private String model;
    private String brand;
    private String type;
    private String driver;

    public Motorcycle(){}
    public Motorcycle(int id, String model, String brand, String type, String driver){
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.type = type;
        this.driver = driver;
    }
    /* --------------- getter functions --------------- */
    public int getId(){ return id; }
    public String getModel(){ return model; }
    public String getBrand(){ return brand; }
    public String getType(){ return type; }
    public String getDriver(){ return driver; }
    /* --------------- setter functions --------------- */
    public void setId(int id){ this.id = id; }
    public void setModel(String model){ this.model = model; }
    public void setBrand(String brand){ this.brand = brand; }
    public void setType(String type){ this.type = type; }
    public void setDriver(String driver){ this.driver = driver; }
}
