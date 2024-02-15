package com.example;

import jakarta.enterprise.context.ApplicationScoped;
import org.apache.camel.builder.RouteBuilder;

@ApplicationScoped
public class FlightIntegrationRoutes extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("kafka:{{topic}}?brokers={{broker}}")
                .log("recieve a flight cancellation request message for flight ${body}")
                .multicast()
                .to("kafka:pax-topic?brokers={{broker}}")
                .to("kafka:crew-topic?brokers={{broker}}");

        /*from("kafka:{{topic}}?brokers={{broker}}&sslKeystoreLocation=/home/jboss/user.jks" +
                "&sslKeystorePassword=password" +
                "&sslKeyPassword=password" +
                "&sslTruststoreLocation=/home/jboss/ca.jks" +
                "&sslTruststorePassword=password" +
                "&securityProtocol=SSL")
                .log("Message received from Kafka : ${body}")
                .log("    on the topic ${headers[kafka.TOPIC]}")
                .log("    on the partition ${headers[kafka.PARTITION]}")
                .log("    with the offset ${headers[kafka.OFFSET]}")
                .log("    with the key ${headers[kafka.KEY]}")
                .to("kafka:{{topic}}?brokers={{broker}}&sslKeystoreLocation=/home/jboss/user.jks" +
                        "&sslKeystorePassword=password" +
                        "&sslTruststoreLocation=/home/jboss/ca.jks" +
                        "&sslTruststorePassword=password" +
                        "&sslKeyPassword=password" +
                        "&securityProtocol=SSL")
                .log("message sent to the topic");*/


    }
}
