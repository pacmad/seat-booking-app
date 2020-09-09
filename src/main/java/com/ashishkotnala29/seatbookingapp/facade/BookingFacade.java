package com.ashishkotnala29.seatbookingapp.facade;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashishkotnala29.seatbookingapp.model.dto.BookingRequestDTO;
import com.ashishkotnala29.seatbookingapp.model.dto.BookingResultDTO;
import com.ashishkotnala29.seatbookingapp.model.entity.Booking;
import com.ashishkotnala29.seatbookingapp.model.entity.Employee;
import com.ashishkotnala29.seatbookingapp.model.entity.Room;
import com.ashishkotnala29.seatbookingapp.model.entity.Seat;
import com.ashishkotnala29.seatbookingapp.service.BookingService;
import com.ashishkotnala29.seatbookingapp.service.EmployeeService;
import com.ashishkotnala29.seatbookingapp.service.RoomService;
import com.ashishkotnala29.seatbookingapp.service.SeatService;
import com.ashishkotnala29.seatbookingapp.util.SeatReservationUtils;

/**
 * The facade that connects particular services and implements the project's assumptions.
 */
@Component
public class BookingFacade {

	private final BookingService bookingService;
	private final EmployeeService employeeService;
	private final RoomService roomService;
	private final SeatService seatService;

	@Autowired
	public BookingFacade(BookingService bookingService, EmployeeService employeeService,
			RoomService roomService, SeatService seatService) {
		this.bookingService = bookingService;
		this.employeeService = employeeService;
		this.roomService = roomService;
		this.seatService = seatService;
	}

	public BookingResultDTO addEmployeeBooking(BookingRequestDTO bookingRequestDTO) {

		Long roomIdFromBookingRequest = bookingRequestDTO.getRoom().getId();
		Room room = roomService.getRoomById(roomIdFromBookingRequest);
		roomService.checkWhetherReservationIsPossible(room);

		Set<Seat> seatReservationsFromBookingRequest = bookingRequestDTO.getSeatReservations();
		SeatReservationUtils.checkWhetherSeatsAreNextToEachOther(seatReservationsFromBookingRequest);

		Set<Seat> seatsToBooking = new HashSet<>();
		for (Seat seatReservation : seatReservationsFromBookingRequest) {
			Seat seat = seatService.getSeatById(seatReservation.getId());
			seatService.checkWhetherSeatIsAvailable(seat);
			seatsToBooking.add(seat);
		}

		Employee employeeFromBookingRequest = bookingRequestDTO.getEmployee();
		employeeService.saveEmployee(employeeFromBookingRequest);
		Booking employeeBooking = new Booking(seatsToBooking, employeeFromBookingRequest);
		bookingService.saveBooking(employeeBooking);

		for (Seat seat : seatsToBooking) {
			seatService.reserveSeat(employeeBooking, seat);
		}

		return new BookingResultDTO(room.getProjectExpirationDateTime());
	}

}
