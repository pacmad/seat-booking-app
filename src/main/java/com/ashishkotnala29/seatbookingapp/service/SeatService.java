package com.ashishkotnala29.seatbookingapp.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashishkotnala29.seatbookingapp.dao.SeatRepository;
import com.ashishkotnala29.seatbookingapp.model.entity.Booking;
import com.ashishkotnala29.seatbookingapp.model.entity.Seat;

/**
 * Service layer that allows booking seats.
 */
@Service
public class SeatService {

	private final SeatRepository seatRepository;

	@Autowired
	public SeatService(SeatRepository seatRepository) {
		this.seatRepository = seatRepository;
	}

	@Transactional
	public Seat getSeatById(Long id) {
		return seatRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("The seat ID is invalid."));
	}

	@Transactional
	public boolean checkWhetherSeatIsAvailable(Seat seat) {
		if (seat.isReserved()) {
			throw new IllegalArgumentException("Seat already reserved.");
		} else {
			return true;
		}
	}

	@Transactional
	public Seat reserveSeat(Booking booking, Seat seat) {
		seat.setIsReservedToTrue();
		seat.setBooking(booking);
		return seat;
	}

}
