package MovieBookingSystem.Models;

import MovieBookingSystem.Enums.SeatType;

public class Seat {
	private int row;
	private int id;
	private SeatType seatType;

	public Seat(int row, int id, SeatType seatType) {
		this.row = row;
		this.id = id;
		this.seatType = seatType;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		// sb.append("Row: ");
		sb.append(row);
		sb.append("::");
		// sb.append("Seat: ");
		sb.append(id);
		sb.append(", ");
		return sb.toString();
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SeatType getSeatType() {
		return seatType;
	}

	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}

}
