package com.challenge.Vehicles.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.Vehicles.dtos.maintenance.MaintenanceCreateDTO;
import com.challenge.Vehicles.dtos.maintenance.MaintenanceResponseDTO;
import com.challenge.Vehicles.exceptions.VehicleNotValidException;
import com.challenge.Vehicles.services.maintenance.MaintenanceService;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/vehicles/{vehicleId}/maintenances")
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @Operation(summary = "Registra un mantenimiento para un vehículo")
    @PostMapping
    public ResponseEntity<MaintenanceResponseDTO> addMaintenance(
            @PathVariable Long vehicleId,
            @RequestBody MaintenanceCreateDTO maintenanceCreateDTO) {

        if (vehicleId != null) {
            maintenanceCreateDTO.setVehicleId(vehicleId);
            MaintenanceResponseDTO createdMaintenance = maintenanceService.addMaintenance(maintenanceCreateDTO);
            return ResponseEntity.ok(createdMaintenance);
        }
        throw new VehicleNotValidException();

    }

    @Operation(summary = "Obtiene todos los mantenimientos de un vehículo")
    @GetMapping
    public ResponseEntity<List<MaintenanceResponseDTO>> getMaintenancesByVehicle(@PathVariable Long vehicleId) {
        List<MaintenanceResponseDTO> maintenances = maintenanceService.getMaintenancesByVehicle(vehicleId);
        return ResponseEntity.ok(maintenances);
    }

}
