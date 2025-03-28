package com.challenge.Vehicles.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.Vehicles.dtos.car.CarCreateDTO;
import com.challenge.Vehicles.dtos.car.CarResponseDTO;
import com.challenge.Vehicles.dtos.car.CarUpdateDTO;
import com.challenge.Vehicles.dtos.vehicle.VehicleResponseDTO;
import com.challenge.Vehicles.services.car.CarService;
import com.challenge.Vehicles.services.vehicle.VehicleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/vehicles/cars")
public class CarController {

    private final VehicleService vehicleService;
    private final CarService carService;

    public CarController(VehicleService vehicleService, CarService carService) {
        this.vehicleService = vehicleService;
        this.carService = carService;
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

    @GetMapping
    public ResponseEntity<List<CarResponseDTO>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

}
