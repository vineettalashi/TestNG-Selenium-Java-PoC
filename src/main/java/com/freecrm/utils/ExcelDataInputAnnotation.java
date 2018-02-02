package com.freecrm.utils;

import org.testng.internal.annotations.BaseAnnotation;

public class ExcelDataInputAnnotation extends BaseAnnotation implements IExcelDataInputAnnotation{

	private String filename;
	private String sheetname;
	
	@Override
	public String getFilename() {
		return filename;
	}
	@Override
	public void setFilename(String filename) {
		this.filename = filename;
	}
	@Override
	public String getSheetname() {
		return sheetname;
	}
	@Override
	public void setSheetname(String sheetname) {
		this.sheetname = sheetname;
	}

}
