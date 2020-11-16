package nl.fontys.druppelapi.model;

import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.util.Date;


@Entity // This tells Hibernate to make a table out of this class
@Table(name = "garden_history" )

public class GardenHistory {

    @Id
    private Integer id;


    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "moisture")
    private Integer moisture;

    @Column( name= "garden_id_esp")
    private Integer gardenIdEsp;

    public GardenHistory() {
    }

    public GardenHistory(Integer id, Date date, Integer moisture, Integer gardenIdEsp) {
        this.id = id;
        this.date = date;
        this.moisture = moisture;
        this.gardenIdEsp = gardenIdEsp;
         }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getMoisture() {
        return moisture;
    }

    public void setMoisture(Integer moisture) {
        this.moisture = moisture;
    }

    public Integer getGardenIdEsp() {
        return gardenIdEsp;
    }

    public void setGardenIdEsp(Integer gardenIdEsp) {
        this.gardenIdEsp = gardenIdEsp;
    }
}



