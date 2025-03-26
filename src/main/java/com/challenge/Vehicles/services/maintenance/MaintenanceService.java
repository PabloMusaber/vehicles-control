package com.challenge.Vehicles.services.maintenance;

import java.util.List;

import com.challenge.Vehicles.dtos.maintenance.MaintenanceCreateDTO;
import com.challenge.Vehicles.dtos.maintenance.MaintenanceResponseDTO;

public interface MaintenanceService {
    MaintenanceResponseDTO addMaintenance(MaintenanceCreateDTO maintenanceCreateDto);

    List<MaintenanceResponseDTO> getMaintenancesByVehicle(Long vehicleId);
}
