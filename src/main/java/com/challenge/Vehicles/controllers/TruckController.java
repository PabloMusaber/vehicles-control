package com.challenge.Vehicles.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.Vehicles.dtos.truck.TruckCreateDTO;
import com.challenge.Vehicles.dtos.truck.TruckUpdateDTO;
import com.challenge.Vehicles.dtos.vehicle.VehicleResponseDTO;
import com.challenge.Vehicles.services.vehicle.VehicleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/vehicles/truck")
public class TruckController {

    private final VehicleService vehicleService;

    public TruckController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<VehicleResponseDTO> createTruck(
            @RequestBody TruckCreateDTO truckDTO) {
        VehicleResponseDTO createdVehicle = vehicleService.createVehicle(truckDTO);
        return new ResponseEntity<>(createdVehicle, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleResponseDTO> updateTruck(
            @PathVariable Long id,
            @Valid @RequestBody TruckUpdateDTO truckUpdateDTO) {
        truckUpdateDTO.setId(id);
        VehicleResponseDTO updatedTruck = vehicleService.updateVehicle(truckUpdateDTO);
        return ResponseEntity.ok(updatedTruck);
    }

}
