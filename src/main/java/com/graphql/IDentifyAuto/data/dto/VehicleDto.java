package com.graphql.IDentifyAuto.data.dto;

import com.graphql.IDentifyAuto.data.model.Location;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleDto {
    private String vin;
    private String make;
    private String year;
    private String model;
    private Location location;
}
