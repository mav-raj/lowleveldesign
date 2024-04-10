package MovieBookingSystem.Models;

import java.util.List;
import java.util.HashMap;

public class Screen {
	private int id;
	private HashMap<Integer, List<Seat>> rows;

	public Screen(int id, HashMap<Integer, List<Seat>> rows) {
		this.id = id;
		this.rows = rows;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HashMap<Integer, List<Seat>> getRows() {
		return rows;
	}

	public void setRows(HashMap<Integer, List<Seat>> rows) {
		this.rows = rows;
	}

}
