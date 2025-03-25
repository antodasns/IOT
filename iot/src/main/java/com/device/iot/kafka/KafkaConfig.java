package com.device.iot.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic deviceEventsTopic() {
        return new NewTopic("thingwire.devices.events", 1, (short) 1);
    }

    @Bean
    public NewTopic deviceCommandsTopic() {
        return new NewTopic("thingwire.devices.commands", 1, (short) 1);
    }

    @Bean
    public NewTopic deviceResponsesTopic() {
        return new NewTopic("thingwire.devices.responses", 1, (short) 1);
    }
}



