package de.eclipsemagazin.leanmodeling.datamodel;

public class BookEntry {

	private Flight flight;
	private Passenger passenger;
	
	public BookEntry(Flight flight, Passenger passenger) {
		super();
		this.flight = flight;
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public Passenger getPassenger() {
		return passenger;
	}
}
