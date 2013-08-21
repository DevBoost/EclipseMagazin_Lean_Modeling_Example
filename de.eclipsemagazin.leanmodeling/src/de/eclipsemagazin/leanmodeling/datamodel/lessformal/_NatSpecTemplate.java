package de.eclipsemagazin.leanmodeling.datamodel.lessformal;

import java.io.IOException;

import de.eclipsemagazin.leanmodeling.datamodel.AbstractDataModelSupport;
import de.eclipsemagazin.leanmodeling.datamodel.AbstractNatSpecTemplate;

public class _NatSpecTemplate extends AbstractNatSpecTemplate {
	
	protected SemiFomalJavaDataModelSupport semiFomalJavaDataModelSupport = new SemiFomalJavaDataModelSupport();

	public static void main(String[] args) throws IOException {
		new _NatSpecTemplate().run();
	}

	public void createDataModel() {
		// generated code will be inserted here
		/* @MethodBody */
	}

	@Override
	protected AbstractDataModelSupport getDataModelSupport() {
		return semiFomalJavaDataModelSupport;
	}
}