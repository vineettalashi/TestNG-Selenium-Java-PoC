package com.freecrm.helper.base;

public class Journey {
	
	public String sourcecity;
	public String destcity;
	
	public Journey(String Source, String Dest) {
		
		this.sourcecity = Source;
		this.destcity = Dest;
	}

	public String getSourceCity() {
		return sourcecity;
	}

	public String getDestCity() {
		return destcity;
	}

}
