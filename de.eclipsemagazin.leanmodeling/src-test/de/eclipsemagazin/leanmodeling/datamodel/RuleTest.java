package de.eclipsemagazin.leanmodeling.datamodel;

import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Set;

import org.junit.Test;

import de.eclipsemagazin.leanmodeling.rules.BookingException;
import de.eclipsemagazin.leanmodeling.rules.BookingRules;
import de.eclipsemagazin.leanmodeling.rules.RulesSupport;

public class RuleTest {

	@Test
	public void testAgeCheck() throws ParseException {
		try {
			Set<BookEntry> existingEntries = Collections.emptySet();

			Airplane airplaneType = new Airplane();
			airplaneType.setSeatCount(200);

			Flight flight = new Flight();
			flight.setAirplaneType(airplaneType);
			
			Passenger passenger = new Passenger();
			passenger.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("2000-01-01"));
			
			BookEntry bookEntry = new BookEntry(flight, passenger);
			RulesSupport rulesSupport = new RulesSupport(existingEntries, bookEntry);
			BookingRules bookingRules = new BookingRules(rulesSupport);
			bookingRules.checkRules();
			fail("Passenger is too young, exception expected.");
		} catch (BookingException e) {
			// Do nothing, we expect this
		}
	}
}
