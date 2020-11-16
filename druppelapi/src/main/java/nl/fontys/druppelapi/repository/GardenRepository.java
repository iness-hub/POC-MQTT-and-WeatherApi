package nl.fontys.druppelapi.repository;

import nl.fontys.druppelapi.model.Garden;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GardenRepository extends CrudRepository<Garden, Integer> {
}
