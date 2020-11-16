package nl.fontys.druppelapi.repository;

import nl.fontys.druppelapi.model.Weather;
import org.springframework.data.repository.CrudRepository;

public interface WeatherRepo extends CrudRepository<Weather,Integer> {

}
