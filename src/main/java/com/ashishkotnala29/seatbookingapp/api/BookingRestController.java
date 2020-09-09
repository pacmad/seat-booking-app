package com.ashishkotnala29.seatbookingapp.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashishkotnala29.seatbookingapp.facade.BookingFacade;
import com.ashishkotnala29.seatbookingapp.model.dto.BookingRequestDTO;
import com.ashishkotnala29.seatbookingapp.model.dto.BookingResultDTO;

@RestController
@RequestMapping("${spring.data.rest.base-path}/employeeBooking")
public class BookingRestController {

	private final BookingFacade bookingFacade;

	@Autowired
	public BookingRestController(BookingFacade bookingFacade) {
		this.bookingFacade = bookingFacade;
	}

	@PostMapping
	@ResponseBody
	public BookingResultDTO addEmployeeBooking(@Valid @RequestBody BookingRequestDTO bookingRequestDTO) {
		return bookingFacade.addEmployeeBooking(bookingRequestDTO);
	}

}
