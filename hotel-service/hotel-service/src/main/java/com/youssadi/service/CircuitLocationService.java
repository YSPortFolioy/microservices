package com.youssadi.service;

import com.youssadi.clients.LocationFeignClient;
import com.youssadi.dto.responses.LocationResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CircuitLocationService {
    @Autowired
    private LocationFeignClient locationFeignClient;
    Logger logger = LoggerFactory.getLogger(CircuitLocationService.class);
    int count =1;
    @CircuitBreaker(name = "locationService", fallbackMethod = "getDummyLocation")
    public LocationResponse getLocationById(long locationId){
        logger.info("count of calls of this method : "+count);
        count++;
        LocationResponse locationResponse = locationFeignClient.getLocationById(locationId);
        return locationResponse;
    }
    public LocationResponse getDummyLocation(long locationId, Throwable throwable){
        logger.info("Error " + throwable.getMessage());
        return new LocationResponse();
    }
}
