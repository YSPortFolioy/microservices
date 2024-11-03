package com.youssadi.clients;

import com.youssadi.dto.responses.LocationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="gateway")
public interface LocationFeignClient {
    @GetMapping("/location-service/api/locations/{id}")
    LocationResponse getLocationById(@PathVariable("id") long locationId);

}
