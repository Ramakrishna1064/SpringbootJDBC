package com.example.demo.dto;

import java.time.Year;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "film")
public class FilmDTO {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int film_id;
	private String title;
	private String description;
	private Year release_year;
	private int rental_duration;
	
	public int getFilm_id() {
		return film_id;
	}
	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Year getRelease_year() {
		return release_year;
	}
	public void setRelease_year(Year release_year) {
		this.release_year = release_year;
	}
	public int getRental_duration() {
		return rental_duration;
	}
	public void setRental_duration(int rental_duration) {
		this.rental_duration = rental_duration;
	}
}
