package nl.fontys.druppelapi.dto;
import java.util.Date;


public class GardenHistoryDTO {

    private Integer id;
    private Date date;
    private Integer moisture;
    private int gardenEspId;

    public GardenHistoryDTO(Integer id, Date date, Integer moisture, int gardenEspId) {
        this.id = id;
        this.date = date;
        this.moisture = moisture;
        this.gardenEspId = gardenEspId;
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

    public int getGardenEspId() {
        return gardenEspId;
    }

    public void setGardenEspId(int gardenEspId) {
        this.gardenEspId = gardenEspId;
    }
}
