package nl.fontys.druppelapi.model;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "garden" )
public class Garden {

    @Id
    @Column(name = "id_esp", nullable = false, updatable = false)
    private Integer idEsp;
    private Integer minMoisture;
    private Integer maxMoisture;

    @OneToMany(targetEntity = GardenHistory.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "garden_id_esp",referencedColumnName = "id_esp")
    private List<GardenHistory> gardenHistories ;

    public Garden() {
    }

    public Garden(Integer idEsp, Integer minMoisture, Integer maxMoisture, List<GardenHistory> gardenHistories) {
        this.idEsp = idEsp;
        this.minMoisture = minMoisture;
        this.maxMoisture = maxMoisture;
        this.gardenHistories = gardenHistories;
    }

    public Garden(Integer idEsp) {
        this.idEsp = idEsp;
    }

    public Integer getIdEsp(){
        return idEsp;
    }

    public void setIdEsp(Integer idEsp) {
        this.idEsp = idEsp;

    }

    public Integer getMinMoisture() {
        return minMoisture;
    }

    public void setMinMoisture(Integer minMoisture) {
        this.minMoisture = minMoisture;
    }

    public Integer getMaxMoisture() {
         return maxMoisture;
    }

    public void setMaxMoisture(Integer maxMoisture) {
        this.maxMoisture = maxMoisture;

    }

    public List<GardenHistory> getGardenHistories() {
        return gardenHistories;
    }

    public void setGardenHistories(List<GardenHistory> gardenHistories) {
    this.gardenHistories = gardenHistories;
    }
}