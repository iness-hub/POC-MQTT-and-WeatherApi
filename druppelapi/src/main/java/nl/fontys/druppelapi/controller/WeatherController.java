package nl.fontys.druppelapi.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.fontys.druppelapi.model.WeatherPojo;
import nl.fontys.druppelapi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@Component
@EnableAutoConfiguration
@RequestMapping(path="/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping(path = "/data")
    public String get() throws Exception {
        String uri = "http://weerlive.nl/api/json-data-10min.php?key=demo&locatie=Amsterdam";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        return response.body();

    }


    @GetMapping(path = "/JsonNode")
    public JsonNode gettest() throws Exception {

        String uri = "http://weerlive.nl/api/json-data-10min.php?key=demo&locatie=Amsterdam";


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        ObjectMapper m = new ObjectMapper();
        m.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES,false);
        JsonNode node =m.readTree(response.body()).get("liveweer").get(0);
        System.out.println("temperature from node : "+node.get("temp").asText());

        WeatherPojo weatherPojo = m.treeToValue(node,WeatherPojo.class);
        System.out.println("temperature from weatherPojo : "+weatherPojo.getTemp());
        return node;

    }

}
