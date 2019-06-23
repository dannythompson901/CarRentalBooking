package com.dannythompsondev.bookings.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dannythompsondev.bookings.data.entity.Vehicle;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long>{

	Vehicle findByVehicleModel(String vehicleModel);
}
