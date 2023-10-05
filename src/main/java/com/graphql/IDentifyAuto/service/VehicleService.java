package com.graphql.IDentifyAuto.service;

import com.graphql.IDentifyAuto.data.dto.ApiResponse;
import com.graphql.IDentifyAuto.data.dto.VehicleDto;
import com.graphql.IDentifyAuto.data.model.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle registerVehicle(VehicleDto vehicleDto);
    Vehicle getVehicleByVin(String vin);
    List<Vehicle> getAllVehicles();
    List<Vehicle> searchByLocation(String zipCode);
}
