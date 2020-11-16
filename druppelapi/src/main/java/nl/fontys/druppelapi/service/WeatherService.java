package nl.fontys.druppelapi.service;

import nl.fontys.druppelapi.repository.WeatherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    @Autowired
    private WeatherRepo weatherRepo;
}
