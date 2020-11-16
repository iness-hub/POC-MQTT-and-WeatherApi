package nl.fontys.druppelapi.controller;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/mqtt")
public class MqttControllerTest implements MqttCallback {

    private String broker = "tcp://127.0.0.1:1883";
    private String clientId = "SpringApplicatie";
    MemoryPersistence persistence = new MemoryPersistence();

    @PostMapping(path="/post") // localhost:8080/mqtt?content=fdafdafwa
    public ResponseEntity postMqtt(@RequestParam("topic") String topic, @RequestParam("content") String content) {
        try {
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: "+broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            System.out.println("Publishing message: "+content);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(2);
            sampleClient.publish(topic, message);
            System.out.println("Message published");
            sampleClient.disconnect();
            System.out.println("Disconnected");
        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
        return ResponseEntity.ok("Published to: " + topic);
    }

    @GetMapping(path="/get")
    public ResponseEntity getMqtt(@RequestParam("topic") String topic) {

        return ResponseEntity.ok("");
    }

    @Override
    public void connectionLost(Throwable throwable) {

    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        System.out.println(s + " message: " + mqttMessage);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}
