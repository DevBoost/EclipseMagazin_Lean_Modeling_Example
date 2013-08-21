package de.eclipsemagazin.leanmodeling.datamodel.lessformal;

import java.util.Date;
import java.util.List;

import de.devboost.natspec.annotations.TextSyntax;
import de.eclipsemagazin.leanmodeling.datamodel.AbstractDataModelSupport;
import de.eclipsemagazin.leanmodeling.datamodel.java.JavaClass;
import de.eclipsemagazin.leanmodeling.datamodel.java.JavaField;

public class SemiFomalJavaDataModelSupport extends AbstractDataModelSupport {

	@TextSyntax("A #1 is a #2")
	public JavaClass createClass(String name, List<String> description) {
		JavaClass newClass = new JavaClass(getClassName(name));
		allClasses.add(newClass);
		return newClass;
	}

	@TextSyntax("Every #1 has a #2")
	public void createField(String className, List<String> nameParts) {
		String propertyName = getPropertyName(nameParts);
		JavaClass type = getType(getPropertyName(nameParts));
		getClass(getClassName(className)).addField(new JavaField(propertyName, type));
	}

	@TextSyntax("It also has a #1")
	public void createField(List<String> nameParts, JavaClass clazz) {
		String propertyName = getPropertyName(nameParts);
		JavaClass type = getType(getPropertyName(nameParts));
		clazz.addField(new JavaField(propertyName, type));
	}

	private JavaClass getType(String propertyName) {
		if (propertyName.equals("name") || propertyName.equals("type")) {
			return new JavaClass(String.class.getName());
		}
		if (propertyName.equals("seatCount")) {
			return new JavaClass(int.class.getName());
		}
		if (propertyName.equals("airplaneType")) {
			return getClass("Airplane");
		}
		if (propertyName.equals("dateOfBirth")) {
			return new JavaClass(Date.class.getName());
		}
		
		throw new RuntimeException("No type defined for property '" + propertyName + "'");
	}
}
