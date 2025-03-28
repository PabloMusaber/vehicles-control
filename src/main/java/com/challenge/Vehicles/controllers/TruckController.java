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

import com.challenge.Vehicles.dtos.truck.TruckResponseDTO;
import com.challenge.Vehicles.dtos.truck.TruckCreateDTO;
import com.challenge.Vehicles.dtos.truck.TruckUpdateDTO;
import com.challenge.Vehicles.dtos.vehicle.VehicleResponseDTO;
import com.challenge.Vehicles.services.truck.TruckService;
import com.challenge.Vehicles.services.vehicle.VehicleService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/vehicles/trucks")
public class TruckController {

    private final VehicleService vehicleService;
    private final TruckService truckService;

    public TruckController(VehicleService vehicleService, TruckService truckService) {
        this.vehicleService = vehicleService;
        this.truckService = truckService;
    }

    @Operation(summary = "Crea un camión")
    @PostMapping
    public ResponseEntity<VehicleResponseDTO> createTruck(
            @RequestBody TruckCreateDTO truckDTO) {
        VehicleResponseDTO createdVehicle = vehicleService.createVehicle(truckDTO);
        return new ResponseEntity<>(createdVehicle, HttpStatus.CREATED);
    }

    @Operation(summary = "Actualiza un camión")
    @PutMapping("/{id}")
    public ResponseEntity<VehicleResponseDTO> updateTruck(
            @PathVariable Long id,
            @Valid @RequestBody TruckUpdateDTO truckUpdateDTO) {
        truckUpdateDTO.setId(id);
        VehicleResponseDTO updatedTruck = vehicleService.updateVehicle(truckUpdateDTO);
        return ResponseEntity.ok(updatedTruck);
    }

    @Operation(summary = "Obtiene todos los camiones cargados en el sistema")
    @GetMapping
    public ResponseEntity<List<TruckResponseDTO>> getAllTrucks() {
        return ResponseEntity.ok(truckService.getAllTrucks());
    }

}
