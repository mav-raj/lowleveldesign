package MovieBookingSystem.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import MovieBookingSystem.Models.City;
import MovieBookingSystem.Models.Movie;
import MovieBookingSystem.Models.Theater;

public class TheaterController extends Controller<Theater> {
	private static TheaterController instance;
	private List<Theater> theaters;

	private TheaterController() {
		this.theaters = new ArrayList<>();
	}

	private TheaterController(List<Theater> theaters) {
		this.theaters = theaters;
	}

	public static TheaterController getInstance(List<Theater> theaters) {
		if (instance == null) {
			synchronized (TheaterController.class) {
				if (instance == null) {
					List<Theater> tList;
					if (theaters != null) {
						tList = theaters;
					} else
						tList = new ArrayList<>();
					instance = new TheaterController(tList);
					return instance;
				} else
					return instance;
			}
		} else
			return instance;
	}

	public List<Theater> getAllTheatersBy(City city, Movie movie) {
		List<Theater> matchedTheaters = theaters.stream()
				.filter(theater -> theater.getCity().getId() == city.getId())
				.collect(Collectors.toList()).stream()
				.filter(
						theater -> theater.getShows().stream().filter(show -> show.getMovie().getId() == movie.getId()).count() > 0)
				.collect(Collectors.toList());

		return matchedTheaters;
	}

	@Override
	public List<Theater> getAll() {
		return this.theaters;
	}

	@Override
	public Theater setItem(Theater t) {
		this.theaters.add(t);
		return t;
	}

	@Override
	public Theater updateItem(Theater t) {
		int id = t.getId();
		Theater matched = theaters.stream().filter(theater -> theater.getId() == id).findFirst().orElse(null);
		if (matched != null) {
			matched.setCity(t.getCity());
			matched.setLocation(t.getLocation());
			matched.setMapLink(t.getMapLink());
			matched.setName(t.getName());
			matched.setShows(t.getShows());
		}

		return t;
	}

}
