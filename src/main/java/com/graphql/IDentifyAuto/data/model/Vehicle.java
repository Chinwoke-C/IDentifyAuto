package com.graphql.IDentifyAuto.data.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vehicle {
    @Id
    private String vin;
    private String make;
    private String year;
    private String model;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_location")
    private Location location;
}
