package com.herramienta.services;

import java.util.ArrayList;
import java.util.Iterator;

import com.herramienta.model.CodeMetric;
import com.herramienta.model.Method;

public class FanOutInspectionService extends CodeInspectionService {

	// Atributos
	
	// El constructor pide una lista de metodos,
	// que son todos los metodos obtenidos 
	// en la inspeccion general de metodos.
	// Los necesitamos porque de esa manera podemos saber 
	// cuantas veces se invoca a un metodo
	// desde otro lado.
	private ArrayList<Method> methods;
	private Method inspectionedMethod;

	// Constructor
	public FanOutInspectionService(ArrayList<Method> methods, Method inspectionedMethod) {
		this.methods = methods;
		this.inspectionedMethod = inspectionedMethod;
	}
	
	// ----
	// Metodos de inspeccion de codigo
	
	@Override
	public void analyzeLine(String codeLine) {
		// No hace nada por cada linea...
	}

	@Override
	public CodeMetric getMetric() {
		// TODO: cambiar todo este metodo,
		// ahora tiene el contenido de Fan In.
		// Hay que lograr obtener que metodos hay aca adentro
		// es decir, cuantas llamadas hace hacia afuera.
		
		CodeMetric m = new CodeMetric();
		m.setName("Fan Out");
		
		int fanIn = 0;
		
		Iterator<Method> iterator = methods.iterator();
		while(iterator.hasNext()) {
			Method method = iterator.next();
			
			fanIn += method.getNumberOfCallsToMethod(this.inspectionedMethod);
		}
		
		m.setValue(String.valueOf(fanIn));
		return m;
	}



}
