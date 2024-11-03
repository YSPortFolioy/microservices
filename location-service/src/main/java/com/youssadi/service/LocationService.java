package com.youssadi.service;

import com.youssadi.dto.requests.LocationRequest;
import com.youssadi.dto.responses.LocationResponse;

import java.util.List;

public interface LocationService {
    public long createLocation(LocationRequest locationRequest);
    public void updateLocation(long locationId, LocationRequest locationRequest);
    public void deleteLocation(long locationId);
    public LocationResponse getLocation(long locationId);
    public List<LocationResponse> getAllLocations();
}
