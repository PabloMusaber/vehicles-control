package com.challenge.Vehicles.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.Vehicles.dtos.car.CarCreateDTO;
import com.challenge.Vehicles.dtos.car.CarUpdateDTO;
import com.challenge.Vehicles.dtos.vehicle.VehicleResponseDTO;
import com.challenge.Vehicles.services.vehicle.VehicleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/vehicles/car")
public class CarController {

    private final VehicleService vehicleService;

    public CarController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<VehicleResponseDTO> createCar(
            @RequestBody CarCreateDTO carDTO) {
        VehicleResponseDTO createdVehicle = vehicleService.createVehicle(carDTO);
        return new ResponseEntity<>(createdVehicle, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleResponseDTO> updateCar(
            @PathVariable Long id,
            @Valid @RequestBody CarUpdateDTO carUpdateDTO) {
        carUpdateDTO.setId(id);
        VehicleResponseDTO updatedCar = vehicleService.updateVehicle(carUpdateDTO);
        return ResponseEntity.ok(updatedCar);
    }
}
