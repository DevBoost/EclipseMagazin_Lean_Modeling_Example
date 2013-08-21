package de.eclipsemagazin.leanmodeling.datamodel.java;

public class JavaField {

	private String name;
	private JavaClass type;

	public JavaField(String name, JavaClass type) {
		super();
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public JavaClass getType() {
		return type;
	}
}
