package de.eclipsemagazin.leanmodeling.datamodel.java;

import java.util.ArrayList;
import java.util.List;

public class JavaClass {

	private String name;
	private List<JavaField> fields = new ArrayList<JavaField>();

	public JavaClass(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public List<JavaField> getFields() {
		return fields;
	}

	public void addField(JavaField newField) {
		getFields().add(newField);
	}
}
