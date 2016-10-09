package com.herramienta.services;

import com.herramienta.model.CodeMetric;

public abstract class CodeInspectionService {
	abstract void analyzeLine(String codeLine);
	abstract CodeMetric getMetric();
}
