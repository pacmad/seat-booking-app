package com.ashishkotnala29.seatbookingapp.model.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Table(name = "room")
@Getter
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "project_date_time")
	private LocalDateTime projectDateTime;

	@Column(name = "room_title")
	private String roomTitle;

	@Column(name = "duration_time_in_minutes")
	private int durationTimeInMinutes;

	@ManyToOne
	@JoinColumn(name = "floor_id")
	private Floor floor;

	@OneToMany(mappedBy = "room")
	private Set<Row> rows;

	public LocalDateTime getProjectExpirationDateTime() {
		return projectDateTime.minusMinutes(15);
	}

}
