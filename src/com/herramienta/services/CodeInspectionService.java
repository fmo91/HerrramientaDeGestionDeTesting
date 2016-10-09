package com.herramienta.services;

import com.herramienta.model.CodeMetric;

public abstract class CodeInspectionService {
	public abstract void analyzeLine(String codeLine);
	public abstract CodeMetric getMetric();
}
