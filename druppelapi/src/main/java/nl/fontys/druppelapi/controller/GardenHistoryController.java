package nl.fontys.druppelapi.controller;

import nl.fontys.druppelapi.dto.GardenHistoryDTO;
import nl.fontys.druppelapi.model.Garden;
import nl.fontys.druppelapi.model.GardenHistory;
import nl.fontys.druppelapi.service.GardenHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController // This means that this class is a Controller
@EnableAutoConfiguration
@RequestMapping(path="/gardenHistory") // This means URL's start with /gardenHistory (after Application path)
public class GardenHistoryController {

    @Autowired // This means to get the bean called gardenHistoryService
    private GardenHistoryService gardenHistoryService;

  /*  @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewGardenHistory (@RequestParam Date date
            , @RequestParam Integer moisture,@RequestParam Integer idEsp ) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        GardenHistory gardenHistory = new GardenHistory();
        Garden garden  = new Garden(idEsp);
        gardenHistory.setId(idEsp);
        gardenHistory.setDate(date);
        gardenHistory.setMoisture(moisture);
        gardenHistory.setGarden(garden);

        gardenHistoryService.save(gardenHistory);
        return "Saved";
    }*/
    @PostMapping(path="/add") // Map ONLY POST Requests
  public @ResponseBody String addNewGardenHistory (@RequestBody GardenHistoryDTO gardenHistoryDTO) {
          gardenHistoryService.save(gardenHistoryDTO);
      return "Saved";
  }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<GardenHistory> getAllGardenHistory() {
        // This returns a JSON or XML with the GardenHistories
        return gardenHistoryService.findAll();
    }

    @GetMapping(path="/average")
    public @ResponseBody Float getAverageGardenHistory() {
        return gardenHistoryService.averageTest();
    }

    @GetMapping(path="/{id}")
    public GardenHistory get(@PathVariable Integer id){
        return gardenHistoryService.get(id);

    }
}