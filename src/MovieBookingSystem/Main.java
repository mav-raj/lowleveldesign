package MovieBookingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import MovieBookingSystem.Controller.CityController;
import MovieBookingSystem.Controller.MovieController;
import MovieBookingSystem.Controller.TheaterController;
import MovieBookingSystem.Enums.SeatType;
import MovieBookingSystem.Models.City;
import MovieBookingSystem.Models.Movie;
import MovieBookingSystem.Models.Screen;
import MovieBookingSystem.Models.Seat;
import MovieBookingSystem.Models.Show;
import MovieBookingSystem.Models.Theater;

public class Main {
	public static final int ROWS_PER_SCREEN = 2;
	public static final int SEAT_PER_ROW = 5;
	public static final String[] TIMINGS_EVEN = new String[] { "12:00", "16:00", "20:00", "00:00" };
	public static final String[] TIMINGS_ODD = new String[] { "13:00", "17:00", "21:00", "01:00" };

	public static void main(String[] args) {
		/* Data creation starts */
		CityController cityApi = getCityController();
		MovieController movieApi = getMovieController();
		getTheaterController(4, cityApi.getAll().get(0));
		getTheaterController(4, cityApi.getAll().get(1));
		getTheaterController(4, cityApi.getAll().get(2));
		/* Data creation ends */

		BookShow bookShow = new BookShow(cityApi.getCityByName("Bangalore"), movieApi.getMovieByName("The Godfather"));
		BookShow bookShow1 = new BookShow(cityApi.getCityByName("Mumbai"),
				movieApi.getMovieByName("The Shawshank Redemption"));

		Booking booking = bookShow.createBooking(10);
		Booking booking1 = bookShow.createBooking(4);
		Booking booking2 = bookShow.createBooking(4);
		Booking booking5 = bookShow.createBooking(1);
		Booking booking4 = bookShow.createBooking(11);
		Booking booking3 = bookShow.createBooking(10);
		booking.printShowDetails();
		booking1.printShowDetails();
		booking2.printShowDetails();
		booking5.printShowDetails();
		booking3.printShowDetails();
		booking4.printShowDetails();
		Booking b1 = bookShow1.createBooking(6);
		Booking b2 = bookShow1.createBooking(10);
		Booking b3 = bookShow1.createBooking(9);
		b1.printShowDetails();
		b2.printShowDetails();
		b3.printShowDetails();
	}

	public static CityController getCityController() {
		List<City> cities = new ArrayList<>();
		cities.add(new City(0, "Bangalore"));
		cities.add(new City(1, "New Delhi"));
		cities.add(new City(2, "Mumbai"));
		CityController cityController = CityController.getInstance(cities);
		return cityController;
	}

	public static MovieController getMovieController() {
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie(0, "The Godfather", 175));
		movies.add(new Movie(1, "The Shawshank Redemption", 142));
		movies.add(new Movie(2, "Avatar", 178));
		movies.add(new Movie(3, "Animal", 201));
		MovieController movieController = MovieController.getInstance(movies);
		return movieController;
	}

	public static TheaterController getTheaterController(int count, City city) {
		TheaterController theaterController = TheaterController.getInstance(null);
		for (int i = 0; i < count; i++) {
			Theater theater = new Theater(i, city.getName() + i, city.getName(), "", city);
			List<Screen> screens = new ArrayList<>();
			screens.add(screenCreator(0));
			screens.add(screenCreator(1));
			theater.setScreens(screens);
			for (Screen screen : screens) {
				theater.setShows(showCreator(screen));
			}
			theaterController.setItem(theater);
		}
		return theaterController;
	}

	public static List<Show> showCreator(Screen screen) {
		List<Show> shows = new ArrayList<>();
		List<Movie> movies = getMovieController().getAll();
		int i = 0;
		if (screen.getId() % 2 == 0) {
			for (Movie movie : movies) {
				int evenMod = i % TIMINGS_EVEN.length;
				shows.add(new Show(i, movie, screen, TIMINGS_EVEN[evenMod]));
				i++;
			}
		} else {
			for (Movie movie : movies) {
				int oddMod = i % TIMINGS_ODD.length;
				shows.add(new Show(i, movie, screen, TIMINGS_ODD[oddMod]));
				i++;
			}
		}
		return shows;
	}

	public static Screen screenCreator(int id) {
		HashMap<Integer, List<Seat>> rows = new HashMap<>();
		for (int i = 0; i < ROWS_PER_SCREEN; i++) {
			if (i <= 5)
				rows.put(i, seatRowsCreator(SEAT_PER_ROW, i, SeatType.SILVER));
			else if (i > 5 && i <= 8)
				rows.put(i, seatRowsCreator(SEAT_PER_ROW, i, SeatType.GOLD));
			else if (i > 8)
				rows.put(i, seatRowsCreator(SEAT_PER_ROW, i, SeatType.PLATINUM));
		}
		Screen screen = new Screen(id, rows);
		return screen;
	}

	public static List<Seat> seatRowsCreator(int size, int row, SeatType seatType) {
		List<Seat> rows = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			rows.add(new Seat(row, i, seatType));
		}
		return rows;
	}
}
