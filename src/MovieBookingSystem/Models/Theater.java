package MovieBookingSystem.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Theater {
	private int id = 0;
	private String name;
	private String location;
	private String mapLink;
	private City city;
	private List<Screen> screens;
	private List<Show> shows;

	public Theater(int id, String name, String location, String mapLink, City city) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.mapLink = mapLink;
		this.city = city;
		this.screens = new ArrayList<>();
		this.shows = new ArrayList<>();
	}

	public List<Show> findShows(Movie movie) {
		List<Show> matchedShows = shows.stream().filter(show -> show.getMovie().getId() == movie.getId())
				.collect(Collectors.toList());
		return matchedShows;
	}

	public List<Screen> getScreens() {
		return screens;
	}

	public void setScreens(List<Screen> screens) {
		this.screens = screens;
	}

	public List<Show> getShows() {
		return shows;
	}

	public void setShows(List<Show> shows) {
		for (Show show : shows) {
			this.shows.add(show);
		}
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getMapLink() {
		return mapLink;
	}

	public void setMapLink(String mapLink) {
		this.mapLink = mapLink;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
