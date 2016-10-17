package com.herramienta.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Method extends BaseModel {
	// Attributes
	private String mName;
	private ArrayList<String> mLines;
	
	// Constructor
	public Method(String name) {
		this.mName = name;
		this.mLines = new ArrayList<String>();
	}
	
	// Getters and setters
	public String getName() {
		return mName;
	}
	public void setName(String mName) {
		this.mName = mName;
	}
	public ArrayList<String> getLines() {
		return mLines;
	}
	public void setLines(ArrayList<String> mLines) {
		this.mLines = mLines;
	}
	
	// Devuelve el nombre del metodo en sí.
	// Por ejemplo, si el metodo es public ArrayList<String> getLines(),
	// entonces este metodo devolverá getLines
	public String getMainName() {
		// TODO: Terminar este metodo
		return mName;
	}
	
	// Public methods
	public void addLine(String line) {
		this.mLines.add(line);
	}
	
	// Devuelve la cantidad de veces que este metodo llama a otro metodo
	// determinado
	public int getNumberOfCallsToMethod(Method method) {
		
		// La cantidad de llamadas que este metodo
		// realiza al metodo enviado por parametro
		// vamos a usar esta variable como 
		// acumulador.
		int numberOfCalls = 0;

		// Itero por todas las lineas del metodo
		Iterator<String> linesIterator = mLines.iterator();
		while (linesIterator.hasNext()) {
			String line = linesIterator.next();
			
			// Por cada linea que contenga el nombre del metodo
			// pasado por parametro, sumo 1 a la cantidad
			// de llamadas.
			if (line.contains(method.getMainName())) {
				numberOfCalls++;
			}
		}
		return numberOfCalls;
	}

	// toString
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		Iterator<String> linesIterator = this.mLines.iterator();
		while(linesIterator.hasNext()) {
			String line = linesIterator.next();
			sb.append(line);
			sb.append("\n");
		}
		
		return sb.toString().trim();
	}
}
