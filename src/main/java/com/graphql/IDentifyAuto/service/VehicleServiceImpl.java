package com.graphql.IDentifyAuto.service;

import com.graphql.IDentifyAuto.data.dto.ApiResponse;
import com.graphql.IDentifyAuto.data.dto.VehicleDto;
import com.graphql.IDentifyAuto.data.model.Vehicle;
import com.graphql.IDentifyAuto.data.repository.LocationRepository;
import com.graphql.IDentifyAuto.data.repository.VehicleRepository;
import com.graphql.IDentifyAuto.exception.VehicleExistsException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService{
    private final VehicleRepository vehicleRepository;
    private final LocationRepository locationRepository;

    @Override
    @Transactional
    public ApiResponse addVehicle(VehicleDto vehicleDto) {
        Optional<Vehicle> existingVehicle = vehicleRepository.findById(vehicleDto.getVin());
        if (existingVehicle.isPresent()){
            Map<String, Object> params = new HashMap<>();
            params.put("vin", vehicleDto.getVin());
            throw new VehicleExistsException("Failed to add vehicle. Vehicle with vin already present.", params);
        }

    }

    @Override
    public Vehicle getVehicleByVin(String vin) {
        return null;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return null;
    }

    @Override
    public List<Vehicle> searchByLocation(String zipCode) {
        return null;
    }
}
