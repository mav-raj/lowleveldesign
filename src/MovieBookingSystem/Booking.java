package MovieBookingSystem;

import java.util.List;

import MovieBookingSystem.Models.Screen;
import MovieBookingSystem.Models.Seat;
import MovieBookingSystem.Models.Show;
import MovieBookingSystem.Models.Theater;

public class Booking {

	private int id;
	private Theater theater;
	private Show show;
	private List<Seat> seats;

	public Booking() {
	}

	public Booking(int id, Theater theater, Show show, List<Seat> bookedSeats) {
		this.id = id;
		this.theater = theater;
		this.show = show;
		this.seats = bookedSeats;
	}

	public void printShowDetails() {
		if (show != null) {
			System.out.println("------");
			System.out.println("Booking Id: " + id);
			System.out.println("Theater: " + theater.getName());
			System.out.println("Movie: " + this.show.getMovie().getName());
			System.out.println("Show Time: " + this.show.getTime());
			System.out.println("Screen : " + this.show.getScreen().getId());
			System.out.println(
					"Booked Seats: "
							+ seats.stream().reduce("", (partialString, seat) -> partialString + seat.toString(), String::concat));
			System.out.println("Duration: " + this.show.getMovie().getDuration());
			System.out.println("Total Seats: " + this.seats.size());
			System.out.println("------");
			System.out.println("");
		} else {
			System.out.println("------");
			System.out.println("Booking Failed");
			System.out.println("------");
			System.out.println("");
		}
	}

	public Screen getScreen() {
		return this.show.getScreen();
	}

	public List<Seat> getBookedSeats() {
		return this.seats;
	}

	public int getId() {
		return id;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

}
