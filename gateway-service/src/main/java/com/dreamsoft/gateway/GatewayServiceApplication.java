package com.dreamsoft.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

    @Bean
    DiscoveryClientRouteDefinitionLocator locator(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties properties) {
        DiscoveryClientRouteDefinitionLocator discoveryClientRouteDefinitionLocator=new DiscoveryClientRouteDefinitionLocator(rdc, properties);
        log.info("############ route definitions {}: ",discoveryClientRouteDefinitionLocator.getRouteDefinitions());

        return discoveryClientRouteDefinitionLocator;
    }

}
