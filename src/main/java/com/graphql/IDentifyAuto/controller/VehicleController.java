package com.graphql.IDentifyAuto.controller;

import com.graphql.IDentifyAuto.data.dto.ApiResponse;
import com.graphql.IDentifyAuto.data.dto.VehicleDto;
import com.graphql.IDentifyAuto.data.model.Vehicle;
import com.graphql.IDentifyAuto.data.repository.VehicleRepository;
import com.graphql.IDentifyAuto.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@AllArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;
    private final VehicleRepository vehicleRepository;

@MutationMapping
    public Vehicle registerVehicle( @Argument VehicleDto vehicleRequest){

    return vehicleService.registerVehicle(vehicleRequest);
}
@QueryMapping
   public Vehicle getVehicleByVin(@Argument String vin){
    return vehicleService.getVehicleByVin(vin);
}

@QueryMapping
    public List<Vehicle> searchByLocation(@Argument String zipCode){
    return vehicleService.searchByLocation(zipCode);
}
@QueryMapping
public List<Vehicle>getAllVehicles(){
    return vehicleService.getAllVehicles();

}
}
