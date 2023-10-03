package com.graphql.IDentifyAuto.controller;

import com.graphql.IDentifyAuto.data.dto.VehicleDto;
import com.graphql.IDentifyAuto.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;

@MutationMapping
    ResponseEntity<?> addVehicle(@Argument VehicleDto vehicleRequest){
    return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.registerVehicle(vehicleRequest));
}
@QueryMapping
    ResponseEntity<?> searchByVin(@Argument String vin){
    return ResponseEntity.ok().body(vehicleService.getVehicleByVin(vin));
}

@QueryMapping
    ResponseEntity<?>searchByLocation(@Argument Long zipCode){
    return ResponseEntity.ok().body(vehicleService.searchByLocation(zipCode));
}
@QueryMapping
    ResponseEntity<?>getAllVehicles(){
    return ResponseEntity.ok().body(vehicleService.getAllVehicles());
}

}
