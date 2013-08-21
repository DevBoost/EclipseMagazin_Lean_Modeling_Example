package de.eclipsemagazin.leanmodeling.rules;

public class BookingRules {
	
	protected RulesSupport rulesSupport;
	
	public BookingRules(RulesSupport rulesSupport) {
		super();
		this.rulesSupport = rulesSupport;
	}
	
	public void checkRules() throws BookingException {
		// generated code will be inserted here
		// The code in this method is generated from: /de.eclipsemagazin.leanmodeling/src/de/eclipsemagazin/leanmodeling/rules/BookingRules.natspec
		// Never change this method or any contents of this file, all local changes will be overwritten.
		
		// Flights must not be overbooked.
		rulesSupport.checkOverbooked();
		// Passengers must be at least 18 years old.
		rulesSupport.checkPassengerAge(18);
		// Airplanes of type Boing-737 require 6 reserved seats.
		rulesSupport.reservedSeats("Boing-737", 6);
		
	}
}