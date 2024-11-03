package com.youssadi.controller;

import com.youssadi.dto.requests.LocationRequest;
import com.youssadi.dto.responses.LocationResponse;
import com.youssadi.service.LocationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/locations")
@AllArgsConstructor
public class LocationController {
    private LocationService locationService;
    @PostMapping
    public ResponseEntity<Void> createLocation(@Valid @RequestBody LocationRequest locationRequest) {
        long id = locationService.createLocation(locationRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{locationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateLocation(@PathVariable("locationId") long id , @Valid @RequestBody LocationRequest locationRequest) {
        locationService.updateLocation(id, locationRequest);
    }
    @GetMapping("/{locationId}")
    public ResponseEntity<LocationResponse> getLocation(@PathVariable long locationId) {
        LocationResponse locationResponse = locationService.getLocation(locationId);
        return ResponseEntity.ok().body(locationResponse);
    }
    @GetMapping
    public List<LocationResponse> getAllLocations() {

        return locationService.getAllLocations();
    }
    @DeleteMapping("/{locationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLocation(@PathVariable long locationId) {
            locationService.deleteLocation(locationId);
    }
}
