package nl.fontys.druppelapi.service;

import nl.fontys.druppelapi.dto.GardenDTO;
import nl.fontys.druppelapi.model.Garden;
import nl.fontys.druppelapi.repository.GardenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GardenService {
    @Autowired
    private GardenRepository gardenRepository;

    public List<Garden> findAll(){
        return (List<Garden>) gardenRepository.findAll();
    }

    public void save (GardenDTO gardenDTO){
        Garden garden = new Garden();
        garden.setIdEsp(gardenDTO.getIdEsp());
        garden.setMinMoisture(gardenDTO.getMinMoisture());
        garden.setMaxMoisture(gardenDTO.getMaxMoisture());
        garden.setGardenHistories(gardenDTO.getGardenHistories());

        gardenRepository.save(garden);
    }
    public Garden get(Integer id){
        return gardenRepository.findById(id).get();
    }
    public void delete (Integer id){
        gardenRepository.deleteById(id);
    }
}
