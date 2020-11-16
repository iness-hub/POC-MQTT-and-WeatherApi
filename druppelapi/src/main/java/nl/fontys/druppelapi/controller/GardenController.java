package nl.fontys.druppelapi.controller;

import nl.fontys.druppelapi.dto.GardenDTO;
import nl.fontys.druppelapi.model.Garden;
import nl.fontys.druppelapi.service.GardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;



@RestController // This means that this class is a Controller
@Component
@EnableAutoConfiguration
@RequestMapping(path="/garden") // This means URL's start with /garden (after Application path)
public class GardenController {

    @Autowired // This means to get the bean called gardenService
    private GardenService gardenService;

   /* @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody
    String addNewGarden(@RequestParam Integer idEsp
            , @RequestParam Integer minMoisture, @RequestParam Integer maxMoisture) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Garden garden = new Garden();
        garden.setIdEsp(idEsp);
        garden.setMinMoisture(minMoisture);
        garden.setMaxMoisture(maxMoisture);
        gardenService.save(garden);
        return "Saved";
    }*/

    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody String addNewGarden(@RequestBody GardenDTO gardenDTO) {
        gardenService.save(gardenDTO);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Garden> getAllGarden() {

        return gardenService.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity  get(@PathVariable("id") Integer id) {
       // return gardenService.get(id);
        System.out.println(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
