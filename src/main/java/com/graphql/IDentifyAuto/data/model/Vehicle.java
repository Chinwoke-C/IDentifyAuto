package com.graphql.IDentifyAuto.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vehicle {
    @Id
    private long vin;
    private String make;
    private String year;
    private String model;
    @ManyToOne(fetch = FetchType.LAZY)
    private Location location;
}
