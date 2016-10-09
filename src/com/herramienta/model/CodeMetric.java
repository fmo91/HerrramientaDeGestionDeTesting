package com.herramienta.model;

public class CodeMetric extends BaseModel {
	private String mName;
	private String mValue;
	
	
	// Constructors 
	public CodeMetric() {
		this.mName = "";
		this.mValue = "";
	}
	
	// Getters and setters 
	public String getName() {
		return mName;
	}
	public void setName(String mName) {
		this.mName = mName;
	}
	public String getValue() {
		return mValue;
	}
	public void setValue(String mValue) {
		this.mValue = mValue;
	}
	
}
