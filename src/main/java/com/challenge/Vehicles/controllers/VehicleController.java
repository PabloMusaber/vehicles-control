package com.challenge.Vehicles.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.Vehicles.dtos.vehicle.CarCreateDTO;
import com.challenge.Vehicles.dtos.vehicle.TruckCreateDTO;
import com.challenge.Vehicles.dtos.vehicle.VehicleBaseDTO;
import com.challenge.Vehicles.dtos.vehicle.VehicleResponseDTO;
import com.challenge.Vehicles.dtos.vehicle.VehicleUpdateDTO;
import org.springframework.web.bind.annotation.RequestBody;
import com.challenge.Vehicles.services.vehicle.VehicleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<VehicleResponseDTO> createVehicle(@RequestBody VehicleBaseDTO vehicleBaseDto) {
        VehicleResponseDTO createdVehicle = vehicleService.createVehicle(vehicleBaseDto);
        return new ResponseEntity<>(createdVehicle, HttpStatus.CREATED);
    }

    @PostMapping("/car")
    public ResponseEntity<VehicleResponseDTO> createCar(
            @RequestBody CarCreateDTO carDTO) {
        VehicleResponseDTO createdVehicle = vehicleService.createVehicle(carDTO);
        return new ResponseEntity<>(createdVehicle, HttpStatus.CREATED);
    }

    @PostMapping("/truck")
    public ResponseEntity<VehicleResponseDTO> createTruck(
            @RequestBody TruckCreateDTO truckDTO) {
        VehicleResponseDTO createdVehicle = vehicleService.createVehicle(truckDTO);
        return new ResponseEntity<>(createdVehicle, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleResponseDTO> updateVehicle(
            @PathVariable Long id,
            @Valid @RequestBody VehicleUpdateDTO vehicleUpdateDTO) {
        vehicleUpdateDTO.setId(id);
        VehicleResponseDTO updatedVehicle = vehicleService.updateVehicle(vehicleUpdateDTO);
        return ResponseEntity.ok(updatedVehicle);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponseDTO> getVehicleById(@PathVariable Long id) {
        VehicleResponseDTO vehicle = vehicleService.getVehicleById(id);
        return ResponseEntity.ok(vehicle);
    }

    @GetMapping
    public ResponseEntity<List<VehicleResponseDTO>> getAllVehicles() {
        List<VehicleResponseDTO> vehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok(vehicles);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/licencePlate/{licencePlate}")
    public ResponseEntity<VehicleResponseDTO> getVehiclesByLicencePlate(@PathVariable String licencePlate) {
        VehicleResponseDTO vehicles = vehicleService.getVehiclesByLicensePlate(licencePlate);
        return ResponseEntity.ok(vehicles);
    }
}