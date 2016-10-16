package com.herramienta.services;

import com.herramienta.model.CodeMetric;

public class FanInInspectionService extends CodeInspectionService  {


	@Override
	public void analyzeLine(String codeLine) {
		
	}

	@Override
	public CodeMetric getMetric() {
		CodeMetric m = new CodeMetric();
		return m;
	}

}
