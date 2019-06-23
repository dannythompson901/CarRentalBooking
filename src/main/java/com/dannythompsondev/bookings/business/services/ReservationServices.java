package com.dannythompsondev.bookings.business.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dannythompsondev.bookings.business.domains.VehicleReservation;
import com.dannythompsondev.bookings.data.entity.Client;
import com.dannythompsondev.bookings.data.entity.Reservation;
import com.dannythompsondev.bookings.data.entity.Vehicle;
import com.dannythompsondev.bookings.data.repository.ClientRepository;
import com.dannythompsondev.bookings.data.repository.ReservationRepository;
import com.dannythompsondev.bookings.data.repository.VehicleRepository;

@Service
public class ReservationServices {
	private VehicleRepository vehicleRepository;
	private ClientRepository clientRepository;
	private ReservationRepository reservationRepository;

	@Autowired
	public ReservationServices(VehicleRepository vehicleRepository, ClientRepository clientRepository,
			ReservationRepository reservationRepository) {
		super();
		this.vehicleRepository = vehicleRepository;
		this.clientRepository = clientRepository;
		this.reservationRepository = reservationRepository;
	}

	public List<VehicleReservation> getVehicleReservationsForDate(Date date) {
		Iterable<Vehicle> vehicles = this.vehicleRepository.findAll();
		Map<Long, VehicleReservation> vehicleReservationsMap = new HashMap<>();
		vehicles.forEach(vehicle -> {
			VehicleReservation vehicleReservation = new VehicleReservation();
			vehicleReservation.setVehicleId(vehicle.getId());
			vehicleReservation.setVehicleModel(vehicle.getVehicleModel());
			vehicleReservation.setVehicleType(vehicle.getVehicleType());

			vehicleReservationsMap.put(vehicle.getId(), vehicleReservation);
		});
		Iterable<Reservation> reservations = (Iterable<Reservation>) this.reservationRepository
				.findByReservationDate(date);
		if (reservations != null) {
			reservations.forEach(reservation -> {
				Optional<Client> client = this.clientRepository.findById(reservation.getClientId());
				if (client != null) {
					VehicleReservation vehicleReservation = vehicleReservationsMap.get(reservation.getId());
					vehicleReservation.setDate(date);
					vehicleReservation.setFirstName(client.get().getFirstName());
					vehicleReservation.setLastName(client.get().getLastName());
					vehicleReservation.setClientId(client.get().getId());
				}
			});
		}

		List<VehicleReservation> vehicleReservations = new ArrayList<>();
		for (Long vehicleId : vehicleReservationsMap.keySet()) {
			vehicleReservations.add(vehicleReservationsMap.get(vehicleId));
		}

		return vehicleReservations;
	}

}
