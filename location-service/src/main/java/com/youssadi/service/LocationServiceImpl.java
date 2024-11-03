package com.youssadi.service;

import com.youssadi.dao.LocationRepository;
import com.youssadi.domain.Location;
import com.youssadi.dto.requests.LocationRequest;
import com.youssadi.dto.responses.LocationResponse;
import com.youssadi.exceptions.LocationNotFoundException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.EventRecordingLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;

    private static final Logger logger = LoggerFactory.getLogger(LocationServiceImpl.class);

    @Override
    public long createLocation(LocationRequest locationRequest) {
        Location location = new Location();
        location.setLatitude(locationRequest.getLatitude());
        location.setLongitude(locationRequest.getLongitude());
        locationRepository.save(location);
        return location.getLocationId();
    }

    @Override
    public void updateLocation(long locationId, LocationRequest locationRequest) {
        Location loc = locationRepository.findById(locationId).
                orElseThrow(() -> new LocationNotFoundException("location not found for id : " + locationId));

        loc.setLatitude(locationRequest.getLatitude());
        loc.setLongitude(locationRequest.getLongitude());
        locationRepository.save(loc);
    }


    @Override
    public void deleteLocation(long locationId) {
        Location loc = locationRepository.findById(locationId).
                orElseThrow(() -> new LocationNotFoundException("location not found for id : " + locationId));
        locationRepository.delete(loc);
    }

    @Override
    public LocationResponse getLocation(long locationId) {
        logger.info("call for getLocation inside location-service for id : " + locationId);
        Location loc = locationRepository.findById(locationId).
                orElseThrow(() -> new LocationNotFoundException("location not found for id : " + locationId));
        LocationResponse locationResponse = new LocationResponse();

        locationResponse.setLocationId(loc.getLocationId());
        locationResponse.setLatitude(loc.getLatitude());
        locationResponse.setLongitude(loc.getLongitude());


        return locationResponse;
    }

    @Override
    public List<LocationResponse> getAllLocations() {
        List<LocationResponse> locations = new ArrayList<>();
        List<Location> locs = locationRepository.findAll();
        for (Location loc : locs) {
            LocationResponse locationResponse = new LocationResponse();
            locationResponse.setLocationId(loc.getLocationId());
            locationResponse.setLatitude(loc.getLatitude());
            locationResponse.setLongitude(loc.getLongitude());
            locations.add(locationResponse);
        }
        return locations;

    }
}
