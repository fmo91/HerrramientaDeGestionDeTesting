package com.herramienta.services;

import com.herramienta.model.CodeMetric;

public class HalsteadInspectionService extends CodeInspectionService {
	
	@Override
	public void analyzeLine(String codeLine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CodeMetric getMetric() {
		// TODO Auto-generated method stub
		CodeMetric m = new CodeMetric();
		m.setName("Halstead");
		return m;
	}

}
