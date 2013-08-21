package de.eclipsemagazin.leanmodeling.datamodel.lessformal;

import java.io.IOException;

import de.eclipsemagazin.leanmodeling.datamodel.AbstractDataModelSupport;
import de.eclipsemagazin.leanmodeling.datamodel.AbstractNatSpecTemplate;

public class SemiFormalAirlineDataModel extends AbstractNatSpecTemplate {
	
	protected SemiFomalJavaDataModelSupport semiFomalJavaDataModelSupport = new SemiFomalJavaDataModelSupport();

	public static void main(String[] args) throws IOException {
		new SemiFormalAirlineDataModel().run();
	}

	public void createDataModel() {
		// generated code will be inserted here
		// The code in this method is generated from: /de.eclipsemagazin.leanmodeling/src/de/eclipsemagazin/leanmodeling/datamodel/lessformal/SemiFormalAirlineDataModel.natspec
		// Never change this method or any contents of this file, all local changes will be overwritten.
		
		// An airplane is a transportation vehicle.
		de.eclipsemagazin.leanmodeling.datamodel.java.JavaClass javaClass_airplane_transportation_vehicle_ = semiFomalJavaDataModelSupport.createClass("airplane", java.util.Arrays.asList(new java.lang.String[] {"transportation", "vehicle."}));
		// Every airplane has a type.
		semiFomalJavaDataModelSupport.createField("airplane", java.util.Arrays.asList(new java.lang.String[] {"type."}));
		// It also has a seat count.
		semiFomalJavaDataModelSupport.createField(java.util.Arrays.asList(new java.lang.String[] {"seat", "count."}), javaClass_airplane_transportation_vehicle_);
		// A passenger is a person who uses airline services.
		de.eclipsemagazin.leanmodeling.datamodel.java.JavaClass javaClass_passenger_person_who_uses_airline_services_ = semiFomalJavaDataModelSupport.createClass("passenger", java.util.Arrays.asList(new java.lang.String[] {"person", "who", "uses", "airline", "services."}));
		// Every passenger has a name.
		semiFomalJavaDataModelSupport.createField("passenger", java.util.Arrays.asList(new java.lang.String[] {"name."}));
		// He also has a date of birth.
		semiFomalJavaDataModelSupport.createField(java.util.Arrays.asList(new java.lang.String[] {"date", "of", "birth."}), javaClass_passenger_person_who_uses_airline_services_);
		// A flight is a travel service provided by an airline.
		de.eclipsemagazin.leanmodeling.datamodel.java.JavaClass javaClass_flight_travel_service_provided_by_an_airline_ = semiFomalJavaDataModelSupport.createClass("flight", java.util.Arrays.asList(new java.lang.String[] {"travel", "service", "provided", "by", "an", "airline."}));
		// Every flight has an airplane type.
		semiFomalJavaDataModelSupport.createField("flight", java.util.Arrays.asList(new java.lang.String[] {"airplane", "type."}));
		
	}

	@Override
	protected AbstractDataModelSupport getDataModelSupport() {
		return semiFomalJavaDataModelSupport;
	}
}