package com.herramienta.services;

import com.herramienta.model.CodeMetric;

public class CodeLinesNumberInspectionService extends CodeInspectionService {
	
	private int mNumberOfLines = 0;
	
	private CommentedLinesInspectionService commentedLinesInspectionService = new CommentedLinesInspectionService(); 

	@Override
	public void analyzeLine(String codeLine) {
		// TODO Auto-generated method stub
		this.mNumberOfLines++;
		
	}

	@Override
	public CodeMetric getMetric() {
		// TODO Auto-generated method stub
		CodeMetric m = new CodeMetric();
		m.setName("Número de líneas");
		m.setValue(String.valueOf(mNumberOfLines));
		return m;
	}

}
