package MovieBookingSystem.Controller;

import java.util.ArrayList;
import java.util.List;

import MovieBookingSystem.Models.City;

public class CityController extends Controller<City> {
	private static CityController instance;
	private List<City> cities;

	private CityController() {
	}

	private CityController(List<City> cities) {
		this.cities = cities;
	}

	public static CityController getInstance(List<City> cities) {
		if (instance == null) {
			synchronized (CityController.class) {
				if (instance == null) {
					List<City> cList;
					if (cities != null) {
						cList = cities;
					} else
						cList = new ArrayList<>();
					instance = new CityController(cList);
					return instance;
				} else
					return instance;
			}
		} else
			return instance;
	}

	public City getCityByName(String name) {
		return this.cities.stream().filter(city -> city.getName().equals(name)).findFirst().orElse(null);
	}

	@Override
	public List<City> getAll() {
		return this.cities;
	}

	@Override
	public City setItem(City t) {
		cities.add(t);
		return t;
	}

	@Override
	public City updateItem(City t) {
		int id = t.getId();
		City matched = cities.stream().filter(city -> city.getId() == id).findFirst().orElse(null);
		if (matched != null) {
			matched.setName(t.getName());
		}
		return t;
	}

}
