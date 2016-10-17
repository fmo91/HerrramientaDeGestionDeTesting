package com.herramienta.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.herramienta.model.Method;

public class MethodFinder {
	
	// El patron que vamos a usar para matchear metodos.
	// Stackoverflow -> http://stackoverflow.com/questions/68633/regex-that-will-match-a-java-method-declaration
	private static String methodPattern = "(public|protected|private|static|\\s) +[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;])";
	
	private Pattern pattern;
	
	/**
	 * Aqui iremos guardando todos los metodos que vamos encontrando
	 * */
	private ArrayList<Method> methods;
	
	/**
	 * Este es el metodo actual que estamos reconociendo.
	 * Cuando vamos a guardar todo el contenido del metodo dentro
	 * de cada uno de estos metodos.
	 * */
	private Method currentMethod;
	
	// Constructor
	public MethodFinder() {
	      this.pattern = Pattern.compile(MethodFinder.methodPattern);
	      this.methods = new ArrayList<Method>();
	}
	
	
	// Public methods
	
	/**
	 * Procesa la linea, revisa si es un metodo y lo va guardando dentro de la lista de metodos.
	 * */
	public void processLine(String line) {
		// Un matcher se encarga de validar
		// el patron del regex para una cadena
		// de texto en particular
		Matcher m = pattern.matcher(line);
		
		if (m.find()) {
			
			// Matcheo, lo que significa que se encontró un nuevo metodo.
			Method method = new Method(m.group(0).replaceAll("\\{", "").replaceAll("\\}", ""));
			
			methods.add(method);
			this.currentMethod = method;
		} else {
			// En este caso no matcheo, de modo que es una linea dentro de un metodo, 
			// o aun no se han encontrado metodos.
			
			// Todavia no hacemos nada.
		}
		
		// En todos los casos, agregariamos una linea nueva al 
		// texto del metodo actual.
		if(this.currentMethod != null) {
			this.currentMethod.addLine(line);
		}
	}
	
	public ArrayList<Method> getMethods() {
		return this.methods;
	}
	
	public String[] getMethodsNamesList() {
		ArrayList<String> methodsNamesList = new ArrayList<String>();
		Iterator<Method> methodsIterator = this.methods.iterator();

		while(methodsIterator.hasNext()) {
			Method m = methodsIterator.next();
			methodsNamesList.add(m.getName());
		}
		
		String[] methodsNamesArray = new String[methodsNamesList.size()];
		methodsNamesArray = methodsNamesList.toArray(methodsNamesArray);
		
		return methodsNamesArray;
	}
	
}
