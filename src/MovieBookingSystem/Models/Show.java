package MovieBookingSystem.Models;

import java.util.ArrayList;
import java.util.List;

public class Show {
	private int id;
	private Movie movie;
	private Screen screen;
	private String time;
	private List<Seat> bookedSeats;

	public Show(int id, Movie movie, Screen screen, String time) {
		this.id = id;
		this.movie = movie;
		this.screen = screen;
		this.time = time;
		this.bookedSeats = new ArrayList<>();
	}

	public List<Seat> getFreeSeats(int count) {
		List<Seat> tempSeats = new ArrayList<>();
		for (int row : screen.getRows().keySet()) {
			for (Seat seat : screen.getRows().get(row)) {
				if (!bookedSeats.contains(seat)) {
					tempSeats.add(seat);
					if (tempSeats.size() == count)
						return tempSeats;
				}
			}
		}
		return tempSeats;
	}

	public List<Seat> getBookedSeats() {
		return bookedSeats;
	}

	public void addBookedSeat(Seat seat) {
		this.bookedSeats.add(seat);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
