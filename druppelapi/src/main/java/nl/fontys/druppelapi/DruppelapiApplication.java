package nl.fontys.druppelapi;

import nl.fontys.druppelapi.controller.MqttController;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication (scanBasePackages={"nl.fontys.druppelapi"})
@ComponentScan(basePackages ={"nl.fontys.druppelapi.controller","nl.fontys.druppelapi.service","nl.fontys.druppelapi.model","nl.fontys.druppelapi.repository"})


public class DruppelapiApplication {

    public static void main(String[] args) throws MqttException {
        SpringApplication.run(DruppelapiApplication.class, args);
        MqttController.connect("tcp://192.168.2.35:1883","DruppelApi");

    }

}
