package com.challenge.Vehicles.services.vehicle;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.challenge.Vehicles.dtos.car.CarCreateDTO;
import com.challenge.Vehicles.dtos.car.CarResponseDTO;
import com.challenge.Vehicles.dtos.car.CarUpdateDTO;
import com.challenge.Vehicles.dtos.truck.TruckCreateDTO;
import com.challenge.Vehicles.dtos.truck.TruckResponseDTO;
import com.challenge.Vehicles.dtos.truck.TruckUpdateDTO;
import com.challenge.Vehicles.dtos.vehicle.VehicleBaseDTO;
import com.challenge.Vehicles.dtos.vehicle.VehicleResponseDTO;
import com.challenge.Vehicles.dtos.vehicle.VehicleUpdateDTO;
import com.challenge.Vehicles.entities.Car;
import com.challenge.Vehicles.entities.Truck;
import com.challenge.Vehicles.entities.Vehicle;
import com.challenge.Vehicles.exceptions.VehicleNotFoundException;
import com.challenge.Vehicles.exceptions.VehicleNotValidException;
import com.challenge.Vehicles.repositories.VehicleRepository;

import jakarta.transaction.Transactional;

@Service
public class VehicleServiceImpl implements VehicleService {

    private static final Logger log = LoggerFactory.getLogger(VehicleServiceImpl.class);
    private final VehicleRepository vehicleRepository;
    private final ModelMapper modelMapper;

    public VehicleServiceImpl(VehicleRepository vehicleRepository, ModelMapper modelMapper) {
        this.vehicleRepository = vehicleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public VehicleResponseDTO createVehicle(VehicleBaseDTO vehicleBaseDTO) {
        Vehicle vehicle;

        if (vehicleBaseDTO instanceof CarCreateDTO carDTO) {
            vehicle = modelMapper.map(carDTO, Car.class);
        } else if (vehicleBaseDTO instanceof TruckCreateDTO truckDTO) {
            vehicle = modelMapper.map(truckDTO, Truck.class);
        } else {
            throw new VehicleNotValidException();
        }

        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        log.info("Vehicle created with license plate: " + savedVehicle.getLicensePlate());

        return mapToResponseDTO(savedVehicle);
    }

    @Override
    @Transactional
    public VehicleResponseDTO updateVehicle(VehicleUpdateDTO vehicleUpdateDTO) {
        Vehicle existingVehicle = vehicleRepository.findById(vehicleUpdateDTO.getId())
                .orElseThrow(VehicleNotFoundException::new);

        // Polymorphic update based on vehicle type
        if (existingVehicle instanceof Car && vehicleUpdateDTO instanceof CarUpdateDTO carUpdateDTO) {
            modelMapper.map(carUpdateDTO, existingVehicle);
        } else if (existingVehicle instanceof Truck && vehicleUpdateDTO instanceof TruckUpdateDTO truckUpdateDTO) {
            modelMapper.map(truckUpdateDTO, existingVehicle);
        } else {
            throw new VehicleNotValidException();
        }

        Vehicle updatedVehicle = vehicleRepository.save(existingVehicle);
        log.info("Vehicle with license plate " + updatedVehicle.getLicensePlate() + " updated.");

        return mapToResponseDTO(updatedVehicle);
    }

    @Override
    public VehicleResponseDTO getVehicleById(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Vehicle not found by id: " + id);
                    return new VehicleNotFoundException();
                });

        return mapToResponseDTO(vehicle);
    }

    @Override
    public List<VehicleResponseDTO> getAllVehicles() {
        return vehicleRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean deleteVehicle(Long id) {
        if (vehicleRepository.existsById(id)) {
            vehicleRepository.deleteById(id);
            return true;
        }
        log.error("Vehicle not found in deleteVehicle method.");
        throw new VehicleNotFoundException();
    }

    @Override
    public VehicleResponseDTO getVehicleByLicensePlate(String licensePlate) {
        Vehicle vehicle = vehicleRepository.findByLicensePlate(licensePlate);

        if (vehicle == null) {
            log.error("Vehicle not found by license plate " + licensePlate);
            throw new VehicleNotFoundException();
        }

        return mapToResponseDTO(vehicle);
    }

    private VehicleResponseDTO mapToResponseDTO(Vehicle vehicle) {
        if (vehicle instanceof Car) {
            return modelMapper.map(vehicle, CarResponseDTO.class);
        } else if (vehicle instanceof Truck) {
            return modelMapper.map(vehicle, TruckResponseDTO.class);
        }
        return modelMapper.map(vehicle, VehicleResponseDTO.class);
    }
}