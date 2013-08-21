package de.eclipsemagazin.leanmodeling.datamodel.java.codegen;

import de.eclipsemagazin.leanmodeling.datamodel.StringUtil;
import de.eclipsemagazin.leanmodeling.datamodel.java.JavaClass;
import de.eclipsemagazin.leanmodeling.datamodel.java.JavaField;

public class JavaCodeGenerator {

	private String packageName;
	
	public JavaCodeGenerator(String packageName) {
		super();
		this.packageName = packageName;
	}

	public String generateCode(JavaClass clazz) {
		StringBuilder code = new StringBuilder();
		code.append("package " + packageName + ";\n\n");
		code.append("public class " + clazz.getName() + " {\n\n");
		for (JavaField field : clazz.getFields()) {
			code.append(generateCode(field));
		}
		code.append("\n");
		for (JavaField field : clazz.getFields()) {
			code.append(generateGetSet(field));
		}
		code.append("}\n");
		return code.toString();
	}

	private Object generateGetSet(JavaField field) {
		StringBuilder code = new StringBuilder();
		String fieldName = field.getName();
		String methodName = new StringUtil().toFirstUpper(fieldName);
		
		code.append("\tpublic " + field.getType().getName() + " get" + methodName + "() {\n");
		code.append("\t\treturn " + fieldName + ";\n");
		code.append("\t}\n\n");
		
		code.append("\tpublic void set" + methodName + "(" + field.getType().getName() + " " + fieldName + ") {\n");
		code.append("\t\tthis." + fieldName + " = " + fieldName + ";\n");
		code.append("\t}\n\n");
		return code.toString();
	}

	private String generateCode(JavaField field) {
		StringBuilder code = new StringBuilder();
		JavaClass type = field.getType();
		if (type == null) {
			throw new RuntimeException("Field '" + field.getName() + "' has no type.");
		}
		code.append("\tprivate " + type.getName() + " " + field.getName() + ";\n");
		return code.toString();
	}
}
