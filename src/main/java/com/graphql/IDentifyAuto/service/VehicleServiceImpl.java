package com.graphql.IDentifyAuto.service;

import com.graphql.IDentifyAuto.data.dto.ApiResponse;
import com.graphql.IDentifyAuto.data.dto.VehicleDto;
import com.graphql.IDentifyAuto.data.model.Location;
import com.graphql.IDentifyAuto.data.model.Vehicle;
import com.graphql.IDentifyAuto.data.repository.LocationRepository;
import com.graphql.IDentifyAuto.data.repository.VehicleRepository;
import com.graphql.IDentifyAuto.exception.InvalidInputException;
import com.graphql.IDentifyAuto.exception.VehicleExistsException;
import com.graphql.IDentifyAuto.exception.VehicleNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
@AllArgsConstructor
@Slf4j
public class VehicleServiceImpl implements VehicleService{
    private final VehicleRepository vehicleRepository;
    private final LocationRepository locationRepository;

    @Override
    @Transactional
    public Vehicle registerVehicle(VehicleDto vehicleRequest) {

        Optional<Vehicle> existingVehicle = vehicleRepository.findById(vehicleRequest.getVin());
        if (existingVehicle.isPresent()){
//              Map<String, Object> params = new HashMap<>();
//            params.put("vin", vehicleRequest.getVin());
            throw new VehicleExistsException("Failed to add vehicle. Vehicle with vin" + vehicleRequest.getVin() + "already present.");
        }
        Vehicle vehicle = new Vehicle();
                vehicle.setVin(vehicleRequest.getVin());
                vehicle.setMake(vehicleRequest.getMake());
                vehicle.setYear(vehicleRequest.getYear());
                vehicle.setModel(vehicleRequest.getModel());
                vehicle.setLocation(vehicleRequest.getLocation());

        locationRepository.save(vehicleRequest.getLocation());
        //return getApiResponse(savedVehicle);
        return vehicleRepository.save(vehicle);
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
        return vehicleRepository.findAll();
    }

    @Override
    public List<Vehicle> searchByLocation(String zipCode) {
        if (StringUtils.isEmpty(zipCode) || zipCode.length() != 5) {
            throw new InvalidInputException("Invalid zipcode " + zipCode + " provided.");
        }
        return locationRepository.findByZipCode(zipCode)
                .map(Location::getVehicles)
                .orElse(new ArrayList<>());

    }
}
