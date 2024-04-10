package MovieBookingSystem;

import java.util.ArrayList;
import java.util.List;

import MovieBookingSystem.Controller.TheaterController;
import MovieBookingSystem.Models.City;
import MovieBookingSystem.Models.Movie;
import MovieBookingSystem.Models.Seat;
import MovieBookingSystem.Models.Show;
import MovieBookingSystem.Models.Theater;

public class BookShow {
	private Movie movie;
	private City city;

	public BookShow(City city, Movie movie) {
		this.movie = movie;
		this.city = city;
	}

	public Booking createBooking(int seatCount) {
		TheaterController theaterApi = TheaterController.getInstance(null);
		List<Theater> theaters = theaterApi.getAllTheatersBy(city, movie);

		Theater selectedTheater = null;
		Show selectedShow = null;
		List<Seat> freeSeats = new ArrayList<>();

		for (Theater theater : theaters) {
			if (selectedShow != null && selectedTheater != null)
				break;
			for (Show show : theater.findShows(movie)) {
				freeSeats = show.getFreeSeats(seatCount);
				if (freeSeats.size() == seatCount) {
					selectedShow = show;
					selectedTheater = theater;
					break;
				}
			}
		}
		if (selectedShow != null) {
			for (Seat seat : freeSeats) {
				selectedShow.addBookedSeat(seat);
			}
			double id = Math.random() * 1e8; // generates 8 digit random ids.
			Booking booking = new Booking((int) id, selectedTheater, selectedShow, freeSeats);
			return booking;
		}
		return new Booking();
	}
}
