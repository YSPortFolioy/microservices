package com.youssadi.dto.requests;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LocationRequest {

    @Min(value = -180, message = "longitude must be between -180 and 180")
    @Max(value = 180, message = "longitude must be between -180 and 180")
    private double longitude;
    @Min(value = -90, message = "Latitude must be between -90 and 90")
    @Max(value = 90, message = "Latitude must be between -90 and 90")
    private double latitude;
}
