package com.challenge.Vehicles.services.vehicle;

import java.util.List;

import com.challenge.Vehicles.dtos.vehicle.VehicleBaseDTO;
import com.challenge.Vehicles.dtos.vehicle.VehicleResponseDTO;
import com.challenge.Vehicles.dtos.vehicle.VehicleUpdateDTO;

public interface VehicleService {
    VehicleResponseDTO createVehicle(VehicleBaseDTO VehicleBaseDTO);

    VehicleResponseDTO updateVehicle(VehicleUpdateDTO vehicleUpdateDTO);

    VehicleResponseDTO getVehicleById(Long id);

    List<VehicleResponseDTO> getAllVehicles();

    boolean deleteVehicle(Long id);

    VehicleResponseDTO getVehicleByLicensePlate(String licensePlate);
}