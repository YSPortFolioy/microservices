package com.youssadi.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class LocationResponse {
    private long locationId;
    private double longitude;
    private double latitude;
}
