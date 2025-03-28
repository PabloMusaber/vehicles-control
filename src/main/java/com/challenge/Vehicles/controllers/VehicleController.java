package com.challenge.Vehicles.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.Vehicles.dtos.vehicle.VehicleResponseDTO;
import com.challenge.Vehicles.services.vehicle.VehicleService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Operation(summary = "Obtiene un vehículo a partir de su id")
    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponseDTO> getVehicleById(@PathVariable Long id) {
        VehicleResponseDTO vehicle = vehicleService.getVehicleById(id);
        return ResponseEntity.ok(vehicle);
    }

    @Operation(summary = "Obtiene todos los vehículos cargados en el sistema")
    @GetMapping
    public ResponseEntity<List<VehicleResponseDTO>> getAllVehicles() {
        List<VehicleResponseDTO> vehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok(vehicles);
    }

    @Operation(summary = "Elimina un vehículo a partir de su id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Obtiene un vehículo a partir de su patente")
    @GetMapping("/licencePlate/{licencePlate}")
    public ResponseEntity<VehicleResponseDTO> getVehiclesByLicencePlate(@PathVariable String licencePlate) {
        VehicleResponseDTO vehicles = vehicleService.getVehicleByLicensePlate(licencePlate);
        return ResponseEntity.ok(vehicles);
    }
}