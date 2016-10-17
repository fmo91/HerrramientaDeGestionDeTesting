package com.herramienta.services;

import com.herramienta.model.CodeMetric;

public class CyclomaticComplexityInspectionService extends UncommentedCodeInspectionService {

	// Atributes
	private int valorCC = 0;
	
	// Constructor
	public CyclomaticComplexityInspectionService() { }
	
	// Methods
	@Override
	public void analyzeUncommentedLine(String codeLine) {
        //La complejidad ciclomatica mi­nima.
        this.valorCC = 1;
        //Listado de palabras que representan un salto en el curso de decision.
        String keywords[] = {"if", "else", "case", "default", "for", "while", "catch", "throw"};
        String condiciones[] = {"&&", "||"};
        int cantidad;
        
        if (codeLine.matches(".*\\W*(if|else|case|default|while|for|catch|throw)\\W.*")) {
        	for(String palabra : keywords) {
	        	cantidad = (codeLine.length() - codeLine.replace(palabra, "").length()) / palabra.length();
	        	if(cantidad > 0) {
	        		valorCC += cantidad;
	        	}
        	}
        }
        
        if (codeLine.matches(".*(&&|\\|\\|).*")) {
        	for(String simbolo : condiciones) {
        		cantidad = (codeLine.length() - codeLine.replace(simbolo, "").length()) / simbolo.length();
	        	if(cantidad > 0) {
	        		valorCC += cantidad;
	        	}
        	}
        }
	}

	@Override
	public CodeMetric getMetric() {
		CodeMetric m = new CodeMetric();
		m.setName("Complejidad ciclomática");
		m.setValue(String.valueOf(valorCC));
		return m;
	}

}
