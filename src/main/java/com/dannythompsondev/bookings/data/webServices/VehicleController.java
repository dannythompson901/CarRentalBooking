package com.dannythompsondev.bookings.data.webServices;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dannythompsondev.bookings.data.entity.Vehicle;
import com.dannythompsondev.bookings.data.repository.VehicleRepository;

@RestController
public class VehicleController {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@RequestMapping(value = "/vehicles", method = RequestMethod.GET)
	List<Vehicle> findAll(@RequestParam(required = false) String vehicleModel){
		List<Vehicle> vehicleList = new ArrayList();
		if(vehicleModel == null) {
			Iterable<Vehicle> iterableVehicle = this.vehicleRepository.findAll();
			iterableVehicle.forEach(vehicle -> {
				vehicleList.add(vehicle);
			});
		} else {
			Vehicle vehicle = this.vehicleRepository.findByVehicleModel(vehicleModel);
			if(vehicle != null) {
				vehicleList.add(vehicle);
			}
		}
		
		return vehicleList;
	}
}
