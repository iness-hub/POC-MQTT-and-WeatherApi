package nl.fontys.druppelapi.dto;

import nl.fontys.druppelapi.model.GardenHistory;

import java.util.List;

public class GardenDTO {
    private Integer idEsp;
    private Integer minMoisture;
    private Integer maxMoisture;
    private List<GardenHistory> gardenHistories ;

    public GardenDTO(Integer idEsp, Integer minMoisture, Integer maxMoisture, List<GardenHistory> gardenHistories) {
        this.idEsp = idEsp;
        this.minMoisture = minMoisture;
        this.maxMoisture = maxMoisture;
        this.gardenHistories = gardenHistories;
    }

    public Integer getIdEsp() {
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
