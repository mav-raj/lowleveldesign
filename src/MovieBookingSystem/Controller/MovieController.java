package MovieBookingSystem.Controller;

import java.util.ArrayList;
import java.util.List;

import MovieBookingSystem.Models.Movie;

public class MovieController extends Controller<Movie> {
	private static MovieController instance;
	private List<Movie> movies;

	private MovieController() {
		this.movies = new ArrayList<>();
	}

	private MovieController(List<Movie> movies) {
		this.movies = movies;
	}

	public static MovieController getInstance(List<Movie> movies) {
		if (instance == null) {
			synchronized (MovieController.class) {
				if (instance == null) {
					List<Movie> mList;
					if (movies != null) {
						mList = movies;
					} else
						mList = new ArrayList<>();
					instance = new MovieController(mList);
					return instance;
				} else
					return instance;
			}
		} else
			return instance;
	}

	public Movie getMovieByName(String name) {
		return this.movies.stream().filter(movie -> movie.getName().equals(name)).findFirst().orElse(null);
	}

	@Override
	public List<Movie> getAll() {
		return this.movies;
	}

	@Override
	public Movie setItem(Movie t) {
		this.movies.add(t);
		return t;
	}

	@Override
	public Movie updateItem(Movie t) {
		int id = t.getId();
		Movie matched = movies.stream().filter(movie -> movie.getId() == id).findFirst().orElse(null);
		if (matched != null) {
			matched.setDuration(t.getDuration());
			matched.setName(t.getName());
		}
		return t;
	}

}
