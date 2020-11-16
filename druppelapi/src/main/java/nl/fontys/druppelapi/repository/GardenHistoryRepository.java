package nl.fontys.druppelapi.repository;

import nl.fontys.druppelapi.model.GardenHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface GardenHistoryRepository extends CrudRepository<GardenHistory, Integer> {
    @Query ("Select avg (moisture) From GardenHistory Where date >= ?1 and date<=?2" )
    public Float averageMoisture (Date date1, Date date2);

}

