package com.ashishkotnala29.seatbookingapp.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashishkotnala29.seatbookingapp.dao.BookingRepository;
import com.ashishkotnala29.seatbookingapp.model.entity.Booking;

/**
 * Service layer that allows saving reservations.
 */
@Service
public class BookingService {

	private final BookingRepository bookingRepository;

	@Autowired
	public BookingService(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}

	@Transactional
	public Booking saveBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

}
