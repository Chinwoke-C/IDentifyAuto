package com.graphql.IDentifyAuto.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "location")
public class Location {
    @Id
    private String zipCode;
    private String city;
    private String state;

    @OneToMany(mappedBy = "location", fetch = FetchType.EAGER)
    private List<Vehicle> vehicles = new ArrayList<>();

}
