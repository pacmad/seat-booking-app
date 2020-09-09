package com.ashishkotnala29.seatbookingapp.model.entity;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "booking")
@NoArgsConstructor
@Getter
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@CreationTimestamp
	@Column(name = "creation_date_time")
	private LocalDateTime creationDateTime;

	@Column(name = "booking_code")
	private UUID bookingCode;

	@OneToMany(mappedBy = "booking")
	private Set<Seat> seats;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id", referencedColumnName = "id")
	private Employee employee;

	public Booking(Set<Seat> seats, Employee employee) {
		this.bookingCode = UUID.randomUUID();
		this.seats = seats;
		this.employee = employee;
	}

}
