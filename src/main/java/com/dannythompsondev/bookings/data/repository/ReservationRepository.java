package com.dannythompsondev.bookings.data.repository;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dannythompsondev.bookings.data.entity.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

		Reservation findByReservationDate(Date reservationDate);
}
