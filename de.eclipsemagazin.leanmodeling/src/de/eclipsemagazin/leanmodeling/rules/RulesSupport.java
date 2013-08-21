package de.eclipsemagazin.leanmodeling.rules;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import de.devboost.natspec.annotations.TextSyntax;
import de.eclipsemagazin.leanmodeling.datamodel.Airplane;
import de.eclipsemagazin.leanmodeling.datamodel.BookEntry;
import de.eclipsemagazin.leanmodeling.datamodel.Flight;
import de.eclipsemagazin.leanmodeling.datamodel.Passenger;

public class RulesSupport {
	
	private Set<BookEntry> existingEntries;
	private BookEntry bookEntry;

	public RulesSupport(Set<BookEntry> existingEntries, BookEntry bookEntry) {
		super();
		this.existingEntries = existingEntries;
		this.bookEntry = bookEntry;
	}

	@TextSyntax("Flights must not be overbooked.")
	public void checkOverbooked() throws BookingException {
		Flight flight = bookEntry.getFlight();
		Airplane airplaneType = flight.getAirplaneType();
		int seatCount = airplaneType.getSeatCount();
		int bookedSeats = getBookedSeats(flight);
		if (seatCount <= bookedSeats) {
			throw new BookingException("No more free seats.");
		}
	}

	@TextSyntax("Passengers must be at least #1 years old.")
	public void checkPassengerAge(int minAge) throws BookingException {
		Passenger passenger = bookEntry.getPassenger();
		Date dateOfBirth = passenger.getDateOfBirth();
		int age = (int) (TimeUnit.DAYS.toDays(dateOfBirth.getTime() - System.currentTimeMillis()) / 365);
		if (age < minAge) {
			throw new BookingException("Passenger below minimum age.");
		}
	}

	@TextSyntax("Airplanes of type #1 require #2 reserved seats.")
	public void reservedSeats(String planeName, int reserveSeats) throws BookingException {
		Flight flight = bookEntry.getFlight();
		Airplane airplaneType = flight.getAirplaneType();
		if (!planeName.equals(airplaneType.getType())) {
			return;
		}
		
		int bookedSeats = getBookedSeats(flight);
		if (bookedSeats - 1 < reserveSeats) {
			throw new BookingException("Can't take reserve seat.");
		}
	}

	private int getBookedSeats(Flight flight) {
		int count = 0;
		for (BookEntry entry : existingEntries) {
			if (entry.getFlight() == flight) {
				count++;
			}
		}
		return count;
	}
}
