package nl.fontys.druppelapi.controller;

import org.eclipse.paho.client.mqttv3.*;

public class MqttController implements MqttCallback {
    public static MqttAsyncClient myClient;
    public static void connect(String broker, String  clientId) throws MqttException {
      myClient = new MqttAsyncClient(broker, clientId);
      MqttController myCallback = new MqttController();
      myClient.setCallback(myCallback);

        IMqttToken token = myClient.connect();
        token.waitForCompletion();
        myClient.subscribe("garden/esp-15730009/moisture",0);
        sendMessage("garden/esp-15730009/pump","PumpOn");

    }

    @Override
    public void connectionLost(Throwable cause) {
        System.out.println("Connection lost because: " + cause);
        System.exit(1);

    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        System.out.println(mqttMessage);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }



    public static void sendMessage(String topic, String payload) throws MqttException {

        MqttMessage message = new MqttMessage(payload.getBytes());
        message.setQos(0);
        myClient.publish(topic, message);
    }
   }
