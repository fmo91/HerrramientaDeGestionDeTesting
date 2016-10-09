package com.herramienta.services;

import com.herramienta.model.CodeMetric;

public class CodeLinesNumberInspectionService extends CodeInspectionService {
	
	private int mNumberOfLines = 0;

	@Override
	void analyzeLine(String codeLine) {
		// TODO Auto-generated method stub
		this.mNumberOfLines++;
	}

	@Override
	CodeMetric getMetric() {
		// TODO Auto-generated method stub
		CodeMetric m = new CodeMetric();
		m.setmName("Número de líneas");
		m.setmValue(String.valueOf(mNumberOfLines));
		return null;
	}

}
