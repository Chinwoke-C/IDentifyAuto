package com.graphql.IDentifyAuto.data.repository;

import com.graphql.IDentifyAuto.data.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
}
