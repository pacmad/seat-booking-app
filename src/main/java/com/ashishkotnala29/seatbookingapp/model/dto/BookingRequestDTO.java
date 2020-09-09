package com.ashishkotnala29.seatbookingapp.model.dto;

import java.util.Set;

import javax.validation.constraints.NotNull;

import com.ashishkotnala29.seatbookingapp.model.entity.Employee;
import com.ashishkotnala29.seatbookingapp.model.entity.Room;
import com.ashishkotnala29.seatbookingapp.model.entity.Seat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequestDTO {

	@NotNull
	private Room room;

	@NotNull
	private Set<Seat> seatReservations;

	@NotNull
	private Employee employee;

}
