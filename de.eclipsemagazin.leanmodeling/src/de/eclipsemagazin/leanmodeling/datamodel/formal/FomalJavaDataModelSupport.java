package de.eclipsemagazin.leanmodeling.datamodel.formal;

import java.util.Date;
import java.util.List;

import de.devboost.natspec.annotations.TextSyntax;
import de.eclipsemagazin.leanmodeling.datamodel.AbstractDataModelSupport;
import de.eclipsemagazin.leanmodeling.datamodel.java.JavaClass;
import de.eclipsemagazin.leanmodeling.datamodel.java.JavaField;

public class FomalJavaDataModelSupport extends AbstractDataModelSupport {
	
	@TextSyntax("There is a class #1.")
	public JavaClass createClass(String name) {
		JavaClass newClass = new JavaClass(name);
		allClasses.add(newClass);
		return newClass;
	}

	@TextSyntax("Every #1 has a #2 which is a #3 property.")
	public void addProperty(JavaClass javaClass, List<String> nameParts, String typeName) {
		String propertyName = getPropertyName(nameParts);
		JavaClass type = getType(typeName);
		JavaField newField = new JavaField(propertyName, type);
		javaClass.addField(newField);
	}

	@TextSyntax("Every #1 has an #2 which refers to class #3.")
	public void addReference(JavaClass javaClass, List<String> nameParts,
			JavaClass otherClass) {

		String propertyName = getPropertyName(nameParts);
		JavaField newField = new JavaField(propertyName, otherClass);
		javaClass.addField(newField);
	}

	private JavaClass getType(String propertyType) {
		JavaClass type;
		if ("textual".equals(propertyType)) {
			type = new JavaClass(String.class.getName());
		} else if ("numeric".equals(propertyType)) {
			type = new JavaClass(int.class.getName());
		} else if ("date".equals(propertyType)) {
			type = new JavaClass(Date.class.getName());
		} else {
			throw new RuntimeException("Unknown type.");
		}
		return type;
	}
}
