package com.youssadi.clients;

import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
/*
@LoadBalancerClient(value = "location-service")
public class LocationLoadBalancer {
    @Bean
    @LoadBalanced
    Feign.Builder feignBuilder(){
        return Feign.builder();
    }
}

 */
