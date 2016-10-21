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
		
		// Por ejemplo, si tenemos -> public int sumar (int a, int b)
		String[] nameParts = mName	
				
				// Partimos por el parentesis que se abre y nos quedamos con la primera parte
				// en este caso, nos queda -> "public int sumar " 
				.split("\\(")[0]
						
				// Le sacamos los espacios en blanco del principio y del final, nos queda
				// -> "public int sumar"
				.trim()
				
				// Lo separamos por espacios en blanco
				// y nos queda ["public", "int", "sumar"]
				.split(" ");
		
		// Nos quedamos con la ultima parte, es decir -> "sumar",
		// y eso es el nombre
		String name = nameParts[nameParts.length - 1]; 
		
		return name;
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

		System.out.println("Empezamos a contar la cantidad de llamadas al metodo: " + method.getMainName());
		
		// Itero por todas las lineas del metodo
		Iterator<String> linesIterator = mLines.iterator();
		while (linesIterator.hasNext()) {
			String line = linesIterator.next();
			
			// Por cada linea que contenga el nombre del metodo
			// pasado por parametro, sumo 1 a la cantidad
			// de llamadas.
			if (line.contains(method.getMainName())) {
				System.out.println("La linea contiene el metodo! La linea es => " + line);
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
