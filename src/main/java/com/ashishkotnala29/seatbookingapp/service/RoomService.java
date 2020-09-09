package com.ashishkotnala29.seatbookingapp.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashishkotnala29.seatbookingapp.dao.RoomRepository;
import com.ashishkotnala29.seatbookingapp.model.entity.Room;

/**
 * Service layer that allows finding information about screenings.
 */
@Service
public class RoomService {

	private final RoomRepository roomRepository;

	@Autowired
	public RoomService(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}

	@Transactional
	public Room getRoomById(Long id) {
		return roomRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("The room ID is invalid."));
	}

	@Transactional
	public boolean checkWhetherReservationIsPossible(Room room) {
		if (LocalDateTime.now().isAfter(room.getProjectExpirationDateTime())) {
			throw new IllegalArgumentException(
					"Reservation is not possible. Seats can be booked at the latest 15 minutes before the room project begins.");
		} else {
			return true;
		}
	}

}
