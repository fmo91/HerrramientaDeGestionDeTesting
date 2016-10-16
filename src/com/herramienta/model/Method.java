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
	
	// Public methods
	public void addLine(String line) {
		this.mLines.add(line);
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
