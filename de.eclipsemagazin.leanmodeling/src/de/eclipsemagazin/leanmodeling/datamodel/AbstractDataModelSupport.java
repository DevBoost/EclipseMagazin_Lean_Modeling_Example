package de.eclipsemagazin.leanmodeling.datamodel;

import java.util.ArrayList;
import java.util.List;

import de.eclipsemagazin.leanmodeling.datamodel.java.JavaClass;

public abstract class AbstractDataModelSupport {

	protected List<JavaClass> allClasses = new ArrayList<JavaClass>();

	public List<JavaClass> getAllJavaClasses() {
		return allClasses;
	}

	protected String getClassName(String name) {
		return new StringUtil().toFirstUpper(name);
	}

	protected String getPropertyName(List<String> propertyNameParts) {
		String propertyName = "";
		int parts = propertyNameParts.size();
		for (int i = 0; i < parts; i++) {
			String nextPart = propertyNameParts.get(i);
			if (i > 0) {
				propertyName += new StringUtil().toFirstUpper(nextPart);
			} else {
				propertyName += nextPart;
			}
		}
		if (propertyName.endsWith(".")) {
			propertyName = propertyName.substring(0, propertyName.length() - 1);
		}
		return propertyName;
	}

	protected JavaClass getClass(String className) {
		for (JavaClass clazz : allClasses) {
			if (clazz.getName().equals(className)) {
				return clazz;
			}
		}
		throw new RuntimeException("Can't find class '" + className  + "'.");
	}
}
