package de.eclipsemagazin.leanmodeling.datamodel.formal;

import java.io.IOException;

import de.eclipsemagazin.leanmodeling.datamodel.AbstractDataModelSupport;
import de.eclipsemagazin.leanmodeling.datamodel.AbstractNatSpecTemplate;

public class FormalAirlineDataModel extends AbstractNatSpecTemplate {
	
	protected FomalJavaDataModelSupport fomalJavaDataModelSupport = new FomalJavaDataModelSupport();
	
	public static void main(String[] args) throws IOException {
		new FormalAirlineDataModel().run();
	}

	public void createDataModel() {
		// generated code will be inserted here
		// The code in this method is generated from: /de.eclipsemagazin.leanmodeling/src/de/eclipsemagazin/leanmodeling/datamodel/formal/FormalAirlineDataModel.natspec
		// Never change this method or any contents of this file, all local changes will be overwritten.
		
		// There is a class Airplane
		de.eclipsemagazin.leanmodeling.datamodel.java.JavaClass javaClass_Airplane = fomalJavaDataModelSupport.createClass("Airplane");
		// Every Airplane has a type which is a textual property.
		fomalJavaDataModelSupport.addProperty(javaClass_Airplane, java.util.Arrays.asList(new java.lang.String[] {"type"}), "textual");
		// Every Airplane has a seat count which is a numeric property.
		fomalJavaDataModelSupport.addProperty(javaClass_Airplane, java.util.Arrays.asList(new java.lang.String[] {"seat", "count"}), "numeric");
		// There is a class Passenger
		de.eclipsemagazin.leanmodeling.datamodel.java.JavaClass javaClass_Passenger = fomalJavaDataModelSupport.createClass("Passenger");
		// Every Passenger has a name which is a textual property.
		fomalJavaDataModelSupport.addProperty(javaClass_Passenger, java.util.Arrays.asList(new java.lang.String[] {"name"}), "textual");
		// Every Passenger has a date of birth which is a date property.
		fomalJavaDataModelSupport.addProperty(javaClass_Passenger, java.util.Arrays.asList(new java.lang.String[] {"date", "of", "birth"}), "date");
		// There is a class Flight
		de.eclipsemagazin.leanmodeling.datamodel.java.JavaClass javaClass_Flight = fomalJavaDataModelSupport.createClass("Flight");
		// Every Flight has an airplane type which refers to class Airplane
		fomalJavaDataModelSupport.addReference(javaClass_Flight, java.util.Arrays.asList(new java.lang.String[] {"airplane", "type"}), javaClass_Airplane);
		
	}

	@Override
	protected AbstractDataModelSupport getDataModelSupport() {
		return fomalJavaDataModelSupport;
	}
}