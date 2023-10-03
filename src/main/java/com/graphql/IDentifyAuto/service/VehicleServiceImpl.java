package com.graphql.IDentifyAuto.service;

import com.graphql.IDentifyAuto.data.dto.ApiResponse;
import com.graphql.IDentifyAuto.data.dto.VehicleDto;
import com.graphql.IDentifyAuto.data.model.Vehicle;
import com.graphql.IDentifyAuto.data.repository.LocationRepository;
import com.graphql.IDentifyAuto.data.repository.VehicleRepository;
import com.graphql.IDentifyAuto.exception.VehicleExistsException;
import com.graphql.IDentifyAuto.exception.VehicleNotFoundException;
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
    public ApiResponse registerVehicle(VehicleDto vehicleDto) {
        Optional<Vehicle> existingVehicle = vehicleRepository.findById(vehicleDto.getVin());
        if (existingVehicle.isPresent()){
            Map<String, Object> params = new HashMap<>();
            params.put("vin", vehicleDto.getVin());
            throw new VehicleExistsException("Failed to add vehicle. Vehicle with vin already present.", params);
        }
        Vehicle vehicle = Vehicle.builder()
                .vin(vehicleDto.getVin())
                .make(vehicleDto.getMake())
                .year(vehicleDto.getYear())
                .model(vehicleDto.getModel())
                .location(vehicleDto.getLocation())
                .build();
       Vehicle savedVehicle =  vehicleRepository.save(vehicle);
        locationRepository.save(vehicleDto.getLocation());
        return getApiResponse(savedVehicle);
    }

    private ApiResponse getApiResponse(Vehicle savedVehicle) {
        return ApiResponse.builder()
                .vin(savedVehicle.getVin())
                .isSuccess(true)
                .message("Vehicle registered successfully")
                .build();
    }

    @Override
    public Vehicle getVehicleByVin(String vin) {
        return vehicleRepository.findById(vin).orElseThrow(
        () -> new VehicleNotFoundException(
                "Vehicle with vin" + vin + "not found"));
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
