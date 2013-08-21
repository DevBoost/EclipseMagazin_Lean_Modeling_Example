package de.eclipsemagazin.leanmodeling.datamodel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import de.eclipsemagazin.leanmodeling.datamodel.java.JavaClass;
import de.eclipsemagazin.leanmodeling.datamodel.java.codegen.JavaCodeGenerator;

public abstract class AbstractNatSpecTemplate {

	protected void run() throws IOException {
		String packageName = AbstractDataModelSupport.class.getPackage().getName();
		JavaCodeGenerator generator = new JavaCodeGenerator(packageName);

		createDataModel();
		List<JavaClass> javaClasses = getDataModelSupport().getAllJavaClasses();
		for (JavaClass javaClass : javaClasses) {
			String code = generator.generateCode(javaClass);
			String path = "src-gen" + File.separator + packageName.replace(".", File.separator) + File.separator + javaClass.getName() + ".java";
			File file = new File(path);
			System.out.println("AbstractNatSpecTemplate.run() " + file.getAbsolutePath());
			FileWriter writer = new FileWriter(file);
			writer.write(code);
			writer.close();
		}
	}

	protected abstract void createDataModel();

	protected abstract AbstractDataModelSupport getDataModelSupport();
}
